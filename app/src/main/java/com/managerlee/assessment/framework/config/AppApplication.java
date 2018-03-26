package com.managerlee.assessment.framework.config;

import android.app.Application;

/**
 * Created by anins on 2018/3/23.
 */

public class AppApplication extends Application {
    private static AppApplication instance;

    public static AppApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        GlobalConfig.setAppContext(this.getApplicationContext());
    }
}
