package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;

import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.view.TaskCommentActivity;

/**
 * Created by anins on 2018/5/2.
 */

public class TaskDetailViewModel extends BaseViewModel {

    public TaskDetailViewModel(Activity activity) {
        super(activity);
    }

    /**
     * 跳转至评论列表界面
     *
     * @param bean
     */
    public void gotoCommentList(TaskBean bean) {
        Intent in = new Intent(activity, TaskCommentActivity.class);
        in.putExtra("task", bean);
        activity.startActivity(in);
    }

}
