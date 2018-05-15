package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.managerlee.assessment.adapter.TaskAdapter;
import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.constant.PageConstant;
import com.managerlee.assessment.framework.base.BaseViewModel;
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

public class TaskViewModel extends BaseViewModel{
    private ITaskView taskView;
    private TaskAdapter mAdapter;
    private CompletedListener completedListener;
    public ObservableField<String> title = new ObservableField<>();//标题内容

    public TaskViewModel(Activity context, TaskAdapter mAdapter, CompletedListener completedListener) {
        super(context);
        this.taskView = new TaskViewImpl();
        this.mAdapter = mAdapter;
        this.completedListener = completedListener;
        this.title.set("");
        initData();
    }

    /**
     * 初始化数据
     */
    public void initData() {
        Map<String, Object> params = new HashMap<>();
        params.put("UserId", PerferenceConfig.UserId.get());
        params.put("PageSize", PageConstant.PageSize);
        params.put("CurPage", CurPage);
        params.put("Title", title.get());
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
        activity.startActivity(new Intent(activity, TaskReleaseActivity.class));
    }

    /**
     * 任务详细
     *
     * @param view
     */
    public void gotoDetail(View view) {
        activity.startActivity(new Intent(activity, TaskDetailActivity.class));
    }

    /**
     * 设置
     *
     * @param view
     */
    public void gotoSetting(View view) {
        activity.startActivity(new Intent(activity, SettingActivity.class));
    }

    /**
     * 文本切换
     */
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        title.set(s.toString());
        initData();
    }
}
