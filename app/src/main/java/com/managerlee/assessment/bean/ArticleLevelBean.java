package com.managerlee.assessment.bean;

/**
 * Created by anins on 2018/4/28.
 */

public class ArticleLevelBean {

    /**
     * id : 2
     * companyId : 19
     * name : 省级
     * status : true
     * sortBy : 1
     * comment :
     * createTime : 2018-04-26 04:36:12
     * createUserId : 36
     * createUserName : 安徽芜湖
     * lastUpdateTime : 2018-04-26 04:53:00
     */

    private int id;
    private int companyId;
    private String name;
    private boolean status;
    private int sortBy;
    private String comment;
    private String createTime;
    private int createUserId;
    private String createUserName;
    private String lastUpdateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    public int getSortBy() {
        return sortBy;
    }

    public void setSortBy(int sortBy) {
        this.sortBy = sortBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
