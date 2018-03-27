package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityTaskCommentBinding;
import com.managerlee.assessment.framework.base.BaseActivity;

/**
 * 任务评论列表
 * Created by anins on 2018/3/23.
 */

public class TaskCommentActivity extends BaseActivity {
    private ActivityTaskCommentBinding mBinding;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_task_comment);
    }

    @Override
    public void bindData() {

    }
}
