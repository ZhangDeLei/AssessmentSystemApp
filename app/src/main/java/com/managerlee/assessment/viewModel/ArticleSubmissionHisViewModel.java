package com.managerlee.assessment.viewModel;

import android.app.Activity;

import com.managerlee.assessment.adapter.ArticleSubmissionHisAdapter;
import com.managerlee.assessment.bean.SubmissionBean;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.framework.page.Page;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.ISubmissionView;
import com.managerlee.assessment.model.impl.SubmissionViewImpl;

import java.util.List;

/**
 * Created by anins on 2018/4/28.
 */

public class ArticleSubmissionHisViewModel extends BaseViewModel {
    private ISubmissionView submissionView;
    private ArticleSubmissionHisAdapter adapter;
    private CompletedListener listener;

    public ArticleSubmissionHisViewModel(Activity context, ArticleSubmissionHisAdapter adapter, CompletedListener listener) {
        super(context);
        this.adapter = adapter;
        this.submissionView = new SubmissionViewImpl();
        this.listener = listener;
        this.getData(CurPage);
    }

    /**
     * 获取数据
     *
     * @param CurPage
     */
    public void getData(int CurPage) {
        submissionView.getSubmissionList(
                PerferenceConfig.CompanyId.get(),
                PerferenceConfig.UserId.get(),
                Page.PageSize,
                CurPage,
                new CallBackListener<List<SubmissionBean>>() {
                    @Override
                    public void onSuccess(List<SubmissionBean> data) {
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
