package com.managerlee.assessment.bean;

/**
 * 网评文章实体
 * Created by anins on 2018/4/26.
 */

public class ArticleBean {

    /**
     * id : 2
     * title : 苏联原子弹为何在短时间内就研制成功？这6000页美国资料相当关键1
     * url : https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9477013323349128134%22%7D&n_type=0&p_from=1
     * typeId : 42
     * typeCode : 0002
     * typeName : 文章
     * createUserId : 36
     * createUserName : 安徽芜湖
     * createTime : 2018-03-16 05:28:58
     * companyId : 19
     */

    private int id;
    private String title;
    private String url;
    private int typeId;
    private String typeCode;
    private String typeName;
    private String createUserId;
    private String createUserName;
    private String createTime;
    private int companyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
