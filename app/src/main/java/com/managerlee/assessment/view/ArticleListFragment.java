package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.adapter.ArticleListAdapter;
import com.managerlee.assessment.adapter.ArticleTypeAdapter;
import com.managerlee.assessment.bean.DictBean;
import com.managerlee.assessment.databinding.FragmentArticleListBinding;
import com.managerlee.assessment.framework.base.BaseFragment;
import com.managerlee.assessment.viewModel.ArticleListViewModel;

/**
 * 文章列表
 * Created by anins on 2018/3/23.
 */

public class ArticleListFragment extends BaseFragment implements ArticleTypeAdapter.ItemListener{

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
        typeAdapter = new ArticleTypeAdapter();
        listAdapter = new ArticleListAdapter();
        typeAdapter.setListener(this);
        viewModel = new ArticleListViewModel(typeAdapter,listAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mBinding.rvTypeList.setLayoutManager(linearLayoutManager);
        mBinding.rvTypeList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        mBinding.rvTypeList.setAdapter(typeAdapter);
        LinearLayoutManager listLinearLayoutManager = new LinearLayoutManager(getContext());
        listLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.rvContent.setLayoutManager(listLinearLayoutManager);
        mBinding.rvContent.setAdapter(listAdapter);
    }

    @Override
    public void getArticleList(DictBean bean) {
        viewModel.getArticleList(bean);
    }
}
