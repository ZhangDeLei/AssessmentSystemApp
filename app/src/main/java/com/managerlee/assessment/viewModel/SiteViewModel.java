package com.managerlee.assessment.viewModel;

import android.content.Context;

import com.managerlee.assessment.adapter.SiteAdapter;
import com.managerlee.assessment.bean.NewBean;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.INewAuthView;
import com.managerlee.assessment.model.impl.NewAuthViewImpl;

import java.util.List;

/**
 * 站点巡查
 * Created by anins on 2018/4/24.
 */

public class SiteViewModel {
    private Context context;
    private SiteAdapter adapter;
    private INewAuthView newAuthView;

    public SiteViewModel(Context context, SiteAdapter adapter) {
        this.context = context;
        this.adapter = adapter;
        this.newAuthView = new NewAuthViewImpl();
        initData();
    }

    private void initData() {
        newAuthView.getNewAuthList(new CallBackListener<List<NewBean>>() {
            @Override
            public void onSuccess(List<NewBean> data) {
                adapter.setData(data);
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
}
