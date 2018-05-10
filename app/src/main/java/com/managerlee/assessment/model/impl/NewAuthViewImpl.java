package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.bean.NewBean;
import com.managerlee.assessment.bean.UserNewAuthBean;
import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.model.INewAuthView;
import com.managerlee.assessment.service.NewAuthService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * 站点巡查
 * Created by anins on 2018/4/24.
 */

public class NewAuthViewImpl implements INewAuthView {

    private NewAuthService service;

    public NewAuthViewImpl() {
        service = RetrofitHelper.init().getRetrofit().create(NewAuthService.class);
    }

    @Override
    public void getNewAuthList(final CallBackListener<List<NewBean>> listCallBackListener) {
        service.getNewAuthList(PerferenceConfig.CompanyId.get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<List<NewBean>>>() {
                    @Override
                    public void onNext(ResponseData<List<NewBean>> response) {
                        if (response.getCode() == ResponseCode.SUCCESS) {
                            listCallBackListener.onSuccess(response.getData());
                        } else {
                            listCallBackListener.onError(response.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        listCallBackListener.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        listCallBackListener.onCompleted();
                    }
                });
    }

    @Override
    public void getUserNewAuthList(final CallBackListener<List<UserNewAuthBean>> listener) {
        service.getUserNewAuthList(PerferenceConfig.CompanyId.get(),
                PerferenceConfig.UserId.get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<List<UserNewAuthBean>>>() {
                    @Override
                    public void onNext(ResponseData<List<UserNewAuthBean>> response) {
                        if (response.getCode() == ResponseCode.SUCCESS) {
                            listener.onSuccess(response.getData());
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
