package com.managerlee.assessment.model;

import com.managerlee.assessment.bean.ArticleLevelBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;

import java.util.List;

/**
 * Created by anins on 2018/4/28.
 */

public interface IArticleLevelView {
    void getArticleLevelList(int CompanyId, String Name, CallBackListener<List<ArticleLevelBean>> listener);
}
