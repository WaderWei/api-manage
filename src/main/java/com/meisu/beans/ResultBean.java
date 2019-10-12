package com.meisu.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 * 通用的controller返回给前端的结果
 */
@Data
@NoArgsConstructor
public class ResultBean<T> implements RB, Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 返回的消息
     */
    private String msg = "success";

    /**
     * 返回的标记
     */
    private int code = SUCCESS;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 成功返回数据
     *
     * @param data
     */
    public ResultBean(T data) {
        this.data = data;
    }

    /**
     * 失败返回数据
     *
     * @param err
     */
    public ResultBean(Throwable err) {
        this.msg = err.getMessage();
        this.code = FAIL;
    }

    /**
     * 设置返回信息
     *
     * @param msg
     * @return
     */
    public ResultBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * 设置返回code
     *
     * @param code
     * @return
     */
    public ResultBean setCode(int code) {
        this.code = code;
        return this;
    }

    /**
     * 设置返回数据
     *
     * @param data
     * @return
     */
    public ResultBean setData(T data) {
        this.data = data;
        return this;
    }
}
