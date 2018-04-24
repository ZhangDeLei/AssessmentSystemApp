package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.bean.LoginUserBean;
import com.managerlee.assessment.model.ILoginView;
import com.managerlee.assessment.service.LoginService;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/3/26.
 */

public class LoginViewImpl implements ILoginView {
    private LoginService loginService;

    public LoginViewImpl() {
        loginService = RetrofitHelper.init().getRetrofit().create(LoginService.class);
    }

    @Override
    public void login(String UserAccount, String Password, final CallBackListener<LoginUserBean> listener) {
        Map<String, String> params = new HashMap<>();
        params.put("UserAccount", UserAccount);
        params.put("Password", Password);
        loginService.login(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<LoginUserBean>>() {
                    @Override
                    public void onNext(ResponseData<LoginUserBean> userBeanResponseData) {
                        if (userBeanResponseData.getCode() == ResponseCode.SUCCESS) {
                            listener.onSuccess(userBeanResponseData.getData());
                        } else {
                            listener.onError(userBeanResponseData.getMsg());
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
