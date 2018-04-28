package com.managerlee.assessment.model;

import com.managerlee.assessment.bean.SubmissionBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;

import java.util.List;

/**
 * Created by anins on 2018/4/28.
 */

public interface ISubmissionView {
    void getSubmissionList(int CompanyId, int UserId, int PageSize, int CurPage, CallBackListener<List<SubmissionBean>> listener);
}
