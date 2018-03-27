package com.managerlee.assessment.bean;

/**
 * Created by anins on 2018/3/27.
 */

public class LoginUserBean {
    private UserBean user;
    private String token;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
