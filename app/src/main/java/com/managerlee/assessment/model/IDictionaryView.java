package com.managerlee.assessment.model;

import com.managerlee.assessment.bean.DictBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;

import java.util.List;

/**
 * 字典值视图
 * Created by anins on 2018/4/25.
 */

public interface IDictionaryView {

    void getDictListByEnName(String enName, CallBackListener<List<DictBean>> listener);
}
