package com.managerlee.assessment.param;

import com.managerlee.assessment.framework.base.BasePageParam;

/**
 * 文章查询参赛
 * Created by anins on 2018/4/26.
 */

public class ArticleParam extends BasePageParam {
    private int CompanyId;
    private String Title;

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

}
