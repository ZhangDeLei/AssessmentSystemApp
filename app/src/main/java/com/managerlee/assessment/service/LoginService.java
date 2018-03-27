package com.managerlee.assessment.service;

import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.bean.LoginUserBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 登陆服务
 * Created by anins on 2018/3/26.
 */

public interface LoginService {
    @POST(URLConstant.Login_URL)
    Observable<ResponseData<LoginUserBean>> login(@Body Map<String,String> params);
}
