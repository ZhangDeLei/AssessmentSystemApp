package com.managerlee.assessment.framework.dialog;

import android.app.Activity;

import com.managerlee.assessment.R;
import com.managerlee.assessment.framework.base.BaseDialog;

/**
 * 确认对话框
 * Created by anins on 2018/3/23.
 */

public class ConfirmDialog extends BaseDialog {
    private String title, content;

    public ConfirmDialog(Activity context, String title, String content) {
        super(context);
        this.context = context;
    }

    @Override
    public void dataBindView() {
        setContentView(R.layout.dialog_confirm);
    }
}
