package com.managerlee.assessment.setting;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivitySettingBinding;
import com.managerlee.assessment.framework.base.BaseActivity;

/**
 * 设置
 * Created by anins on 2018/3/23.
 */

public class SettingActivity extends BaseActivity {
    private ActivitySettingBinding mBinding;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_setting);
    }

    @Override
    public void bindData() {

    }
}
