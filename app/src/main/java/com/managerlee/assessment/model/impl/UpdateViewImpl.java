package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.bean.AppUpdateBean;
import com.managerlee.assessment.model.IUpdateView;
import com.managerlee.assessment.service.UpdateService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/3/23.
 */

public class UpdateViewImpl implements IUpdateView {
    private UpdateService updateService;

    public UpdateViewImpl() {
        updateService = RetrofitHelper.init().getRetrofit().create(UpdateService.class);
    }

    @Override
    public void getNewVersion(final CallBackListener<AppUpdateBean> listener) {
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
