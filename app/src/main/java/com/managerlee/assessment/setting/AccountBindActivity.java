package com.managerlee.assessment.setting;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityAccountBindBinding;
import com.managerlee.assessment.framework.base.BaseActivity;

/**
 * 账号绑定
 * Created by anins on 2018/3/23.
 */

public class AccountBindActivity extends BaseActivity {
    private ActivityAccountBindBinding mBinding;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_account_bind);
    }

    @Override
    public void bindData() {

    }
}
