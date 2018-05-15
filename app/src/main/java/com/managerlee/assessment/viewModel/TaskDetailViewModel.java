package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.EditText;

import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.view.TaskCommentActivity;

/**
 * Created by anins on 2018/5/2.
 */

public class TaskDetailViewModel extends BaseViewModel {

    public ObservableField<Integer> visible = new ObservableField<>();
    public ObservableField<Integer> sendVisible = new ObservableField<>();

    public TaskDetailViewModel(Activity activity) {
        super(activity);
        visible.set(View.VISIBLE);
        sendVisible.set(View.GONE);
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

    public void setIsFocus(boolean focus) {
        visible.set(focus ? View.GONE : View.VISIBLE);
        sendVisible.set(focus ? View.VISIBLE : View.GONE);
    }
}
