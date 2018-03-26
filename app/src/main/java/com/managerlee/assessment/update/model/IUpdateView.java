package com.managerlee.assessment.update.model;

import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.update.bean.AppUpdateBean;

/**
 * Created by anins on 2018/3/23.
 */

public interface IUpdateView {

    void getNewVersion(CallBackListener<AppUpdateBean> listener);

}
