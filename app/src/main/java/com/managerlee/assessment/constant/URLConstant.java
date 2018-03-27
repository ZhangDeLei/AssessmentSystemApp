package com.managerlee.assessment.constant;

/**
 * Created by anins on 2018/3/23.
 */

public class URLConstant {
    public static final String BASE_URL="http://192.168.1.117:8080/lamj/"; //基础地址
    public static final String GetNewVersion = "api/appManager/getAppByNewForAndroid"; //获取最新的版本信息
    public static final String Login_URL = "api/auth/login"; //登陆

    public static final String Task_GetTaskListByUserId = "api/task/getTaskListByUserId"; //根据用户ID获取任务列表
    public static final String Task_GetTaskById = "api/task/getTaskById";//根据ID获取任务信息
    public static final String Task_Delete = "api/task/delete";//删除任务
    public static final String Task_Update = "api/task/update";//更新任务
    public static final String Task_Insert = "api/task/insert";//新增任务


}
