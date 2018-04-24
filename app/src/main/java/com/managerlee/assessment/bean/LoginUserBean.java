package com.managerlee.assessment.bean;

/**
 * Created by anins on 2018/3/27.
 */

public class LoginUserBean {
    private UserBean user;
    private CompanyBean company;
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

    public CompanyBean getCompany() {
        return company;
    }

    public void setCompany(CompanyBean company) {
        this.company = company;
    }
}
