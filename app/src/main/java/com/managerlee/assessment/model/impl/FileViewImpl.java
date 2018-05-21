package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.constant.FileType;
import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.model.IFileView;
import com.managerlee.assessment.service.FileService;

import java.io.File;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by anins on 2018/5/14.
 */

public class FileViewImpl implements IFileView {
    private FileService service;

    public FileViewImpl() {
        service = RetrofitHelper.init().getRetrofit().create(FileService.class);
    }

    @Override
    public void upload(File file,String type, final CallBackListener<String> listener) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        RequestBody requestType = RequestBody.create(MediaType.parse("multipart/form-data"), type);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        service.upload(body, requestType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<String>>() {
                    @Override
                    public void onNext(ResponseData<String> response) {
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
