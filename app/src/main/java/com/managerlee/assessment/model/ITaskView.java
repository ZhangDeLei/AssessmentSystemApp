package com.managerlee.assessment.model;

import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.bean.TaskDetail;
import com.managerlee.assessment.bean.TaskInfo;
import com.managerlee.assessment.framework.http.event.CallBackListener;

import java.util.List;
import java.util.Map;

/**
 * Created by anins on 2018/3/27.
 */

public interface ITaskView {

    void getTaskListByUserId(Map<String, Object> params, CallBackListener<List<TaskDetail>> listener);

    void createTask(TaskInfo bean, CallBackListener<String> listener);
}
