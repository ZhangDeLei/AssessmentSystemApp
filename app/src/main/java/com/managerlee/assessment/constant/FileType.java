package com.managerlee.assessment.constant;

/**
 * Created by anins on 2018/5/14.
 */

public enum FileType {
    PHOTO("photo"), // 照片
    ARTICLE("article"),// 文章
    APP("app"),//应用APP
    NEWICON("newicon");//新闻图标

    private FileType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
