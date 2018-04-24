package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityWebviewBinding;
import com.managerlee.assessment.framework.base.BaseActivity;

/**
 * Created by anins on 2018/4/24.
 */

public class WebviewActivity extends BaseActivity {
    ActivityWebviewBinding mBinding;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_webview);
    }

    @Override
    public void bindData() {
        mBinding.webView.loadUrl(getIntent().getStringExtra("web_url"));
        mBinding.webView.getSettings().setJavaScriptEnabled(true);
        mBinding.webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
