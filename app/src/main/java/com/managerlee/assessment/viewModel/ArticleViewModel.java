package com.managerlee.assessment.viewModel;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.view.ArticleListFragment;
import com.managerlee.assessment.view.ArticleSiteListFragment;

/**
 * 网评文章
 * Created by anins on 2018/4/24.
 */

public class ArticleViewModel {
    private Context context;
    public ObservableField<Integer> checkType = new ObservableField<>(); //默认为文章列表，2为网评合集
    private static final int ARTICLE = 1;//文章
    private static final int ARTICLE_LIST = 2;//合集
    private FragmentManager fm;
    private ArticleListFragment fragmentArticleList;//文章列表
    private ArticleSiteListFragment fragmentArticleSiteList;//网站合集

    public ArticleViewModel(Context context, FragmentManager fm) {
        this.context = context;
        this.fm = fm;
        checkType.set(ARTICLE);
    }

    /**
     * 选择一个Framgent进行显示
     *
     * @param view
     * @param type
     */
    public void select(View view, int type) {
        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);//隐藏fragment
        switch (type) {
            case ARTICLE://文章列表
                checkType.set(ARTICLE);
                if (fragmentArticleList == null) {
                    fragmentArticleList = new ArticleListFragment();
                    ft.add(R.id.fragment, fragmentArticleList);
                }
                ft.show(fragmentArticleList);
                break;
            case ARTICLE_LIST://网站合集
                checkType.set(ARTICLE_LIST);
                if (fragmentArticleSiteList == null) {
                    fragmentArticleSiteList = new ArticleSiteListFragment();
                    ft.add(R.id.fragment, fragmentArticleSiteList);
                }
                ft.show(fragmentArticleSiteList);
                break;
            default:
                checkType.set(ARTICLE);
                if (fragmentArticleList == null) {
                    fragmentArticleList = new ArticleListFragment();
                    ft.add(R.id.fragment, fragmentArticleList);
                }
                ft.show(fragmentArticleList);
                break;
        }
    }

    /**
     * 隐藏Fragment
     *
     * @param ft
     */
    private void hideFragment(FragmentTransaction ft) {
        if (fragmentArticleList != null) {
            ft.hide(fragmentArticleList);
        }
        if (fragmentArticleSiteList != null) {
            ft.hide(fragmentArticleSiteList);
        }
    }
}
