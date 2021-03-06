package com.managerlee.assessment.framework.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;

import com.managerlee.assessment.framework.config.GlobalConfig;

/**
 * Created by anins on 2018/3/23.
 */

public class BaseViewModel extends BaseObservable {

    public int CurPage = 1;//当前页码
    public Activity activity;

    public BaseViewModel(Activity activity) {
        this.activity = activity;
    }

    public BaseViewModel() {
    }

    /**
     * 返回上一页
     */
    public void gotoBack() {
        activity.finish();
    }

}
