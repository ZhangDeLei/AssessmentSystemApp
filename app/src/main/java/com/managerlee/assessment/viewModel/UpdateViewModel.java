package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;

import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.dialog.ConfirmDialog;
import com.managerlee.assessment.framework.dialog.ProgressHelper;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.utils.SystemUtils;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.view.LoginActivity;
import com.managerlee.assessment.bean.AppUpdateBean;
import com.managerlee.assessment.model.IUpdateView;
import com.managerlee.assessment.model.impl.UpdateViewImpl;

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
        ProgressHelper.init().show(activity, "正在更新中...");
        updateView.getNewVersion(new CallBackListener<AppUpdateBean>() {
            @Override
            public void onSuccess(AppUpdateBean data) {
                ProgressHelper.init().close();
                if (data.getVersionCode() == SystemUtils.currentVersionCode(activity)) {
                    activity.finish();
                    activity.startActivity(new Intent(activity, LoginActivity.class));
                } else {
                    ConfirmDialog dialog = new ConfirmDialog(activity, "发现新版本", data.getComment());
                    dialog.setListener(new ConfirmDialog.OnClickListener() {
                        @Override
                        public void onClose() {

                        }

                        @Override
                        public void onConfirm() {

                        }
                    });
                    dialog.show();
                }
            }

            @Override
            public void onError(String msg) {
                ProgressHelper.init().close();
                ToastUtils.show(msg);
            }

            @Override
            public void onCompleted() {
                ProgressHelper.init().close();
            }
        });
    }
}
