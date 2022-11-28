package com.Lql.SRTP.controller;

import com.Lql.SRTP.service.ex.*;
import com.Lql.SRTP.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>(e);
        if (e instanceof OidNotFoundException) {
            result.setState(4000);
        } else if (e instanceof BetterResultNotFoundException) {
            result.setState(4001);
        }else if (e instanceof PidNotFoundException) {
            result.setState(4002);
        }else if (e instanceof ProductNumException) {
            result.setState(4003);
        }
        return result;
    }
}
