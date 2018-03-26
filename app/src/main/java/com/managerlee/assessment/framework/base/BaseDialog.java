package com.managerlee.assessment.framework.base;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.managerlee.assessment.R;

/**
 * Created by anins on 2018/3/23.
 */

public abstract class BaseDialog extends Dialog {

    public Activity context;

    public BaseDialog(Activity context) {
        super(context, R.style.DefaultDialog);
        this.context = context;
        loadView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //HIDE_NAVIGATION
        Window window = this.getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        window.getDecorView().setSystemUiVisibility(uiOptions);
    }

    private void loadView(){
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Window win = getWindow();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        win.setAttributes(lp);
        setCanceledOnTouchOutside(true);
        dataBindView();
    }

    public abstract void dataBindView();
}
