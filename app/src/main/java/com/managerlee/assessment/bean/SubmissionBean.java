package com.managerlee.assessment.bean;

import java.io.Serializable;

/**
 * Created by anins on 2018/4/28.
 */

public class SubmissionBean implements Serializable{

    /**
     * id : 16
     * companyId : 19
     * themeName : 测试投稿1号
     * title : 测试投稿1号
     * userId : 36
     * userName : 安徽芜湖
     * createTime : 2018-03-16 04:30:21
     * status : false
     * path : /upload/document/article/article_1521189021219.docx
     * url : null
     * processId : 32
     * processCode : 0001
     * processName : 审核进程
     * levelId : null
     * levelName : null
     * process : {"id":27,"submissionId":16,"operationTime":"2018-03-16 04:30:21","operationUserId":36,"operationUserName":"安徽芜湖","processId":32,"processCode":"0001","processName":"已投稿","orderNum":1,"comment":null}
     */

    private int id;
    private int companyId;
    private String themeName;
    private String title;
    private int userId;
    private String userName;
    private String createTime;
    private boolean status;
    private String path;
    private Object url;
    private int processId;
    private String processCode;
    private String processName;
    private int levelId;
    private String levelName;
    private ProcessBean process;

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

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public ProcessBean getProcess() {
        return process;
    }

    public void setProcess(ProcessBean process) {
        this.process = process;
    }
}
