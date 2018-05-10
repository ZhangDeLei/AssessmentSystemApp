package com.managerlee.assessment.bean;

/**
 * Created by anins on 2018/5/10.
 */

public class UserStatictisBean {

    /**
     * id : 36
     * nickName : 安徽芜湖
     * teamName : 特战队
     * totalSub : 8
     * totalFollow : 2
     * totalTask : 0
     */

    private int id;
    private String nickName;
    private String teamName;
    private int totalSub;
    private int totalFollow;
    private int totalTask;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalSub() {
        return totalSub;
    }

    public void setTotalSub(int totalSub) {
        this.totalSub = totalSub;
    }

    public int getTotalFollow() {
        return totalFollow;
    }

    public void setTotalFollow(int totalFollow) {
        this.totalFollow = totalFollow;
    }

    public int getTotalTask() {
        return totalTask;
    }

    public void setTotalTask(int totalTask) {
        this.totalTask = totalTask;
    }
}
