package com.managerlee.assessment.viewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.managerlee.assessment.view.AccountBindActivity;

/**
 * Created by anins on 2018/3/23.
 */

public class SettingViewModel {
    private Context context;

    public SettingViewModel(Context context) {
        this.context = context;
    }

    /**
     * 账号绑定
     *
     * @param view
     */
    public void gotoAccounBind(View view) {
        context.startActivity(new Intent(context, AccountBindActivity.class));
    }
}
