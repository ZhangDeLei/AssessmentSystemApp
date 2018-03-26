package com.managerlee.assessment.article;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityArticleSearchBinding;
import com.managerlee.assessment.framework.base.BaseActivity;

/**
 * 搜索
 * Created by anins on 2018/3/23.
 */

public class SearchActivity extends BaseActivity {
    private ActivityArticleSearchBinding mBinding;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_article_search);
    }

    @Override
    public void bindData() {

    }
}
