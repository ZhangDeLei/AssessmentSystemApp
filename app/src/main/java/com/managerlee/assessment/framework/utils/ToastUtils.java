package com.managerlee.assessment.framework.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.managerlee.assessment.framework.config.GlobalConfig;

/**
 * Created by anins on 2018/3/23.
 */

public class ToastUtils {

    private static Toast toast;

    /**
     * show toast
     *
     * @param msg message string
     */
    public static void show(String msg) {
        if (toast == null) {
            toast = Toast.makeText(GlobalConfig.getAppContext(), "", Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * show toast
     *
     * @param msgId message resource id
     */
    public static void show(int msgId) {
        if (toast == null) {
            toast = Toast.makeText(GlobalConfig.getAppContext(), "", Toast.LENGTH_SHORT);
        }
        toast.setText(msgId);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
