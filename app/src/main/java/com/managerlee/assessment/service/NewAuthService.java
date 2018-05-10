package com.managerlee.assessment.service;

import com.managerlee.assessment.bean.NewBean;
import com.managerlee.assessment.bean.UserNewAuthBean;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.ResponseData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 新闻客户端服务
 * Created by anins on 2018/4/24.
 */

public interface NewAuthService {

    /**
     * 获取企业新闻客户端列表
     * @param CompanyId
     * @return
     */
    @GET(URLConstant.NewAuth_GetNewAuthListByCompanyId)
    Observable<ResponseData<List<NewBean>>> getNewAuthList(@Query("CompanyId") int CompanyId);

    /**
     * 获取授权的新闻客户端列表
     * @param CompanyId
     * @param UserId
     * @return
     */
    @GET(URLConstant.NewAuth_GetUserNewAuthList)
    Observable<ResponseData<List<UserNewAuthBean>>> getUserNewAuthList(@Query("CompanyId") int CompanyId,
                                                                       @Query("UserId") int UserId);
}
