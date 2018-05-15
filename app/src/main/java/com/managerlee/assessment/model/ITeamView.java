package com.managerlee.assessment.model;

import com.managerlee.assessment.bean.TeamBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;

import java.util.List;

/**
 * Created by anins on 2018/5/15.
 */

public interface ITeamView {
    void getTeamListByCompanyId(int CompanyId, CallBackListener<List<TeamBean>> listener);
}
