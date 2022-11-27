package com.Lql.SRTP.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JsonResult<E> implements Serializable {

    public static final int SUCCESS_CODE = 200;
    public static final int FAILURE_CODE = -1;

    /**
     * 状态码
     */
    private Integer state;
    /**
     * 数据
     */
    private E data;
    /**
     * 状态描述信息
     */
    private String message;

    public JsonResult() {
        super();
    }

    public JsonResult(Integer state) {
        super();
        this.state = state;
    }

    /**
     * 出现异常时调用
     */
    public JsonResult(Throwable e) {
        super();
        // 获取异常对象中的异常信息
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        super();
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public static JsonResult<Object> success(Object data) {
        return new JsonResult<Object>(SUCCESS_CODE, data, "success");
    }

    public static JsonResult<Object> failure(String msg) {
        return new JsonResult<Object>(FAILURE_CODE, null, msg);
    }
}
