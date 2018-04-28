package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.databinding.ObservableField;

import com.managerlee.assessment.adapter.ArticleListAdapter;
import com.managerlee.assessment.adapter.ArticleTypeAdapter;
import com.managerlee.assessment.bean.ArticleBean;
import com.managerlee.assessment.bean.ArticleLevelBean;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.dialog.ProgressHelper;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.framework.page.Page;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.IArticleLevelView;
import com.managerlee.assessment.model.IArticleView;
import com.managerlee.assessment.model.impl.ArticleLevelViewImpl;
import com.managerlee.assessment.model.impl.ArticleViewImpl;
import com.managerlee.assessment.param.ArticleParam;

import java.util.List;

/**
 * Created by anins on 2018/4/25.
 */

public class ArticleListViewModel extends BaseViewModel {
    private IArticleView articleView;
    private IArticleLevelView articleLevelView;
    private ArticleTypeAdapter typeAdapter;
    private ArticleListAdapter listAdapter;
    private CompletedListener completedListener;
    private Activity context;
    private boolean isFirst = true;
    public ObservableField<String> titleOf = new ObservableField<>();

    public ArticleListViewModel(Activity context,
                                ArticleTypeAdapter typeAdapter,
                                ArticleListAdapter listAdapter,
                                CompletedListener completedListener) {
        articleView = new ArticleViewImpl();
        articleLevelView = new ArticleLevelViewImpl();
        this.context = context;
        this.typeAdapter = typeAdapter;
        this.listAdapter = listAdapter;
        this.completedListener = completedListener;
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        getArticleLevelList();
    }

    /**
     * 获取文章分类列表
     */
    private void getArticleLevelList() {
        articleLevelView.getArticleLevelList(PerferenceConfig.CompanyId.get(), "", new CallBackListener<List<ArticleLevelBean>>() {
            @Override
            public void onSuccess(List<ArticleLevelBean> data) {
                typeAdapter.setData(data);
                if (data != null && data.size() > 0) {
                    CurPage = 1;
                    getArticleList(data.get(0), CurPage);
                }
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    /**
     * 获取文章列表
     *
     * @param bean
     */
    public void getArticleList(ArticleLevelBean bean, int CurPage) {
        if (isFirst) {
            isFirst = false;
            ProgressHelper.init().show(context, "正在加载数据...");
        }
        ArticleParam param = new ArticleParam();
        param.setLevelId(bean.getId());
        param.setCompanyId(PerferenceConfig.CompanyId.get());
        param.setPageSize(Page.PageSize);
        param.setCurPage(CurPage);
        articleView.getArticleList(param, new CallBackListener<List<ArticleBean>>() {
            @Override
            public void onSuccess(List<ArticleBean> data) {
                listAdapter.setData(data);
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
            }

            @Override
            public void onCompleted() {
                completedListener.onCompleted();
                ProgressHelper.init().close();
            }
        });
    }


}
