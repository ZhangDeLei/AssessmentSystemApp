package com.managerlee.assessment.bean;

import java.util.List;

/**
 * Created by anins on 2018/3/27.
 */

public class TaskInfo extends TaskBean {
    private List<TeamBean> teams;

    public List<TeamBean> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamBean> teams) {
        this.teams = teams;
    }
}
