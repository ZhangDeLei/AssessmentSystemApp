package com.managerlee.assessment.bean;

/**
 * Created by anins on 2018/3/27.
 */

public class TeamBean {

    /**
     * id : 5
     * name : 特战队
     * status : true
     * companyId : 19
     * companyName : 安徽芜湖
     * description : null
     */

    private int id;
    private String name;
    private boolean status;
    private int companyId;
    private String companyName;
    private Object description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }
}
