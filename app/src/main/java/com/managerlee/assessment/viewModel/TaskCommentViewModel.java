package com.managerlee.assessment.viewModel;

import android.app.Activity;

import com.managerlee.assessment.adapter.TaskCommentAdapter;
import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.bean.UserCommentBean;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.IUserCommentView;
import com.managerlee.assessment.model.impl.UserCommentViewImpl;

import java.util.List;

/**
 * Created by anins on 2018/5/2.
 */

public class TaskCommentViewModel extends BaseViewModel {
    private IUserCommentView commentView;
    private TaskBean bean;
    private int PageSize = 10;
    private List<UserCommentBean> commentBeans;
    private TaskCommentAdapter adapter;
    private CompletedListener listener;

    public TaskCommentViewModel(Activity activity, TaskBean bean, TaskCommentAdapter adapter, CompletedListener listener) {
        super(activity);
        this.commentView = new UserCommentViewImpl();
        this.bean = bean;
        this.CurPage = 1;
        this.adapter = adapter;
        this.listener = listener;
        initData();
    }

    /**
     * 初始化数据
     */
    public void initData() {
        commentView.getUserCommentList(bean.getId(), PageSize, CurPage, new CallBackListener<List<UserCommentBean>>() {
            @Override
            public void onSuccess(List<UserCommentBean> data) {
                commentBeans = data;
                adapter.setData(data);
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
                listener.onCompleted();
            }

            @Override
            public void onCompleted() {
                listener.onCompleted();
            }
        });
    }
}
