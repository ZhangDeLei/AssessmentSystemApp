package com.managerlee.assessment.model;

import com.managerlee.assessment.bean.ArticleBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.param.ArticleParam;

import java.util.List;

/**
 * Created by anins on 2018/4/26.
 */

public interface IArticleView {
    void getArticleList(ArticleParam param, CallBackListener<List<ArticleBean>> listener);

    void getArticleSiteList(int CompanyId, CallBackListener<List<ArticleBean>> listener);
}
