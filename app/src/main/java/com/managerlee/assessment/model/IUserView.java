package com.managerlee.assessment.model;

import com.managerlee.assessment.bean.UserStatictisBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;

/**
 * Created by anins on 2018/5/10.
 */

public interface IUserView {
    void getUserStatictis(int Id,CallBackListener<UserStatictisBean> listener);
}
