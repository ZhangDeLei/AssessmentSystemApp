package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.FragmentArticleBinding;
import com.managerlee.assessment.framework.base.BaseFragment;
import com.managerlee.assessment.viewModel.ArticleViewModel;

/**
 * 网评文章
 * Created by anins on 2018/3/22.
 */

public class FragmentArticle extends BaseFragment {

    private FragmentArticleBinding mBinding;
    private ArticleViewModel viewModel;
    private FragmentManager fm;

    public static FragmentArticle getInstance() {
        return new FragmentArticle();
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_article;
    }

    @Override
    public void bindLayout(View contentView) {
        mBinding = DataBindingUtil.bind(contentView);
    }

    @Override
    public void bindData() {
        fm = getActivity().getSupportFragmentManager();
        viewModel = new ArticleViewModel(getContext(), fm);
        mBinding.setArticle(viewModel);
    }
}
