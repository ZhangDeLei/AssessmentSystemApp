package com.managerlee.assessment.model.impl;

import com.managerlee.assessment.bean.TeamBean;
import com.managerlee.assessment.framework.http.RetrofitHelper;
import com.managerlee.assessment.framework.http.data.ResponseCode;
import com.managerlee.assessment.framework.http.data.ResponseData;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.model.ITeamView;
import com.managerlee.assessment.service.TeamService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anins on 2018/5/15.
 */

public class TeamViewImpl implements ITeamView {
    private TeamService service;

    public TeamViewImpl() {
        service = RetrofitHelper.init().getRetrofit().create(TeamService.class);
    }

    @Override
    public void getTeamListByCompanyId(int CompanyId, final CallBackListener<List<TeamBean>> listener) {
        service.getTeamListByCompanyId(CompanyId, "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseData<List<TeamBean>>>() {
                    @Override
                    public void onNext(ResponseData<List<TeamBean>> response) {
                        if (response.getCode() == ResponseCode.SUCCESS) {
                            listener.onSuccess(response.getData());
                        } else {
                            listener.onError(response.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
