package com.managerlee.assessment.viewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.managerlee.assessment.adapter.TaskAdapter;
import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.constant.PageConstant;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.ITaskView;
import com.managerlee.assessment.model.impl.TaskViewImpl;
import com.managerlee.assessment.view.SettingActivity;
import com.managerlee.assessment.view.TaskDetailActivity;
import com.managerlee.assessment.view.TaskReleaseActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anins on 2018/3/23.
 */

public class TaskViewModel {
    private Context context;
    private ITaskView taskView;
    private TaskAdapter mAdapter;
    private CompletedListener completedListener;

    public TaskViewModel(Context context, TaskAdapter mAdapter, CompletedListener completedListener) {
        this.context = context;
        this.taskView = new TaskViewImpl();
        this.mAdapter = mAdapter;
        this.completedListener = completedListener;
        initData();
    }

    /**
     * 初始化数据
     */
    public void initData() {
        Map<String, Object> params = new HashMap<>();
        params.put("UserId", PerferenceConfig.UserId.get());
        params.put("PageSize", PageConstant.PageSize);
        params.put("CurPage", PageConstant.CurPage);
        taskView.getTaskListByUserId(params, new CallBackListener<List<TaskBean>>() {
            @Override
            public void onSuccess(List<TaskBean> data) {
                mAdapter.setData(data);
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
            }

            @Override
            public void onCompleted() {
                completedListener.onCompleted();
            }
        });
    }

    /**
     * 任务发布
     *
     * @param view
     */
    public void gotoRelease(View view) {
        context.startActivity(new Intent(context, TaskReleaseActivity.class));
    }

    /**
     * 任务详细
     *
     * @param view
     */
    public void gotoDetail(View view) {
        context.startActivity(new Intent(context, TaskDetailActivity.class));
    }

    /**
     * 设置
     *
     * @param view
     */
    public void gotoSetting(View view) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }
}