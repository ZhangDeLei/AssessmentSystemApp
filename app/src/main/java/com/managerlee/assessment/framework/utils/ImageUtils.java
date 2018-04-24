package com.managerlee.assessment.framework.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.managerlee.assessment.R;
import com.managerlee.assessment.constant.URLConstant;

/**
 * Created by anins on 2018/4/24.
 */

public class ImageUtils {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        if (StringUtil.isNotNull(url)) {
            Glide.with(view.getContext()).load(URLConstant.BASE_URL.substring(0, URLConstant.BASE_URL.length() - 1) + url).into(view);
        } else {
            view.setImageResource(R.drawable.weibo);
        }
    }
}
