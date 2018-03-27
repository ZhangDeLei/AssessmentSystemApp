package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityTaskDetailBinding;
import com.managerlee.assessment.framework.base.BaseActivity;

/**
 * 任务详情
 * Created by anins on 2018/3/23.
 */

public class TaskDetailActivity extends BaseActivity {
    private ActivityTaskDetailBinding mBinding;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_task_detail);
    }

    @Override
    public void bindData() {

    }
}
