package com.managerlee.assessment.model;

import com.managerlee.assessment.bean.NewBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;

import java.util.List;

/**
 * 新闻客户端视图
 * Created by anins on 2018/4/24.
 */

public interface INewAuthView {
    /**
     * 获取新闻客户端列表
     * @param callBackListener
     */
    void getNewAuthList(CallBackListener<List<NewBean>> callBackListener);
}
