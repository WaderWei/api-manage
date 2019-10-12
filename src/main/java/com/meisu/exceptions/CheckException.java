package com.meisu.exceptions;

/**
 * @author Administrator
 * 检查异常
 */
public class CheckException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CheckException() {
        super();
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    protected CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
