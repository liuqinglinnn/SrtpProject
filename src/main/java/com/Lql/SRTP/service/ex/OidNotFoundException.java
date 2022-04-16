package com.Lql.SRTP.service.ex;

public class OidNotFoundException extends ServiceException{
    public OidNotFoundException() {
        super();
    }

    public OidNotFoundException(String message) {
        super(message);
    }

    public OidNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OidNotFoundException(Throwable cause) {
        super(cause);
    }

    protected OidNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
