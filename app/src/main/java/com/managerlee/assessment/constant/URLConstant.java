package com.managerlee.assessment.constant;

/**
 * Created by anins on 2018/3/23.
 */

public class URLConstant {
    public static final String BASE_URL = "http://192.168.1.117:8080/lamj/"; //基础地址
    public static final String GetNewVersion = "api/appManager/getAppByNewForAndroid"; //获取最新的版本信息
    public static final String Login_URL = "api/auth/login"; //登陆

    //字典值
    public static final String Dict_GetDictListByEnName = "api/dictionary/getDictListByEnName"; //根据英文名称获取字典值列表

    //文章管理
    public static final String Article_GetArticleListForApp = "api/article/getArticleListForApp";//获取文章列表
    public static final String Article_GetArticleTypeForApp = "api/article/getArticleTypeForApp"; //获取网站合集列表

    //任务管理
    public static final String Task_GetTaskListByUserId = "api/task/getTaskListByUserId"; //根据用户ID获取任务列表
    public static final String Task_GetTaskById = "api/task/getTaskById";//根据ID获取任务信息
    public static final String Task_Delete = "api/task/delete";//删除任务
    public static final String Task_Update = "api/task/update";//更新任务
    public static final String Task_Insert = "api/task/insert";//新增任务

    //新闻客户端管理
    public static final String NewAuth_GetNewAuthListByCompanyId = "api/newAuth/getNewAuthListByCompanyId"; //获取企业新闻客户端列表

    //文章级别管理
    public static final String ArticleLevel_GetArticleLevelList = "api/articleLevel/getArticleLevelList"; //获取文章级别列表

    //投稿管理
    public static final String Sub_Insert = "api/submission/insert";//新增投稿记录
    public static final String Sub_GetSubmissionListByUserId = "api/submission/getSubmissionListByUserId";//获取用户的投稿记录
}
