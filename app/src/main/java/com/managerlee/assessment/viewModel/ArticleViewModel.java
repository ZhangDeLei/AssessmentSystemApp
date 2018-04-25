package com.managerlee.assessment.viewModel;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.managerlee.assessment.bean.TabEntity;
import com.managerlee.assessment.view.ArticleListFragment;
import com.managerlee.assessment.view.ArticleSiteListFragment;

import java.util.ArrayList;

/**
 * 网评文章
 * Created by anins on 2018/4/24.
 */

public class ArticleViewModel {
    private Context context;
    private static final String[] mTabLabels = new String[]{"文章", "网站合集"};//头部tab内容

    public ArticleViewModel(Context context) {
        this.context = context;
    }

    /**
     * 初始化Tab
     */
    public ArrayList<CustomTabEntity> getTabEntitys() {
        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        for (int i = 0; i < mTabLabels.length; i++) {
            mTabEntities.add(new TabEntity(mTabLabels[i]));
        }
        return mTabEntities;
    }

    /**
     * 获取各自的Fragment列表
     * @return
     */
    public ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new ArticleListFragment());
        mFragments.add(new ArticleSiteListFragment());
        return mFragments;
    }
}
