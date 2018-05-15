package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.bean.UserCommentBean;
import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.PageData;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.model.IUserCommentView;
import com.managerlee.assessment.service.UserCommentService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/5/15.
 */

public class UserCommentViewImpl implements IUserCommentView {
    private UserCommentService service;

    public UserCommentViewImpl() {
        service = RetrofitHelper.init().getRetrofit().create(UserCommentService.class);
    }

    @Override
    public void getUserCommentList(int TaskId, int PageSize, int CurPage, final CallBackListener<List<UserCommentBean>> listener) {
        int CompanyId = PerferenceConfig.CompanyId.get();
        service.getCommentList(CompanyId, TaskId, PageSize, CurPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<PageData<UserCommentBean>>>() {
                    @Override
                    public void onNext(ResponseData<PageData<UserCommentBean>> response) {
                        if (response.getCode() == ResponseCode.SUCCESS) {
                            listener.onSuccess(response.getData().getList());
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

    @Override
    public void insert(UserCommentBean bean, final CallBackListener<String> listener) {
        service.insert(bean)
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
