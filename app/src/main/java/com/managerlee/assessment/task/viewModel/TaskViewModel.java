package com.managerlee.assessment.task.viewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.managerlee.assessment.setting.SettingActivity;
import com.managerlee.assessment.task.TaskDetailActivity;
import com.managerlee.assessment.task.TaskReleaseActivity;

/**
 * Created by anins on 2018/3/23.
 */

public class TaskViewModel {
    private Context context;

    public TaskViewModel(Context context) {
        this.context = context;
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
