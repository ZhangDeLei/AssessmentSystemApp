package com.managerlee.assessment.service;

import com.managerlee.assessment.bean.TaskInfo;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.PageData;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.bean.TaskBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by anins on 2018/3/27.
 */

public interface TaskService {

    @GET(URLConstant.Task_GetTaskListByUserId)
    Observable<ResponseData<PageData<TaskBean>>> getUserTaskList(@QueryMap Map<String, Object> params);

    @GET(URLConstant.Task_GetTaskById)
    Observable<ResponseData<TaskBean>> getTaskById(@Query("Id") int id);

    @POST(URLConstant.Task_Insert)
    Observable<ResponseData<String>> insert(@Body TaskInfo bean);

    @POST(URLConstant.Task_Update)
    Observable<ResponseData<Object>> update(@Body TaskInfo bean);

    @POST(URLConstant.Task_Delete)
    Observable<ResponseData<Object>> delete(@Body Map<String, Integer> params);
}
