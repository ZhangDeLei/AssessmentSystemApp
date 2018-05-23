package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;

import com.managerlee.assessment.business.update.UpdateService;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.dialog.ConfirmDialog;
import com.managerlee.assessment.framework.dialog.ProgressHelper;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.StringUtil;
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
    private ConfirmDialog dialog;

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
                    if (StringUtil.isNotNull(PerferenceConfig.UserAccount.get()) &&
                            StringUtil.isNotNull(PerferenceConfig.Password.get())) {
                        LoginViewModel
                                .getInstance(activity)
                                .defaultLogin(
                                        PerferenceConfig.UserAccount.get(),
                                        PerferenceConfig.Password.get());
                    } else {
                        activity.finish();
                        activity.startActivity(new Intent(activity, LoginActivity.class));
                    }
                } else {
                    showDialog(data);
                }
            }

            @Override
            public void onError(String msg) {
                ProgressHelper.init().close();
                ToastUtils.show(msg);
                activity.finish();
                activity.startActivity(new Intent(activity, LoginActivity.class));
            }

            @Override
            public void onCompleted() {
                ProgressHelper.init().close();
            }
        });
    }

    /**
     * 显示更新弹框
     *
     * @param data
     */
    private void showDialog(final AppUpdateBean data) {
        dialog = new ConfirmDialog(activity);
        dialog.setTitle("发现新版本");
        dialog.setContentGravity(Gravity.TOP | Gravity.LEFT);
        dialog.setContent(data.getComment() + "\n版本号:" + data.getVersion());
        dialog.setConfirmText("立即更新");
        dialog.setContentScroll();
        dialog.setListener(new ConfirmDialog.OnClickListener() {
            @Override
            public void onClose() {
                dialog.dismiss();
            }

            @Override
            public void onConfirm() {
                startUpdate(data.getUrl());
            }
        });
        dialog.show();
    }

    /**
     * 启动下载
     *
     * @param downloadUrl
     */
    private void startUpdate(String downloadUrl) {
        Intent it = new Intent(activity, UpdateService.class);
        downloadUrl = downloadUrl.replace("\\", "//").replace("//", "/");
        //下载地址
        it.putExtra("apkUrl", URLConstant.BASE_URL + downloadUrl);
        activity.startService(it);
        dialog.dismiss();
    }
}
