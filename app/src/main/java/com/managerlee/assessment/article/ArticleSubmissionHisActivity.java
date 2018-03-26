package com.managerlee.assessment.article;

import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityArticleSubmissionHisBinding;
import com.managerlee.assessment.framework.base.BaseActivity;

/**
 * 投稿记录
 * Created by anins on 2018/3/23.
 */

public class ArticleSubmissionHisActivity extends BaseActivity {
    private ActivityArticleSubmissionHisBinding mBinding;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_article_submission_his);
    }

    @Override
    public void bindData() {

    }
}
