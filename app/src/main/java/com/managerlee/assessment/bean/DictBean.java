package com.managerlee.assessment.bean;

/**
 * Created by anins on 2018/4/25.
 */

public class DictBean {

    /**
     * id : 25
     * name : 网评文章级别
     * enName : Level
     * code : 0001
     * label : 国级
     * description : null
     * status : true
     */

    private int id;
    private String name;
    private String enName;
    private String code;
    private String label;
    private Object description;
    private boolean status;

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

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
