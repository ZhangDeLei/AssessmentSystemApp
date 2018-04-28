package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;

import com.managerlee.assessment.view.ArticleSubmissionHisActivity;

/**
 * Created by anins on 2018/4/28.
 */

public class ArticleSubmissionViewModel {
    private Activity context;

    public ArticleSubmissionViewModel(Activity context) {
        this.context = context;
    }

    /**
     * 跳转至投稿历史记录列表界面
     */
    public void gotoSubmissionHis() {
        context.startActivity(new Intent(context, ArticleSubmissionHisActivity.class));
    }

    /**
     * 关闭当前界面
     */
    public void gotoBack() {
        context.finish();
    }
}
