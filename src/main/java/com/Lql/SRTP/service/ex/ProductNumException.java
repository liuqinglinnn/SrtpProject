package com.Lql.SRTP.service.ex;

public class ProductNumException extends ServiceException{
    public ProductNumException() {
        super();
    }

    public ProductNumException(String message) {
        super(message);
    }

    public ProductNumException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNumException(Throwable cause) {
        super(cause);
    }

    protected ProductNumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
