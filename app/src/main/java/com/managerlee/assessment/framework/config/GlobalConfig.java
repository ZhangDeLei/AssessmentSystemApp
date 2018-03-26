package com.managerlee.assessment.framework.config;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by anins on 2018/3/23.
 */

public class GlobalConfig {
    private static Context appContext;

    public static void setAppContext(Context context) {
        appContext = context;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static Resources getRes() {
        return appContext.getResources();
    }
}
