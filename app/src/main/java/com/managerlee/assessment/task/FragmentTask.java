package com.managerlee.assessment.task;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.FragmentTaskBinding;
import com.managerlee.assessment.framework.base.BaseFragment;
import com.managerlee.assessment.task.viewModel.TaskViewModel;

/**
 * 任务列表
 * Created by anins on 2018/3/22.
 */

public class FragmentTask extends BaseFragment {
    private FragmentTaskBinding mBinding;
    private TaskViewModel viewModel;

    public static FragmentTask getInstance() {
        return new FragmentTask();
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_task;
    }

    @Override
    public void bindLayout(View contentView) {
        mBinding = DataBindingUtil.bind(contentView);
    }

    @Override
    public void bindData() {
        viewModel = new TaskViewModel(getActivity());
        mBinding.setViewModel(viewModel);
    }
}
