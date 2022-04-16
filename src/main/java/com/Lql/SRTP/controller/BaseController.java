package com.Lql.SRTP.controller;

import com.Lql.SRTP.service.ex.BetterResultNotFound;
import com.Lql.SRTP.service.ex.OidNotFoundException;
import com.Lql.SRTP.service.ex.ServiceException;
import com.Lql.SRTP.util.Jsonresult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class)
    public Jsonresult<Void> handleException(Throwable e) {
        Jsonresult<Void> result = new Jsonresult<Void>(e);
        if (e instanceof OidNotFoundException) {
            result.setState(4000);
        } else if (e instanceof BetterResultNotFound) {
            result.setState(4001);
        }
        return result;
    }
}
