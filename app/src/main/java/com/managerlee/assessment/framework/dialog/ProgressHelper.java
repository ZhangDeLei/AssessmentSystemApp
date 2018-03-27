package com.managerlee.assessment.framework.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.managerlee.assessment.R;

/**
 * 进度
 * Created by anins on 2018/3/26.
 */

public class ProgressHelper {

    private Dialog dialog;

    public static ProgressHelper init() {
        return Singleton.INSTANCE;
    }

    private static class Singleton {
        static ProgressHelper INSTANCE = new ProgressHelper();
    }

    public void show(Activity context, String msg) {
        close();
        createDialog(context, msg);
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    public void close() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private void createDialog(Context context, String msg) {
        dialog = new Dialog(context, R.style.DefaultDialog);
        Window window = dialog.getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        window.getDecorView().setSystemUiVisibility(uiOptions);
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        window.setAttributes(lp);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_progress);
        ((TextView)dialog.findViewById(R.id.tv_msg)).setText(msg);
    }
}
