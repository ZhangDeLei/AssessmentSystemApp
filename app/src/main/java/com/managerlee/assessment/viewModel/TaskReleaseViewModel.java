package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.TextView;

import com.managerlee.assessment.bean.DictBean;
import com.managerlee.assessment.bean.NewBean;
import com.managerlee.assessment.bean.TaskInfo;
import com.managerlee.assessment.bean.TeamBean;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.control.DropDown;
import com.managerlee.assessment.framework.control.bean.DropDownBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.StringUtil;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.IDictionaryView;
import com.managerlee.assessment.model.INewAuthView;
import com.managerlee.assessment.model.ITaskView;
import com.managerlee.assessment.model.ITeamView;
import com.managerlee.assessment.model.impl.DictionaryViewImpl;
import com.managerlee.assessment.model.impl.NewAuthViewImpl;
import com.managerlee.assessment.model.impl.TaskViewImpl;
import com.managerlee.assessment.model.impl.TeamViewImpl;
import com.managerlee.assessment.widget.CustomDatePicker;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by anins on 2018/5/14.
 */

public class TaskReleaseViewModel extends BaseViewModel {
    private ITaskView taskView;
    private IDictionaryView dictionaryView;
    private ITeamView teamView;
    private INewAuthView newAuthView;
    private DropDown siteDp, taskTypeDp, operatorTypeDp, teamDp;
    private List<DropDownBean> siteListDp, taskTypeListDp, operatorTypeListDp, teamListDp;
    private List<DictBean> operatorDictList, taskTypeDictList;
    private List<TeamBean> teamList;
    private List<NewBean> siteList;
    private CustomDatePicker datePicker;
    public ObservableField<TaskInfo> taskInfo = new ObservableField<>();//任务信息


    public TaskReleaseViewModel(Activity activity) {
        super(activity);
        taskView = new TaskViewImpl();
        dictionaryView = new DictionaryViewImpl();
        teamView = new TeamViewImpl();
        newAuthView = new NewAuthViewImpl();
        taskInfo.set(new TaskInfo());
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        getOperatorTypeList();
        getSiteList();
        getTaskTypeList();
        getTeamList();
    }

    /**
     * 提交数据
     */
    public void commit(View view) {
        if (StringUtil.isNull(taskInfo.get().getUrl())) {
            ToastUtils.show("请输入地址");
        } else if (StringUtil.isNull(taskInfo.get().getNewName())) {
            ToastUtils.show("请选择网站");
        } else if (StringUtil.isNull(taskInfo.get().getTitle())) {
            ToastUtils.show("请输入标题");
        } else if (StringUtil.isNull(taskInfo.get().getTypeName())) {
            ToastUtils.show("请输入任务类别");
        } else if (StringUtil.isNull(taskInfo.get().getComment())) {
            ToastUtils.show("请输入任务要求");
        } else if (StringUtil.isNull(taskInfo.get().getExpireDate())) {
            ToastUtils.show("请选择完成时段");
        } else if (taskInfo.get().getTeams() == null || taskInfo.get().getTeams().size() == 0) {
            ToastUtils.show("请选择执行队伍");
        } else {
            taskInfo.get().setCompanyId(PerferenceConfig.CompanyId.get());
            taskInfo.get().setCreateUserId(PerferenceConfig.UserId.get());
            taskInfo.get().setCreateUserName(PerferenceConfig.NickName.get());
            taskView.createTask(taskInfo.get(), new CallBackListener<String>() {
                @Override
                public void onSuccess(String data) {
                    ToastUtils.show("发布成功");
                }

                @Override
                public void onError(String msg) {
                    ToastUtils.show(msg);
                }

                @Override
                public void onCompleted() {
                    activity.finish();
                }
            });
        }
    }

