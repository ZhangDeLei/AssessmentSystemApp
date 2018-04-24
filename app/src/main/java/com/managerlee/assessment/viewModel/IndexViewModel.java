package com.managerlee.assessment.viewModel;

import android.databinding.ObservableField;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.managerlee.assessment.R;
import com.managerlee.assessment.view.FragmentArticle;
import com.managerlee.assessment.view.FragmentSite;
import com.managerlee.assessment.view.FragmentTask;

/**
 * Created by anins on 2018/3/22.
 */

public class IndexViewModel {
    private Context context;
    private FragmentManager fm;
    public ObservableField<Integer> tagType = new ObservableField<>(); //当前选择的tag类型
    private Fragment articleFragment, taskFragment, siteFragment;

    public IndexViewModel(Context context, FragmentManager fm) {
        this.context = context;
        this.fm = fm;
    }

    public void gotoPageForArticle(View view) {
        selectFragment(0);
    }

    public void gotoPageForTask(View view) {
        selectFragment(1);
    }

    public void gotoPageForSite(View view) {
        selectFragment(2);
    }

    public void selectFragment(int index) {
        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);
        switch (index) {
            case 0:
                this.tagType.set(1);
                if (articleFragment == null) {
                    articleFragment = new FragmentArticle();
                    ft.add(R.id.framelayout, articleFragment);
                }
                ft.show(articleFragment);
                break;
            case 1:
                this.tagType.set(2);
                if (taskFragment == null) {
                    taskFragment = new FragmentTask();
                    ft.add(R.id.framelayout, taskFragment);
                }
                ft.show(taskFragment);
                break;
            case 2:
                this.tagType.set(3);
                if (siteFragment == null) {
                    siteFragment = new FragmentSite();
                    ft.add(R.id.framelayout, siteFragment);
                }
                ft.show(siteFragment);
                break;
        }
        ft.commit();
    }


    private void hideFragment(FragmentTransaction ft) {
        if (articleFragment != null) {
            ft.hide(articleFragment);
        }
        if (taskFragment != null) {
            ft.hide(taskFragment);
        }
        if (siteFragment != null) {
            ft.hide(siteFragment);
        }
    }

    public void setTagType(int tagType) {
        this.tagType.set(tagType);
    }
}
