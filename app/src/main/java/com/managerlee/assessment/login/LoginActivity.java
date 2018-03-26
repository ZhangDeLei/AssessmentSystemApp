package com.managerlee.assessment.login;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityLoginBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.login.viewModel.LoginViewModel;

/**
 * Created by anins on 2018/3/22.
 */

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding mBinding;
    private LoginViewModel viewModel;


    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_login);
    }

    @Override
    public void bindData() {
        viewModel = new LoginViewModel(mAct);
        mBinding.setViewModel(viewModel);
    }
}
