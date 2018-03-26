package com.managerlee.assessment.framework.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by anins on 2018/3/22.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Activity mAct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;
        bindLayout();
        bindData();
    }

    /**
     * 绑定视图
     */
    public abstract void bindLayout();

    /**
     * 绑定数据
     */
    public abstract void bindData();
}
