package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.managerlee.assessment.R;
import com.managerlee.assessment.adapter.ArticleSubmissionHisAdapter;
import com.managerlee.assessment.databinding.ActivityArticleSubmissionHisBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.framework.page.Page;
import com.managerlee.assessment.viewModel.ArticleSubmissionHisViewModel;

/**
 * 投稿记录
 * Created by anins on 2018/3/23.
 */

public class ArticleSubmissionHisActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, CompletedListener {
    private ActivityArticleSubmissionHisBinding mBinding;
    private ArticleSubmissionHisViewModel viewModel;
    private ArticleSubmissionHisAdapter adapter;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_article_submission_his);
    }

    @Override
    public void bindData() {
        adapter = new ArticleSubmissionHisAdapter(this);
        viewModel = new ArticleSubmissionHisViewModel(this, adapter, this);

        LinearLayoutManager listLinearLayoutManager = new LinearLayoutManager(this);
        listLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.recyclerView.setLayoutManager(listLinearLayoutManager);
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mBinding.recyclerView.setAdapter(adapter);
        mBinding.swipeRegreshLayout.setOnRefreshListener(this);
        mBinding.setViewModel(viewModel);
    }

    @Override
    public void onRefresh() {
        adapter.clearData();
        viewModel.CurPage = 1;
        viewModel.getData(viewModel.CurPage);
    }

    @Override
    public void onCompleted() {
        if (mBinding.swipeRegreshLayout.isRefreshing()) {
            mBinding.swipeRegreshLayout.setRefreshing(false);
        }
    }
}
