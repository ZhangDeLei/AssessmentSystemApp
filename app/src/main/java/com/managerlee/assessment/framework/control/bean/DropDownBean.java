package com.managerlee.assessment.framework.control.bean;

/**
 * Created by anins on 2018/5/11.
 */

public class DropDownBean {
    private int dpid;
    private String dpname;

    public DropDownBean(int dpid, String dpname) {
        this.dpid = dpid;
        this.dpname = dpname;
    }

    public int getDpid() {
        return dpid;
    }

    public void setDpid(int dpid) {
        this.dpid = dpid;
    }

    public String getDpname() {
        return dpname;
    }

    public void setDpname(String dpname) {
        this.dpname = dpname;
    }
}
