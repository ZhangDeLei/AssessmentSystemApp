package com.managerlee.assessment.framework.dialog;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.managerlee.assessment.R;
import com.managerlee.assessment.framework.base.BaseDialog;

/**
 * 确认对话框
 * Created by anins on 2018/3/23.
 */

public class ConfirmDialog extends BaseDialog {
    private String title, content;
    private TextView dialogTvTitle, dialogTvContent;
    private ImageButton dialogIbClose;
    private Button dialogBtnConfirm;

    public ConfirmDialog(Activity context, String title, String content) {
        super(context);
        this.context = context;
    }

    @Override
    public void dataBindView() {
        setContentView(R.layout.dialog_confirm);
        dialogTvTitle = (TextView) findViewById(R.id.dialog_tv_title);
        dialogTvContent = (TextView) findViewById(R.id.dialog_tv_content);
        dialogIbClose = (ImageButton) findViewById(R.id.dialog_ib_close);
        dialogBtnConfirm = (Button) findViewById(R.id.dialog_btn_confirm);

        dialogTvTitle.setText(title);
        dialogTvContent.setText(content);
        dialogBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener == null) {
                    listener.onClose();
                } else {
                    listener.onConfirm();
                }
            }
        });
        dialogIbClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener == null) {
                    dismiss();
                } else {
                    listener.onClose();
                }
            }
        });
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private OnClickListener listener;

    public interface OnClickListener {
        void onClose();

        void onConfirm();
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }
}
