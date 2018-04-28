package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.adapter.ArticleSiteAdapter;
import com.managerlee.assessment.databinding.FragmentArticleSitelistBinding;
import com.managerlee.assessment.framework.base.BaseFragment;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.utils.SpaceItemDecoration;
import com.managerlee.assessment.viewModel.ArticleSiteListViewModel;

/**
 * 网站合集
 * Created by anins on 2018/3/23.
 */

public class ArticleSiteListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, CompletedListener {
    private FragmentArticleSitelistBinding mBinding;
    private ArticleSiteListViewModel viewModel;
    private ArticleSiteAdapter adapter;

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
        adapter = new ArticleSiteAdapter(getContext());
        viewModel = new ArticleSiteListViewModel(adapter, this);

        int space = getResources().getDimensionPixelSize(R.dimen.dimen10);
        mBinding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mBinding.recyclerView.addItemDecoration(new SpaceItemDecoration(space, 2));
        mBinding.recyclerView.setAdapter(adapter);
        mBinding.swipeRegreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        adapter.clearData();
        viewModel.initData();
    }

    @Override
    public void onCompleted() {
        if (mBinding.swipeRegreshLayout.isRefreshing()) {
            mBinding.swipeRegreshLayout.setRefreshing(false);
        }
    }
}
