package com.managerlee.assessment.service;

import com.managerlee.assessment.bean.ArticleLevelBean;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.ResponseData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 文章级别服务
 * Created by anins on 2018/4/28.
 */

public interface ArticleLevelService {

    @GET(URLConstant.ArticleLevel_GetArticleLevelList)
    Observable<ResponseData<List<ArticleLevelBean>>> getArticleLevelList(@Query("CompanyId") int CompanyId,
                                                                         @Query("Name") String Name);

}
