package com.managerlee.assessment.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.managerlee.assessment.R;

/**
 * Created by anins on 2018/5/11.
 */

public class FileCheckDialog extends Dialog implements View.OnClickListener {

    private Activity context;
    private LinearLayout ll_file;

    public FileCheckDialog(Activity context) {
        super(context);
        this.context = context;
        initView();
    }

    /**
     * 初始化dialog视图
     */
    private void initView() {
        setContentView(R.layout.dialog_file_check);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setCanceledOnTouchOutside(true);
        ll_file = findViewById(R.id.ll_file);
        ll_file.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_file:
                if (listener != null) {
                    listener.onFileListener();
                }
                break;
        }
    }

    private OnEventListener listener;

    public interface OnEventListener {
        void onFileListener();
    }

    public void setListener(OnEventListener listener) {
        this.listener = listener;
    }
}
