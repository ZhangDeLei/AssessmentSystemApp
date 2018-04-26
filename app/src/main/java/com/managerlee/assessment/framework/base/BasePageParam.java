package com.managerlee.assessment.framework.base;

/**
 * Created by anins on 2018/4/26.
 */

public class BasePageParam {
    private int PageSize;
    private int CurPage;

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getCurPage() {
        return CurPage;
    }

    public void setCurPage(int curPage) {
        CurPage = curPage;
    }
}
