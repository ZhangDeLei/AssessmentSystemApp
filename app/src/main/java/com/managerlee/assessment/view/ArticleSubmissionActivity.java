package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityArticleSubmissionBinding;
import com.managerlee.assessment.framework.base.BaseActivity;

/**
 * 投稿
 * Created by anins on 2018/3/23.
 */

public class ArticleSubmissionActivity extends BaseActivity {
    private ActivityArticleSubmissionBinding mBinding;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_article_submission);
    }

    @Override
    public void bindData() {

    }
}
