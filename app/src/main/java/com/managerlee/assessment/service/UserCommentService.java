package com.managerlee.assessment.service;

import com.managerlee.assessment.bean.UserCommentBean;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.PageData;
import com.managerlee.assessment.framework.http.data.ResponseData;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by anins on 2018/5/15.
 */

public interface UserCommentService {

    @GET(URLConstant.Comment_GetUserCommentList)
    Observable<ResponseData<PageData<UserCommentBean>>> getCommentList(@Query("CompanyId") int CompanyId,
                                                                       @Query("TaskId") int TaskId,
                                                                       @Query("PageSize") int PageSize,
                                                                       @Query("CurPage") int CurPage);

    @POST(URLConstant.Comment_Insert)
    Observable<ResponseData<String>> insert(@Body UserCommentBean bean);
}
