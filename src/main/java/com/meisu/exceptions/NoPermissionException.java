package com.meisu.exceptions;

/**
 * @author Administrator
 * 没有权限异常
 */
public class NoPermissionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoPermissionException() {
        super();
    }

    public NoPermissionException(String message) {
        super(message);
    }

    public NoPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPermissionException(Throwable cause) {
        super(cause);
    }

    protected NoPermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