    /**
     * 显示日期选择
     *
     * @param view
     */
    public void showTime(final View view) {
        if (datePicker == null) {
            datePicker = new CustomDatePicker(activity, new CustomDatePicker.ResultHandler() {
                @Override
                public void handle(String time) {
                    String value = time + ":00";
                    ((TextView) view).setText(value);
                    taskInfo.get().setExpireDate(value);
                }
            }, "2000-01-01 00:00", "2099-12-12 00:00");
            datePicker.showSpecificTime(true);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String now = sdf.format(new Date());
        datePicker.show(now);
    }

    /**
     * 显示网站列表
     */
    public void showSite(View view) {
        if (siteDp == null) {
            siteDp = new DropDown(activity, siteListDp);
            siteDp.setListener(new DropDown.OnItemListener() {
                @Override
                public void onItem(DropDownBean bean) {
                    taskInfo.get().setNewId(bean.getDpid());
                    taskInfo.get().setNewName(bean.getDpname());
                }
            });
        }
        siteDp.show(view);
    }

    /**
     * 显示任务类别
     */
    public void showTaskType(View view) {
        if (taskTypeDp == null) {
            taskTypeDp = new DropDown(activity, operatorTypeListDp);
            taskTypeDp.setListener(new DropDown.OnItemListener() {
                @Override
                public void onItem(DropDownBean bean) {
                    DictBean dict = getDictBeanByList(bean.getDpid(), operatorDictList);
                    taskInfo.get().setTypeCode(dict.getCode());
                    taskInfo.get().setTypeId(dict.getId());
                    taskInfo.get().setTypeName(dict.getLabel());
                }
            });
        }
        taskTypeDp.show(view);
    }

    /**
     * 显示执行类别
     */
    public void showOperatorType(View view) {
        if (operatorTypeDp == null) {
            operatorTypeDp = new DropDown(activity, taskTypeListDp);
            operatorTypeDp.setListener(new DropDown.OnItemListener() {
                @Override
                public void onItem(DropDownBean bean) {
                    DictBean dict = getDictBeanByList(bean.getDpid(), taskTypeDictList);
                    taskInfo.get().setExecTypeCode(dict.getCode());
                    taskInfo.get().setExecTypeId(dict.getId());
                    taskInfo.get().setExecTypeName(dict.getLabel());
                }
            });
        }
        operatorTypeDp.show(view);
    }

    /**
     * 显示执行范围
     */
    public void showTeamList(View view) {
        if (teamDp == null) {
            teamDp = new DropDown(activity, teamListDp);
            teamDp.setListener(new DropDown.OnItemListener() {
                @Override
                public void onItem(DropDownBean bean) {
                    TeamBean team = getTeamBeanById(bean.getDpid(), teamList);
                    if (taskInfo.get().getTeams() == null) {
                        List<TeamBean> teams = new ArrayList<>();
                        teams.add(team);
                        taskInfo.get().setTeams(teams);
                    } else {
                        List<TeamBean> teams = taskInfo.get().getTeams();
                        teams.add(team);
                        taskInfo.get().setTeams(teams);
                    }
                }
            });
        }
        teamDp.show(view);
    }

    /**
     * 根据ID获取任务详细信息
     *
     * @param Id
     */
    public void getTaskById(int Id) {
    }

    /**
     * 获取网站列表
     */
    private void getSiteList() {
        newAuthView.getNewAuthList(new CallBackListener<List<NewBean>>() {
            @Override
            public void onSuccess(List<NewBean> data) {
                siteList = data;
                siteListDp = getDropDownList(siteList, "id", "name");
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    /**
     * 获取任务类别列表
     */
    private void getTaskTypeList() {
        getDictType("ExecType");
    }

    /**
     * 获取执行类别列表
     */
    private void getOperatorTypeList() {
        getDictType("OprType");
    }

    /**
     * 获取队伍列表
     */
    private void getTeamList() {
        teamView.getTeamListByCompanyId(PerferenceConfig.CompanyId.get(), new CallBackListener<List<TeamBean>>() {
            @Override
            public void onSuccess(List<TeamBean> data) {
                teamList = data;
                teamListDp = getDropDownList(teamList, "id", "name");
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    /**
     * 获取字典值数据
     *
     * @param EnName
     */
    private void getDictType(final String EnName) {
        dictionaryView.getDictListByEnName(EnName, new CallBackListener<List<DictBean>>() {
            @Override
            public void onSuccess(List<DictBean> data) {
                if ("ExecType".equals(EnName)) {
                    taskTypeDictList = data;
                    taskTypeListDp = getDropDownList(taskTypeDictList, "id", "label");
                } else {
                    operatorDictList = data;
                    operatorTypeListDp = getDropDownList(operatorDictList, "id", "label");
                }
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    /**
     * 获取下拉列表数据
     *
     * @param mData
     * @param keyId
     * @param keyName
     * @return
     */
    private List<DropDownBean> getDropDownList(List mData, String keyId, String keyName) {
        List<DropDownBean> mResult = new ArrayList<>();
        if (mData != null && mData.size() > 0) {
            for (Object obj : mData) {
                int id = (int) getClsValue(obj, keyId);
                String name = getClsValue(obj, keyName).toString();
                DropDownBean bean = new DropDownBean(id, name);
                mResult.add(bean);
            }
        }
        return mResult;
    }

    /**
     * 通过反射获取类值
     *
     * @param obj
     * @param key
     * @return
     */
    private Object getClsValue(Object obj, String key) {
        Class cls = obj.getClass();
        Field[] fs = cls.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true);
            try {
                if (f.getName().endsWith(key)) {
                    return f.get(obj);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /**
     * 根据ID获取具体的实体信息
     *
     * @param Id
     * @return
     */
    private DictBean getDictBeanByList(int Id, List<DictBean> mList) {
        DictBean bean = null;
        if (mList != null && mList.size() > 0) {
            for (DictBean dict : mList) {
                if (Id == dict.getId()) {
                    bean = dict;
                    break;
                }
            }
        }
        return bean;
    }

    /**
     * 获取队伍列表
     *
     * @param Id
     * @param mList
     * @return
     */
    private TeamBean getTeamBeanById(int Id, List<TeamBean> mList) {
        TeamBean bean = null;
        if (mList != null && mList.size() > 0) {
            for (TeamBean team : mList) {
                if (Id == team.getId()) {
                    bean = team;
                    break;
                }
            }
        }
        return bean;
    }
}
