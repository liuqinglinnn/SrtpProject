package com.Lql.SRTP.service.ex;

public class BetterResultNotFoundException extends ServiceException{
    public BetterResultNotFoundException() {
        super();
    }

    public BetterResultNotFoundException(String message) {
        super(message);
    }

    public BetterResultNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BetterResultNotFoundException(Throwable cause) {
        super(cause);
    }

    protected BetterResultNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
