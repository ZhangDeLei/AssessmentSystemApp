package com.managerlee.assessment.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by anins on 2018/3/26.
 */

public class UserBean extends BaseObservable{

    /**
     * id : 5
     * userAccount : admin
     * password : 96e79218965eb72c92a549dd5a330112
     * nickName : 管理员
     * tel : 15156888276
     * sex : 1
     * photoUrl : null
     * status : true
     * typeId : 8
     * typeCode : 0001
     * typeName : 系统
     * email : null
     * starLevelId : null
     * starLevelCode : null
     * starLevelName : null
     * createDateTime : null
     * lastLoginTime : 2018-03-23 02:04:11
     */

    private int id;
    private String userAccount;
    private String password;
    private String nickName;
    private String tel;
    private int sex;
    private Object photoUrl;
    private boolean status;
    private int typeId;
    private String typeCode;
    private String typeName;
    private Object email;
    private Object starLevelId;
    private Object starLevelCode;
    private Object starLevelName;
    private Object createDateTime;
    private String lastLoginTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }
    @Bindable
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }
    @Bindable
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Object getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(Object photoUrl) {
        this.photoUrl = photoUrl;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getStarLevelId() {
        return starLevelId;
    }

    public void setStarLevelId(Object starLevelId) {
        this.starLevelId = starLevelId;
    }

    public Object getStarLevelCode() {
        return starLevelCode;
    }

    public void setStarLevelCode(Object starLevelCode) {
        this.starLevelCode = starLevelCode;
    }

    public Object getStarLevelName() {
        return starLevelName;
    }

    public void setStarLevelName(Object starLevelName) {
        this.starLevelName = starLevelName;
    }

    public Object getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Object createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
