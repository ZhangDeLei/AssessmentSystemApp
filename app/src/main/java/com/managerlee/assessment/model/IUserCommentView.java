package com.managerlee.assessment.model;

import com.managerlee.assessment.bean.UserCommentBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;

import java.util.List;

/**
 * Created by anins on 2018/5/15.
 */

public interface IUserCommentView {
    void getUserCommentList(int TaskId, int PageSize, int CurPage, CallBackListener<List<UserCommentBean>> listener);

    void insert(UserCommentBean bean, CallBackListener<String> listener);
}
