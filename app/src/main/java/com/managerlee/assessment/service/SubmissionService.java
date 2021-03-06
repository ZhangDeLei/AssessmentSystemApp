package com.managerlee.assessment.service;

import com.managerlee.assessment.bean.SubmissionBean;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.PageData;
import com.managerlee.assessment.framework.http.data.ResponseData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 网评投稿
 * Created by anins on 2018/4/28.
 */

public interface SubmissionService {
    @GET(URLConstant.Sub_GetSubmissionListByUserId)
    Observable<ResponseData<PageData<SubmissionBean>>> getSubmissionList(@Query("CompanyId") int CompanyId,
                                                                         @Query("UserId") int UserId,
                                                                         @Query("PageSize") int PageSize,
                                                                         @Query("CurPage") int CurPage);

    @GET(URLConstant.Sub_GetSubmissionById)
    Observable<ResponseData<SubmissionBean>> getSubmissionById(@Query("Id") int Id);

    @POST(URLConstant.Sub_Insert)
    Observable<ResponseData<String>> insertSubmission(@Body SubmissionBean bean);

    @POST(URLConstant.Sub_Update)
    Observable<ResponseData<String>> updateSubmission(@Body SubmissionBean bean);

    @POST(URLConstant.Sub_Delete)
    Observable<ResponseData<String>> deleteSubmission(@Body Map<String, Integer> params);
}
