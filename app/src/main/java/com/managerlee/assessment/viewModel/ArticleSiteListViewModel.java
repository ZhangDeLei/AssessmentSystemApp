package com.managerlee.assessment.viewModel;

import com.managerlee.assessment.adapter.ArticleSiteAdapter;
import com.managerlee.assessment.bean.ArticleBean;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.IArticleView;
import com.managerlee.assessment.model.impl.ArticleViewImpl;

import java.util.List;

/**
 * Created by anins on 2018/4/28.
 */

public class ArticleSiteListViewModel extends BaseViewModel {
    private IArticleView articleView;
    private ArticleSiteAdapter adapter;
    private CompletedListener listener;

    public ArticleSiteListViewModel(ArticleSiteAdapter adapter, CompletedListener listener) {
        this.articleView = new ArticleViewImpl();
        this.adapter = adapter;
        this.listener = listener;
        initData();
    }

    /**
     * 初始化数据
     */
    public void initData() {
        articleView.getArticleSiteList(PerferenceConfig.CompanyId.get(), new CallBackListener<List<ArticleBean>>() {
            @Override
            public void onSuccess(List<ArticleBean> data) {
                adapter.setData(data);
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
            }

            @Override
            public void onCompleted() {
                listener.onCompleted();
            }
        });
    }
}
