package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.FragmentArticleBinding;
import com.managerlee.assessment.framework.base.BaseFragment;
import com.managerlee.assessment.viewModel.ArticleViewModel;

/**
 * 网评文章
 * Created by anins on 2018/3/22.
 */

public class FragmentArticle extends BaseFragment implements OnTabSelectListener {

    private FragmentArticleBinding mBinding;
    private ArticleViewModel viewModel;


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
        viewModel = new ArticleViewModel(getContext());
        mBinding.ctTitleTab.setTabData(viewModel.getTabEntitys(), getActivity(), R.id.fl_framelayout, viewModel.getFragments());
        mBinding.setArticle(viewModel);
    }

    @Override
    public void onTabSelect(int position) {
        mBinding.ctTitleTab.setCurrentTab(position);
    }

    @Override
    public void onTabReselect(int position) {

    }
}
