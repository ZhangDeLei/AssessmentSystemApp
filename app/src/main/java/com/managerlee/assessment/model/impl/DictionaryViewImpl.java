package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.bean.DictBean;
import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.model.IDictionaryView;
import com.managerlee.assessment.service.DictionaryService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/4/25.
 */

public class DictionaryViewImpl implements IDictionaryView {
    private DictionaryService service;

    public DictionaryViewImpl() {
        service = RetrofitHelper.init().getRetrofit().create(DictionaryService.class);
    }

    @Override
    public void getDictListByEnName(String enName, final CallBackListener<List<DictBean>> listener) {

        service.getDictListByEnName(enName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<List<DictBean>>>() {
                    @Override
                    public void onNext(ResponseData<List<DictBean>> response) {
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
