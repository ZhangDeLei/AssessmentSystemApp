package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.bean.ArticleLevelBean;
import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.model.IArticleLevelView;
import com.managerlee.assessment.service.ArticleLevelService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/4/28.
 */

public class ArticleLevelViewImpl implements IArticleLevelView {

    private ArticleLevelService service;

    public ArticleLevelViewImpl() {
        service = RetrofitHelper.init().getRetrofit().create(ArticleLevelService.class);
    }

    @Override
    public void getArticleLevelList(int CompanyId, String Name, final CallBackListener<List<ArticleLevelBean>> listener) {
        service.getArticleLevelList(CompanyId, Name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<List<ArticleLevelBean>>>() {
                    @Override
                    public void onNext(ResponseData<List<ArticleLevelBean>> response) {
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
