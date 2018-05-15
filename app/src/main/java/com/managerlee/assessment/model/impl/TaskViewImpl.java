package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.bean.TaskInfo;
import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.PageData;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.model.ITaskView;
import com.managerlee.assessment.service.TaskService;

import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/3/27.
 */

public class TaskViewImpl implements ITaskView {
    private TaskService taskService;

    public TaskViewImpl() {
        taskService = RetrofitHelper.init().getRetrofit().create(TaskService.class);
    }

    @Override
    public void getTaskListByUserId(Map<String, Object> params, final CallBackListener<List<TaskBean>> listener) {
        taskService.getUserTaskList(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<PageData<TaskBean>>>() {
                    @Override
                    public void onNext(ResponseData<PageData<TaskBean>> pageDataResponseData) {
                        if (pageDataResponseData.getCode() == ResponseCode.SUCCESS) {
                            listener.onSuccess(pageDataResponseData.getData().getList());
                        } else {
                            listener.onError(pageDataResponseData.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        listener.onCompleted();
                    }
                });
    }

    @Override
    public void createTask(TaskInfo bean, final CallBackListener<String> listener) {
        taskService.insert(bean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<String>>() {
                    @Override
                    public void onNext(ResponseData<String> response) {
                        if (response.getCode() == ResponseCode.SUCCESS) {
                            listener.onSuccess(response.getMsg());
                        } else {
                            listener.onError(response.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        listener.onCompleted();
                    }
                });
    }
}
