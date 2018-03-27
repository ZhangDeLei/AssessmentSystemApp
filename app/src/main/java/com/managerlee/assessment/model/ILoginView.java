package com.managerlee.assessment.model;

import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.bean.LoginUserBean;

/**
 * Created by anins on 2018/3/26.
 */

public interface ILoginView {
    void login(String UserAccount, String Password,CallBackListener<LoginUserBean> listener);
}
