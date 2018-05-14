package com.managerlee.assessment.constant;

/**
 * Created by anins on 2018/5/14.
 */

public enum ActivityType {
    INSERT("新增", 1),
    UPDATE("修改", 2);
    private String type;
    private int code;

    private ActivityType(String type, int code) {
        this.type = type;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
