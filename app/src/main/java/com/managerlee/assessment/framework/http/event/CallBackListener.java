package com.managerlee.assessment.framework.http.event;

/**
 * Created by anins on 2018/3/23.
 */

public abstract class CallBackListener<T> {
    public abstract void onSuccess(T data);

    public abstract void onError(String msg);

    public abstract void onCompleted();
}
