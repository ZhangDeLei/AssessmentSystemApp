package com.managerlee.assessment.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by anins on 2018/4/28.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private int num;

    public SpaceItemDecoration(int res, int num) {
        this.space = res;
        this.num = num;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.bottom = space;
        if (parent.getChildLayoutPosition(view) % num == 0) {
            outRect.left = 0;
        }
    }
}
