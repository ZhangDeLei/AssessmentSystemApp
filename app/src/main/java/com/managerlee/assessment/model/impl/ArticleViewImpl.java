package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.bean.ArticleBean;
import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.PageData;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.model.IArticleView;
import com.managerlee.assessment.param.ArticleParam;
import com.managerlee.assessment.service.ArticleService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/4/26.
 */

public class ArticleViewImpl implements IArticleView {
    private ArticleService service;

    public ArticleViewImpl() {
        service = RetrofitHelper.init().getRetrofit().create(ArticleService.class);
    }

    @Override
    public void getArticleList(ArticleParam param, final CallBackListener<List<ArticleBean>> listener) {
        service.getArticleData(
                param.getCompanyId(),
                param.getTitle(),
                param.getUserId(),
                param.getTypeId(),
                param.getPageSize(),
                param.getCurPage())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<PageData<ArticleBean>>>() {
                    @Override
                    public void onNext(ResponseData<PageData<ArticleBean>> response) {
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
}
