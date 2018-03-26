package com.managerlee.assessment.update.bean;

/**
 * Created by anins on 2018/3/23.
 */

public class AppUpdateBean {

    /**
     * id : 3
     * name : 网评系统
     * version : v1.0.1
     * versionCode : 3
     * comment : 1
     * url : /upload/app/app_1521611141562.apk
     * uploadTime : 2018-03-21 01:45:41
     * uploadUserId : 5
     * uploadUserName : 管理员
     * typeId : 49
     * typeCode : 0002
     * typeName : Android
     */

    private int id;
    private String name;
    private String version;
    private int versionCode;
    private String comment;
    private String url;
    private String uploadTime;
    private int uploadUserId;
    private String uploadUserName;
    private int typeId;
    private String typeCode;
    private String typeName;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getUploadUserId() {
        return uploadUserId;
    }

    public void setUploadUserId(int uploadUserId) {
        this.uploadUserId = uploadUserId;
    }

    public String getUploadUserName() {
        return uploadUserName;
    }

    public void setUploadUserName(String uploadUserName) {
        this.uploadUserName = uploadUserName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
