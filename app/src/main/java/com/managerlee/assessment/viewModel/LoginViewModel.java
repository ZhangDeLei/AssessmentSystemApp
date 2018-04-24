package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.managerlee.assessment.databinding.ActivityLoginBinding;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.view.IndexActivity;
import com.managerlee.assessment.bean.LoginUserBean;
import com.managerlee.assessment.model.ILoginView;
import com.managerlee.assessment.model.impl.LoginViewImpl;

/**
 * Created by anins on 2018/3/22.
 */

public class LoginViewModel extends BaseViewModel {

    public ObservableField<String> userAccount;
    public ObservableField<String> password;
    private ILoginView loginView;
    private ActivityLoginBinding mBinding;

    public LoginViewModel(Activity activity, ActivityLoginBinding mBinding) {
        super(activity);
        this.mBinding = mBinding;
        loginView = new LoginViewImpl();
        initData();
    }

    /**
     * 系统登陆
     *
     * @param view
     */
    public void login(View view) {
        String userAccount = mBinding.etUserAccount.getText().toString();
        String password = mBinding.etPassword.getText().toString();
        loginView.login(userAccount, password, new CallBackListener<LoginUserBean>() {
            @Override
            public void onSuccess(LoginUserBean data) {
                PerferenceConfig.TOKEN.set(data.getToken());
                PerferenceConfig.UserAccount.set(data.getUser().getUserAccount());
                PerferenceConfig.NickName.set(data.getUser().getNickName());
                PerferenceConfig.UserId.set(data.getUser().getId());
                PerferenceConfig.CompanyId.set(data.getCompany().getId());
                activity.finish();
                activity.startActivity(new Intent(activity, IndexActivity.class));
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

    /**
     * 推出系统
     *
     * @param view
     */
    public void exit(View view) {
        activity.finish();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        userAccount = new ObservableField<>();
        password = new ObservableField<>();
    }
}
