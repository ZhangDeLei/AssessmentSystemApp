package com.managerlee.assessment.framework.http.data;

import io.reactivex.annotations.Nullable;

/**
 * Created by anins on 2018/3/23.
 */

public class ResponseData<T> {
    private int code;
    private String msg;

    @Nullable
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
