package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivitySettingBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.viewModel.SettingViewModel;

/**
 * 设置
 * Created by anins on 2018/3/23.
 */

public class SettingActivity extends BaseActivity {
    private ActivitySettingBinding mBinding;
    private SettingViewModel viewModel;
    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_setting);
    }

    @Override
    public void bindData() {
        viewModel = new SettingViewModel(this);
        mBinding.setViewModel(viewModel);
    }
}
