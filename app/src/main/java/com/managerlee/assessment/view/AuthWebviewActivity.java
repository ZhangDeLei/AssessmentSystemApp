package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.NewBean;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.databinding.ActivityAuthWebviewBinding;
import com.managerlee.assessment.viewModel.AuthWebviewViewModel;

/**
 * 新闻客户端授权
 */
public class AuthWebviewActivity extends BaseActivity {
    private ActivityAuthWebviewBinding binding;
    private AuthWebviewViewModel viewModel;

    @Override
    public void bindLayout() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth_webview);
    }

    @Override
    public void bindData() {
        NewBean newBean = (NewBean) getIntent().getSerializableExtra("new");
        viewModel = new AuthWebviewViewModel(this, newBean);
        binding.setVm(viewModel);
        binding.webView.loadUrl(viewModel.getAuthUrl());
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
