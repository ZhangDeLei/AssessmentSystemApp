package com.managerlee.assessment.bean;

/**
 * Created by anins on 2018/4/28.
 */

public class ProcessBean {

    /**
     * id : 27
     * submissionId : 16
     * operationTime : 2018-03-16 04:30:21
     * operationUserId : 36
     * operationUserName : 安徽芜湖
     * processId : 32
     * processCode : 0001
     * processName : 已投稿
     * orderNum : 1
     * comment : null
     */

    private int id;
    private int submissionId;
    private String operationTime;
    private int operationUserId;
    private String operationUserName;
    private int processId;
    private String processCode;
    private String processName;
    private int orderNum;
    private Object comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public int getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(int operationUserId) {
        this.operationUserId = operationUserId;
    }

    public String getOperationUserName() {
        return operationUserName;
    }

    public void setOperationUserName(String operationUserName) {
        this.operationUserName = operationUserName;
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

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }
}
