package com.managerlee.assessment.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anins on 2018/3/22.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(setLayout(), container, false);
        bindLayout(contentView);
        bindData();
        return contentView;
    }

    public abstract int setLayout();

    public abstract void bindLayout(View contentView);

    public abstract void bindData();
}
