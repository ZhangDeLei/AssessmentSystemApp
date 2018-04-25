package com.managerlee.assessment.viewModel;

import com.managerlee.assessment.adapter.ArticleTypeAdapter;
import com.managerlee.assessment.bean.DictBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.IDictionaryView;
import com.managerlee.assessment.model.impl.DictionaryViewImpl;

import java.util.List;

/**
 * Created by anins on 2018/4/25.
 */

public class ArticleListViewModel {
    private IDictionaryView dictView;
    private ArticleTypeAdapter typeAdapter;
    public ArticleListViewModel(ArticleTypeAdapter typeAdapter) {
        dictView = new DictionaryViewImpl();
        this.typeAdapter = typeAdapter;
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
    private void getDictList(){
        dictView.getDictListByEnName("Level", new CallBackListener<List<DictBean>>() {
            @Override
            public void onSuccess(List<DictBean> data) {
                typeAdapter.setData(data);
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
