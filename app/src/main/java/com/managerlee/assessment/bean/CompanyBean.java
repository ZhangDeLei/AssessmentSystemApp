package com.managerlee.assessment.bean;

/**
 * Created by anins on 2018/4/24.
 */

public class CompanyBean {

    /**
     * id : 19
     * name : 安徽芜湖
     * shortName : 芜湖
     * concatUserName : 张
     * concatUserPhone : 15156888276
     * address : 安徽芜湖
     * createDate : 2018-03-07 02:10:25
     * expiredDate : 2018-03-31 14:10:18
     * maxNumUser : 10
     */

    private int id;
    private String name;
    private String shortName;
    private String concatUserName;
    private String concatUserPhone;
    private String address;
    private String createDate;
    private String expiredDate;
    private int maxNumUser;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getConcatUserName() {
        return concatUserName;
    }

    public void setConcatUserName(String concatUserName) {
        this.concatUserName = concatUserName;
    }

    public String getConcatUserPhone() {
        return concatUserPhone;
    }

    public void setConcatUserPhone(String concatUserPhone) {
        this.concatUserPhone = concatUserPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public int getMaxNumUser() {
        return maxNumUser;
    }

    public void setMaxNumUser(int maxNumUser) {
        this.maxNumUser = maxNumUser;
    }
}
