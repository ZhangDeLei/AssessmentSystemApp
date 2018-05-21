package com.managerlee.assessment.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.managerlee.assessment.R;
import com.managerlee.assessment.adapter.AccountBindAdapter;
import com.managerlee.assessment.bean.UserNewAuthBean;
import com.managerlee.assessment.databinding.ActivityAccountBindBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.viewModel.AccountBindViewModel;

/**
 * 账号绑定
 * Created by anins on 2018/3/23.
 */

public class AccountBindActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, CompletedListener, AccountBindAdapter.OnItemListener {
    private ActivityAccountBindBinding mBinding;
    private AccountBindViewModel viewModel;
    private AccountBindAdapter adapter;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_account_bind);
    }

    @Override
    public void bindData() {
        adapter = new AccountBindAdapter(this);
        adapter.setListener(this);
        viewModel = new AccountBindViewModel(this, adapter, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.recyclerView.setLayoutManager(layoutManager);
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mBinding.recyclerView.setAdapter(adapter);
        mBinding.swipeRegreshLayout.setOnRefreshListener(this);
        mBinding.setViewModel(viewModel);
    }

    @Override
    public void onRefresh() {
        adapter.clearData();
        viewModel.initData();//重新获取数据
    }

    @Override
    public void onCompleted() {
        if (mBinding.swipeRegreshLayout.isRefreshing()) {
            mBinding.swipeRegreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onItem(UserNewAuthBean bean) {
        Intent in = new Intent(this, AuthWebviewActivity.class);
        in.putExtra("new", bean.getNewAuthEntity());
        startActivity(in);
    }
}
