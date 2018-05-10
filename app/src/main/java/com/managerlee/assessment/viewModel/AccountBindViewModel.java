package com.managerlee.assessment.viewModel;

import android.app.Activity;

import com.managerlee.assessment.adapter.AccountBindAdapter;
import com.managerlee.assessment.bean.UserNewAuthBean;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.INewAuthView;
import com.managerlee.assessment.model.impl.NewAuthViewImpl;

import java.util.List;

/**
 * Created by anins on 2018/5/2.
 */

public class AccountBindViewModel extends BaseViewModel {
    private INewAuthView newAuthView;
    private AccountBindAdapter adapter;
    private CompletedListener listener;

    public AccountBindViewModel(Activity activity, AccountBindAdapter adapter, CompletedListener listener) {
        super(activity);
        this.newAuthView = new NewAuthViewImpl();
        this.adapter = adapter;
        this.listener = listener;
        initData();
    }

    /**
     * 初始化数据
     */
    public void initData() {
        newAuthView.getUserNewAuthList(new CallBackListener<List<UserNewAuthBean>>() {
            @Override
            public void onSuccess(List<UserNewAuthBean> data) {
                adapter.setData(data);
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
            }

            @Override
            public void onCompleted() {
                listener.onCompleted();
            }
        });
    }
}
