package com.managerlee.assessment.bean;

/**
 * Created by anins on 2018/5/2.
 */

public class UserNewAuthBean {

    /**
     * id : null
     * userId : null
     * newId : 3
     * newName : 新浪微博
     * newAccount : null
     * isAuth : null
     * authToken : null
     * authTokenExpire : null
     * refreshToken : null
     */

    private Object id;
    private Object userId;
    private int newId;
    private String newName;
    private Object newAccount;
    private Boolean isAuth;
    private Object authToken;
    private Object authTokenExpire;
    private Object refreshToken;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Object getNewAccount() {
        return newAccount;
    }

    public void setNewAccount(Object newAccount) {
        this.newAccount = newAccount;
    }

    public Boolean getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Boolean isAuth) {
        this.isAuth = isAuth;
    }

    public Object getAuthToken() {
        return authToken;
    }

    public void setAuthToken(Object authToken) {
        this.authToken = authToken;
    }

    public Object getAuthTokenExpire() {
        return authTokenExpire;
    }

    public void setAuthTokenExpire(Object authTokenExpire) {
        this.authTokenExpire = authTokenExpire;
    }

    public Object getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(Object refreshToken) {
        this.refreshToken = refreshToken;
    }
}
