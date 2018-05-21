package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.databinding.ObservableField;

import com.managerlee.assessment.bean.NewBean;
import com.managerlee.assessment.framework.base.BaseViewModel;

public class AuthWebviewViewModel extends BaseViewModel {

    public ObservableField<String> title = new ObservableField<>();
    private NewBean newBean;

    public AuthWebviewViewModel(Activity activity, NewBean newBean) {
        super(activity);
        this.newBean = newBean;
        this.title.set(newBean.getName() + "授权");
    }

    /**
     * 获取授权地址
     * @return
     */
    public String getAuthUrl(){
        return "";
    }
}
