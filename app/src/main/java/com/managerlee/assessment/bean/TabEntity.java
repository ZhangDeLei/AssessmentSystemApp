package com.managerlee.assessment.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by anins on 2018/4/25.
 */

public class TabEntity implements CustomTabEntity {
    public String title;
    private int selectIcon = 0;
    private int unselectIcon = 0;

    public TabEntity(String title, int selectIcon, int unselectIcon) {
        this.title = title;
        this.selectIcon = selectIcon;
        this.unselectIcon = unselectIcon;
    }

    public TabEntity(String title) {
        this.title = title;
    }

    @Override
    public String getTabTitle() {

        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselectIcon;
    }
}
