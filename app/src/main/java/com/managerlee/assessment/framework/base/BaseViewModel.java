package com.managerlee.assessment.framework.base;

import android.app.Activity;
import android.content.Context;

import com.managerlee.assessment.framework.config.GlobalConfig;

/**
 * Created by anins on 2018/3/23.
 */

public class BaseViewModel {
    public Activity activity;

    public BaseViewModel(Activity activity) {
        this.activity = activity;
    }
}
