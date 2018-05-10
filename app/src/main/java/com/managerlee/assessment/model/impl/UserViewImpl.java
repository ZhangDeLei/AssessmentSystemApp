package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.bean.UserStatictisBean;
import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.model.IUserView;
import com.managerlee.assessment.service.UserService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/5/10.
 */

public class UserViewImpl implements IUserView {
    private UserService service;

    public UserViewImpl() {
        service = RetrofitHelper.init().getRetrofit().create(UserService.class);
    }

    @Override
    public void getUserStatictis(int Id, final CallBackListener<UserStatictisBean> listener) {
        service.getUserStatictis(Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<UserStatictisBean>>() {
                    @Override
                    public void onNext(ResponseData<UserStatictisBean> response) {
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
