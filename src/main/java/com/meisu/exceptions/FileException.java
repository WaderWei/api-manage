package com.meisu.exceptions;

/**
 * 文件相关异常
 * @author Administrator
 */
public class FileException extends RuntimeException {
    public FileException() {
        super();
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileException(Throwable cause) {
        super(cause);
    }

    protected FileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
