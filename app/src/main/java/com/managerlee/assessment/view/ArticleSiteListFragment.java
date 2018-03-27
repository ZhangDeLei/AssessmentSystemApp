package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.FragmentArticleSitelistBinding;
import com.managerlee.assessment.framework.base.BaseFragment;

/**
 * 网站合集
 * Created by anins on 2018/3/23.
 */

public class ArticleSiteListFragment extends BaseFragment {
    private FragmentArticleSitelistBinding mBinding;
    @Override
    public int setLayout() {
        return R.layout.fragment_article_sitelist;
    }

    @Override
    public void bindLayout(View contentView) {
        mBinding = DataBindingUtil.bind(contentView);
    }

    @Override
    public void bindData() {

    }
}
