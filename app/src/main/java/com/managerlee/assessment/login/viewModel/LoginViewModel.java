package com.managerlee.assessment.login.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.index.IndexActivity;

/**
 * Created by anins on 2018/3/22.
 */

public class LoginViewModel extends BaseViewModel {

    public LoginViewModel(Activity activity) {
        super(activity);
    }

    /**
     * 系统登陆
     *
     * @param view
     */
    public void login(View view) {
        activity.startActivity(new Intent(activity, IndexActivity.class));
    }

    /**
     * 推出系统
     *
     * @param view
     */
    public void exit(View view) {
        activity.finish();
    }
}
