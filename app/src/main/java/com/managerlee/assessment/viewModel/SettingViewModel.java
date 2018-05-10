package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;

import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.SystemUtils;
import com.managerlee.assessment.view.AccountBindActivity;

/**
 * Created by anins on 2018/3/23.
 */

public class SettingViewModel extends BaseViewModel {

    public ObservableField<String> versionCode = new ObservableField<>();//App Version
    public ObservableField<String> userName = new ObservableField<>();//用户名称
    public ObservableField<String> teamName = new ObservableField<>();//队伍名称

    public SettingViewModel(Activity context) {
        this.activity = context;
        initData();
    }

    /**
     * Init
     */
    public void initData() {
        versionCode.set(SystemUtils.currentVersionName(activity));
        userName.set(PerferenceConfig.NickName.get());
    }

    /**
     * 账号绑定
     */
    public void gotoAccounBind() {
        activity.startActivity(new Intent(activity, AccountBindActivity.class));
    }
}
