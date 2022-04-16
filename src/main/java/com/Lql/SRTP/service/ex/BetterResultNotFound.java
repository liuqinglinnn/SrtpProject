package com.Lql.SRTP.service.ex;

public class BetterResultNotFound extends ServiceException{
    public BetterResultNotFound() {
        super();
    }

    public BetterResultNotFound(String message) {
        super(message);
    }

    public BetterResultNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BetterResultNotFound(Throwable cause) {
        super(cause);
    }

    protected BetterResultNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
