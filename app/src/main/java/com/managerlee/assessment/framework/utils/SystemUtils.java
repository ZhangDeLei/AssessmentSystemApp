package com.managerlee.assessment.framework.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by anins on 2018/3/23.
 */

public class SystemUtils {

    /**
     * 获取当前应用的版本号
     *
     * @param context
     * @return
     */
    public static final int currentVersionCode(Context context) {
        int versionCode = 0;
        try {
            PackageInfo pi = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionCode = pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取当前应用的版本名称
     *
     * @param context
     * @return
     */
    public static String currentVersionName(Context context) {
        String versionName = "";
        try {
            PackageInfo pi = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

}
