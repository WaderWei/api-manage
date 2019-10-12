package com.meisu.exceptions;

/**
 * @author Administrator
 * 未登录异常
 */
public class UnLoginException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnLoginException() {
        super();
    }

    public UnLoginException(String message) {
        super(message);
    }

    public UnLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnLoginException(Throwable cause) {
        super(cause);
    }

    protected UnLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
