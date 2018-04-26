package com.managerlee.assessment.param;

import com.managerlee.assessment.framework.base.BasePageParam;

/**
 * 文章查询参赛
 * Created by anins on 2018/4/26.
 */

public class ArticleParam extends BasePageParam {
    private int CompanyId;
    private String Title;
    private Integer UserId;
    private Integer TypeId;

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

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getTypeId() {
        return TypeId;
    }

    public void setTypeId(Integer typeId) {
        TypeId = typeId;
    }
}
