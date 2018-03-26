package com.managerlee.assessment.update.model.impl;

import android.util.Log;

import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.update.bean.AppUpdateBean;
import com.managerlee.assessment.update.model.IUpdateView;
import com.managerlee.assessment.update.service.UpdateService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/3/23.
 */

public class UpdateViewImpl implements IUpdateView {
    private UpdateService updateService;

    @Override
    public void getNewVersion(final CallBackListener<AppUpdateBean> listener) {
        updateService = RetrofitHelper.init().getRetrofit().create(UpdateService.class);


        updateService.getNewVersion()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<AppUpdateBean>>() {
                    @Override
                    public void onNext(ResponseData<AppUpdateBean> appUpdateBeanResponseData) {
                        if (appUpdateBeanResponseData.getCode() == 100) {
                            listener.onSuccess(appUpdateBeanResponseData.getData());
                        } else {
                            listener.onError(appUpdateBeanResponseData.getMsg());
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
