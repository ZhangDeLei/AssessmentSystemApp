package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.bean.SubmissionBean;
import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.PageData;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.model.ISubmissionView;
import com.managerlee.assessment.service.SubmissionService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/4/28.
 */

public class SubmissionViewImpl implements ISubmissionView {
    private SubmissionService service;

    public SubmissionViewImpl() {
        service = RetrofitHelper.init().getRetrofit().create(SubmissionService.class);
    }

    @Override
    public void getSubmissionList(int CompanyId, int UserId, int PageSize, int CurPage, final CallBackListener<List<SubmissionBean>> listener) {
        service.getSubmissionList(CompanyId, UserId, PageSize, CurPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<PageData<SubmissionBean>>>() {
                    @Override
                    public void onNext(ResponseData<PageData<SubmissionBean>> response) {
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
