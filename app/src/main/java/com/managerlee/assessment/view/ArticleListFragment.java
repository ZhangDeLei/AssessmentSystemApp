package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.adapter.ArticleListAdapter;
import com.managerlee.assessment.adapter.ArticleTypeAdapter;
import com.managerlee.assessment.bean.ArticleLevelBean;
import com.managerlee.assessment.databinding.FragmentArticleListBinding;
import com.managerlee.assessment.framework.base.BaseFragment;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.viewModel.ArticleListViewModel;

/**
 * 文章列表
 * Created by anins on 2018/3/23.
 */

public class ArticleListFragment
        extends BaseFragment
        implements ArticleTypeAdapter.ItemListener,
        SwipeRefreshLayout.OnRefreshListener,
        CompletedListener {

    private FragmentArticleListBinding mBinding;
    private ArticleListViewModel viewModel;
    private ArticleTypeAdapter typeAdapter;
    private ArticleListAdapter listAdapter;

    @Override
    public int setLayout() {
        return R.layout.fragment_article_list;
    }

    @Override
    public void bindLayout(View contentView) {
        mBinding = DataBindingUtil.bind(contentView);
    }

    @Override
    public void bindData() {
        typeAdapter = new ArticleTypeAdapter(); //类型数据源
        listAdapter = new ArticleListAdapter(getContext()); //文章列表数据源
        typeAdapter.setListener(this);
        viewModel = new ArticleListViewModel(getActivity(), typeAdapter, listAdapter, this);
        //分类列表
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mBinding.rvTypeList.setLayoutManager(linearLayoutManager);
        mBinding.rvTypeList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        mBinding.rvTypeList.setAdapter(typeAdapter);
        //文章列表
        LinearLayoutManager listLinearLayoutManager = new LinearLayoutManager(getContext());
        listLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.rvContent.setLayoutManager(listLinearLayoutManager);
        mBinding.rvContent.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mBinding.rvContent.setAdapter(listAdapter);
        mBinding.rvContent.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == listAdapter.getItemCount()) {
                    viewModel.getArticleList(typeAdapter.getItem(typeAdapter.getCurrentPosition()), viewModel.CurPage + 1);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) mBinding.rvContent.getLayoutManager();
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }
        });
        mBinding.swipeRegreshLayout.setOnRefreshListener(this);
        mBinding.setViewModel(viewModel);
    }

    @Override
    public void getArticleList(ArticleLevelBean bean) {
        viewModel.CurPage = 1;
        viewModel.getArticleList(bean, viewModel.CurPage);
    }

    @Override
    public void onRefresh() {
        listAdapter.clearData();
        viewModel.CurPage = 1;
        viewModel.getArticleList(typeAdapter.getItem(typeAdapter.getCurrentPosition()), viewModel.CurPage);
    }

    @Override
    public void onCompleted() {
        if (mBinding.swipeRegreshLayout.isRefreshing()) {
            mBinding.swipeRegreshLayout.setRefreshing(false);
        }
    }
}
