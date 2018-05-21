package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.bean.TaskDetail;
import com.managerlee.assessment.databinding.ActivityTaskDetailBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.viewModel.TaskDetailViewModel;

/**
 * 任务详情
 * Created by anins on 2018/3/23.
 */

public class TaskDetailActivity extends BaseActivity{
    private ActivityTaskDetailBinding mBinding;
    private TaskDetailViewModel viewModel;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_task_detail);
    }

    @Override
    public void bindData() {
        TaskDetail bean = (TaskDetail) getIntent().getSerializableExtra("task");
        viewModel = new TaskDetailViewModel(this, bean);
        viewModel.setWebView(mBinding.webView);
        mBinding.webView.loadUrl(bean.getUrl());
        mBinding.webView.getSettings().setJavaScriptEnabled(true);
        mBinding.webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mBinding.setTask(bean);
        mBinding.setViewModel(viewModel);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mBinding.webView.canGoBack()) {
            mBinding.webView.goBack();
            return true;
        } else {
            this.finish();
        }
        return false;
    }
}
