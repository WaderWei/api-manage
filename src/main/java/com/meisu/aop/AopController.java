package com.meisu.aop;

import com.meisu.beans.PageResultBean;
import com.meisu.beans.RB;
import com.meisu.beans.ResultBean;
import com.meisu.exceptions.CheckException;
import com.meisu.exceptions.FileException;
import com.meisu.exceptions.NoPermissionException;
import com.meisu.exceptions.UnLoginException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * 异常统一处理
 */
@Aspect
@Component
@Slf4j
public class AopController {
    private ThreadLocal<ResultBean<?>> resultBeanThreadLocal = new ThreadLocal<>();
    private ThreadLocal<PageResultBean<?>> pageResultBeanThreadLocal = new ThreadLocal<>();
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public com.meisu.beans.PageResultBean *(..))")
    public void handlerPageResultBeanMethod() {
    }

    @Pointcut("execution(public com.meisu.beans.ResultBean *(..))")
    public void handlerResultBeanMethod() {
    }


    @Around(value = "handlerPageResultBeanMethod()")
    public Object handlerPageResultBeanMethod(ProceedingJoinPoint pjp) {
        startTime.set(System.currentTimeMillis());
        try {
            pageResultBeanThreadLocal.set((PageResultBean<?>) pjp.proceed());
            log.info(pjp.getSignature().getName() + "--->方法执行耗时: " + (System.currentTimeMillis() - startTime.get()));
        } catch (Throwable throwable) {
            ResultBean<?> resultBean = handlerException(pjp, throwable);
            pageResultBeanThreadLocal.set(new PageResultBean<>().setCode(resultBean.getCode()).setMsg(resultBean.getMsg()));
        }
        return pageResultBeanThreadLocal.get();
    }

    @Around(value = "handlerResultBeanMethod()")
    public Object handlerResultBeanMethod(ProceedingJoinPoint pjp) {
        startTime.set(System.currentTimeMillis());
        try {
            resultBeanThreadLocal.set((ResultBean<?>) pjp.proceed());
            log.info(pjp.getSignature().getName() + "--->方法执行耗时: " + (System.currentTimeMillis() - startTime.get()));
        } catch (Throwable throwable) {
            resultBeanThreadLocal.set(handlerException(pjp, throwable));
        }
        return resultBeanThreadLocal.get();
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> resultBean = new ResultBean<>();
        log.error(pjp.getSignature().getName() + "---->方法发生异常：" + e.toString());
        if (e instanceof CheckException) {
            resultBean.setCode(RB.FAIL).setMsg(e.getLocalizedMessage());
        } else if (e instanceof NoPermissionException) {
            resultBean.setCode(RB.NO_PERMISSION).setMsg("no permission");
        } else if (e instanceof UnLoginException) {
            resultBean.setCode(RB.NO_LOGIN).setMsg("no login");
        } else if (e instanceof FileException) {
            resultBean.setCode(RB.FAIL).setMsg(e.getLocalizedMessage());
        } else {
            //未知异常发生后，要及时通知负责人（邮件）
            resultBean.setCode(RB.UNKNOWN_EXCEPTION).setMsg(e.toString());
        }
        return resultBean;
    }
}
