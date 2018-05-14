package com.managerlee.assessment.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.SubmissionBean;
import com.managerlee.assessment.databinding.ActivityArticleSubmissionBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.viewModel.ArticleSubmissionViewModel;

import java.io.File;

/**
 * 投稿
 * Created by anins on 2018/3/23.
 */

public class ArticleSubmissionActivity extends BaseActivity {
    private ActivityArticleSubmissionBinding mBinding;
    private ArticleSubmissionViewModel viewModel;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_article_submission);
    }

    @Override
    public void bindData() {
        viewModel = new ArticleSubmissionViewModel(this);
        SubmissionBean bean = (SubmissionBean) getIntent().getSerializableExtra("submission");
        viewModel.setCurrentSubmission(bean);
        mBinding.setSub(viewModel);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 100) {
            File file = (File) data.getSerializableExtra("file");
            viewModel.setFile(file);
        }
    }
}
