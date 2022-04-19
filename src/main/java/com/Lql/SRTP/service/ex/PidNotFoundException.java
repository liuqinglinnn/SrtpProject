package com.Lql.SRTP.service.ex;

public class PidNotFoundException extends ServiceException{
    public PidNotFoundException() {
        super();
    }

    public PidNotFoundException(String message) {
        super(message);
    }

    public PidNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PidNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PidNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
