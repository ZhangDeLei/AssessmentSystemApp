package com.managerlee.assessment.task;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityTaskReleaseBinding;
import com.managerlee.assessment.framework.base.BaseActivity;

/**
 * 发布任务
 * Created by anins on 2018/3/23.
 */

public class TaskReleaseActivity extends BaseActivity {
    private ActivityTaskReleaseBinding mBinding;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_task_release);
    }

    @Override
    public void bindData() {

    }
}
