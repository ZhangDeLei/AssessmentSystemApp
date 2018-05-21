package com.managerlee.assessment.bean;

import java.io.Serializable;

/**
 * Created by anins on 2018/5/15.
 */

public class TaskDetail extends TaskBean implements Serializable{
    private int total;
    private int commentTotal;
    private boolean userComplated;

    public boolean isUserComplated() {
        return userComplated;
    }

    public void setUserComplated(boolean userComplated) {
        this.userComplated = userComplated;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(int commentTotal) {
        this.commentTotal = commentTotal;
    }
}
