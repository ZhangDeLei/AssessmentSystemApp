package com.managerlee.assessment.update.viewModel;

import android.app.Activity;
import android.content.Intent;

import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.config.GlobalConfig;
import com.managerlee.assessment.framework.dialog.ConfirmDialog;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.utils.SystemUtils;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.login.LoginActivity;
import com.managerlee.assessment.update.bean.AppUpdateBean;
import com.managerlee.assessment.update.model.IUpdateView;
import com.managerlee.assessment.update.model.impl.UpdateViewImpl;

/**
 * Created by anins on 2018/3/23.
 */

public class UpdateViewModel extends BaseViewModel {
    private IUpdateView updateView;

    public UpdateViewModel(Activity activity) {
        super(activity);
        updateView = new UpdateViewImpl();
        initData();
    }

    private void initData() {
        updateView.getNewVersion(new CallBackListener<AppUpdateBean>() {
            @Override
            public void onSuccess(AppUpdateBean data) {
                ConfirmDialog dialog = new ConfirmDialog(activity, "测试", "1111");
                dialog.show();
//                if (data.getVersionCode() == SystemUtils.currentVersionCode(context)) {
//                    context.startActivity(new Intent(context, LoginActivity.class));
//                } else {
//                    ToastUtils.show("请先更新");
//                }
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
