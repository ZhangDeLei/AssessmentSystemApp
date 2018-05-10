package com.managerlee.assessment.service;

import com.managerlee.assessment.bean.UserStatictisBean;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.ResponseData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 用户信息管理
 * Created by anins on 2018/5/10.
 */

public interface UserService {

    @GET(URLConstant.User_GetUserStatictis)
    Observable<ResponseData<UserStatictisBean>> getUserStatictis(@Query("Id") int Id);
}
