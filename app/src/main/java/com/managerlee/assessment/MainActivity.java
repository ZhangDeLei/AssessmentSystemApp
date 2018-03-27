package com.managerlee.assessment;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.databinding.ActivityMainBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.viewModel.UpdateViewModel;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding mBinding;
    private UpdateViewModel viewModel;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_main);
    }

    @Override
    public void bindData() {
        viewModel = new UpdateViewModel(mAct);
        mBinding.setViewModel(viewModel);
    }
}
