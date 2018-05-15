package com.managerlee.assessment.service;

import com.managerlee.assessment.bean.TeamBean;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.ResponseData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anins on 2018/5/15.
 */

public interface TeamService {

    @GET(URLConstant.Team_GetTeamListByCompanyId)
    Observable<ResponseData<List<TeamBean>>> getTeamListByCompanyId(@Query("CompanyId") int CompanyId, @Query("Name") String Name);
}
