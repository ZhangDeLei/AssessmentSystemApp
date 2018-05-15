package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityTaskReleaseBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.viewModel.TaskReleaseViewModel;

/**
 * 发布任务
 * Created by anins on 2018/3/23.
 */

public class TaskReleaseActivity extends BaseActivity {

    private ActivityTaskReleaseBinding mBinding;
    private TaskReleaseViewModel viewModel;
    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_task_release);
    }

    @Override
    public void bindData() {
        viewModel = new TaskReleaseViewModel(this);
        mBinding.setViewModel(viewModel);
    }
}
