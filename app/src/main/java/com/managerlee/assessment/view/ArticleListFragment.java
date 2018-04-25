package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.FragmentArticleListBinding;
import com.managerlee.assessment.framework.base.BaseFragment;

/**
 * 文章列表
 * Created by anins on 2018/3/23.
 */

public class ArticleListFragment extends BaseFragment {
    private FragmentArticleListBinding mBinding;

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

    }
}
