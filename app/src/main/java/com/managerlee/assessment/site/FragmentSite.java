package com.managerlee.assessment.site;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.FragmentSiteBinding;
import com.managerlee.assessment.framework.base.BaseFragment;

/**
 * Created by anins on 2018/3/22.
 */

public class FragmentSite extends BaseFragment {

    private FragmentSiteBinding mBinding;

    public static FragmentSite getInstance() {
        return new FragmentSite();
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_site;
    }

    @Override
    public void bindLayout(View contentView) {
        mBinding = DataBindingUtil.bind(contentView);
    }

    @Override
    public void bindData() {

    }
}
