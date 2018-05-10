package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.adapter.TaskAdapter;
import com.managerlee.assessment.databinding.FragmentTaskBinding;
import com.managerlee.assessment.framework.base.BaseFragment;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.viewModel.TaskViewModel;

/**
 * 任务列表
 * Created by anins on 2018/3/22.
 */

public class FragmentTask extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, CompletedListener {
    private FragmentTaskBinding mBinding;
    private TaskViewModel viewModel;
    private TaskAdapter mAdapter;

    public static FragmentTask getInstance() {
        return new FragmentTask();
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_task;
    }

    @Override
    public void bindLayout(View contentView) {
        mBinding = DataBindingUtil.bind(contentView);
    }

    @Override
    public void bindData() {
        mAdapter = new TaskAdapter(getContext());
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        mBinding.recyclerView.setAdapter(mAdapter);
        mBinding.swipeRegreshLayout.setOnRefreshListener(this);
        viewModel = new TaskViewModel(getActivity(), mAdapter, this);
        mBinding.setViewModel(viewModel);
    }

    @Override
    public void onRefresh() {
        mAdapter.clearData();
        viewModel.initData();
    }

    @Override
    public void onCompleted() {
        if (mBinding.swipeRegreshLayout.isRefreshing()) {
            mBinding.swipeRegreshLayout.setRefreshing(false);
        }
    }
}
