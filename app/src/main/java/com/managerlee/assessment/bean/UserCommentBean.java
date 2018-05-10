package com.managerlee.assessment.bean;

/**
 * Created by anins on 2018/5/2.
 */

public class UserCommentBean {

    /**
     * id : 1
     * companyId : 19
     * taskId : 6
     * userId : 36
     * content : ''
     * createTime : 2019-03-01T09:22:56.000Z
     * imageUrl : null
     */

    private int id;
    private int companyId;
    private int taskId;
    private int userId;
    private String content;
    private String createTime;
    private Object imageUrl;

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

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Object getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }
}
