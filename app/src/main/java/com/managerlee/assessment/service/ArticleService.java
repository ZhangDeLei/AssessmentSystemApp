package com.managerlee.assessment.service;

import com.managerlee.assessment.bean.ArticleBean;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.PageData;
import com.managerlee.assessment.framework.http.data.ResponseData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 文章服务
 * Created by anins on 2018/4/25.
 */

public interface ArticleService {

    @GET(URLConstant.Article_GetArticleListForApp)
    Observable<ResponseData<PageData<ArticleBean>>> getArticleData(
            @Query("CompanyId") int CompanyId,
            @Query("Title") String Title,
            @Query("LevelId") int LevelId,
            @Query("PageSize") int PageSize,
            @Query("CurPage") int CurPage);

    @GET(URLConstant.Article_GetArticleTypeForApp)
    Observable<ResponseData<List<ArticleBean>>> getArticleSiteData(
            @Query("CompanyId") int CompanyId
    );
}
