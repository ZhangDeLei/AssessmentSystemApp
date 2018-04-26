package com.managerlee.assessment.viewModel;

import com.managerlee.assessment.adapter.ArticleListAdapter;
import com.managerlee.assessment.adapter.ArticleTypeAdapter;
import com.managerlee.assessment.bean.ArticleBean;
import com.managerlee.assessment.bean.DictBean;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.page.Page;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.IArticleView;
import com.managerlee.assessment.model.IDictionaryView;
import com.managerlee.assessment.model.impl.ArticleViewImpl;
import com.managerlee.assessment.model.impl.DictionaryViewImpl;
import com.managerlee.assessment.param.ArticleParam;

import java.util.List;

/**
 * Created by anins on 2018/4/25.
 */

public class ArticleListViewModel extends BaseViewModel{
    private IDictionaryView dictView;
    private IArticleView articleView;
    private ArticleTypeAdapter typeAdapter;
    private ArticleListAdapter listAdapter;

    public ArticleListViewModel(ArticleTypeAdapter typeAdapter, ArticleListAdapter listAdapter) {
        dictView = new DictionaryViewImpl();
        articleView = new ArticleViewImpl();
        this.typeAdapter = typeAdapter;
        this.listAdapter = listAdapter;
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        getDictList();
    }

    /**
     * 获取文章分类列表
     */
    private void getDictList() {
        dictView.getDictListByEnName("Level", new CallBackListener<List<DictBean>>() {
            @Override
            public void onSuccess(List<DictBean> data) {
                typeAdapter.setData(data);
                if (data != null && data.size() > 0) {
                    getArticleList(data.get(0));
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
    public void getArticleList(DictBean bean) {
        ArticleParam param = new ArticleParam();
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
            }
        });
    }
}
