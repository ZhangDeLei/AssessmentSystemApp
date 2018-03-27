package com.managerlee.assessment.service;

import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.bean.AppUpdateBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by anins on 2018/3/23.
 */

public interface UpdateService {
    /**
     * 获取最新版本信息
     * @return
     */
    @GET(URLConstant.GetNewVersion)
    Observable<ResponseData<AppUpdateBean>> getNewVersion();
}
