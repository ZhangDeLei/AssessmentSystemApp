package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;

import com.managerlee.assessment.bean.UserStatictisBean;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.SystemUtils;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.IUserView;
import com.managerlee.assessment.model.impl.UserViewImpl;
import com.managerlee.assessment.view.AccountBindActivity;
import com.managerlee.assessment.view.LoginActivity;

/**
 * Created by anins on 2018/3/23.
 */

public class SettingViewModel extends BaseViewModel {

    private IUserView userView;

    public ObservableField<String> versionCode = new ObservableField<>();//App Version
    public ObservableField<String> userName = new ObservableField<>();//用户名称
    public ObservableField<String> teamName = new ObservableField<>();//队伍名称
    public ObservableField<String> totalSub = new ObservableField<>();//投稿数
    public ObservableField<String> totalFollow = new ObservableField<>();//评论数
    public ObservableField<String> totalTask = new ObservableField<>();//完成任务数

    public SettingViewModel(Activity context) {
        this.activity = context;
        this.userView = new UserViewImpl();
        initData();
    }

    /**
     * Init
     */
    public void initData() {
        totalSub.set(String.valueOf(0));
        totalFollow.set(String.valueOf(0));
        totalTask.set(String.valueOf(0));
        versionCode.set(SystemUtils.currentVersionName(activity));
        userName.set(PerferenceConfig.NickName.get());
        getData();
    }

    /**
     * 账号绑定
     */
    public void gotoAccounBind() {
        activity.startActivity(new Intent(activity, AccountBindActivity.class));
    }

    /**
     * 返回登录页
     */
    public void gotoLogin() {
        activity.startActivity(new Intent(activity, LoginActivity.class));
    }

    /**
     * 获取数据
     */
    private void getData() {
        userView.getUserStatictis(PerferenceConfig.UserId.get(), new CallBackListener<UserStatictisBean>() {
            @Override
            public void onSuccess(UserStatictisBean data) {
                teamName.set(data.getTeamName());
                totalFollow.set(String.valueOf(data.getTotalFollow()));
                totalSub.set(String.valueOf(data.getTotalSub()));
                totalTask.set(String.valueOf(data.getTotalTask()));
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
