package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.adapter.SiteAdapter;
import com.managerlee.assessment.databinding.FragmentSiteBinding;
import com.managerlee.assessment.framework.base.BaseFragment;
import com.managerlee.assessment.viewModel.SiteViewModel;

/**
 * 站点巡查
 * Created by anins on 2018/3/22.
 */

public class FragmentSite extends BaseFragment{

    private FragmentSiteBinding mBinding;
    private SiteViewModel viewModel;
    private SiteAdapter adapter;

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
        adapter = new SiteAdapter(getContext());
        mBinding.recyclerView.setAdapter(adapter);
        mBinding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        viewModel = new SiteViewModel(getContext(), adapter);
    }
}
