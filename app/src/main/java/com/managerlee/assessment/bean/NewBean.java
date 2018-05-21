package com.managerlee.assessment.bean;

import java.io.Serializable;

/**
 * Created by anins on 2018/3/28.
 */

public class NewBean implements Serializable{

    /**
     * id : 5
     * url : http://news.163.com
     * name : 网易新闻
     * status : true
     * appId : null
     * appKey : null
     * appSecret : null
     * authCode : null
     * cls : null
     * authUrl : null
     * redirectUrl : null
     * icon : null
     * oprs : null
     * newId : 5
     * newName : 网易新闻
     * companyId : 19
     * companyName : 安徽芜湖
     */

    private int id;
    private String url;
    private String name;
    private boolean status;
    private String appId;
    private String appKey;
    private String appSecret;
    private String authCode;
    private String cls;
    private String clientCls;
    private String authUrl;
    private String redirectUrl;
    private String icon;
    private Object oprs;
    private int newId;
    private String newName;
    private int companyId;
    private String companyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getClientCls() {
        return clientCls;
    }

    public void setClientCls(String clientCls) {
        this.clientCls = clientCls;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public Object getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Object getOprs() {
        return oprs;
    }

    public void setOprs(Object oprs) {
        this.oprs = oprs;
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
