package com.managerlee.assessment.service;

import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.ResponseData;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by anins on 2018/5/14.
 */

public interface FileService {

    @Multipart
    @POST(URLConstant.File_Upload)
    Observable<ResponseData<String>> upload(@Part MultipartBody.Part file, @Part("type") RequestBody type);

}
