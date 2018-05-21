package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.managerlee.assessment.bean.ArticleLevelBean;
import com.managerlee.assessment.bean.SubmissionBean;
import com.managerlee.assessment.constant.FileType;
import com.managerlee.assessment.dialog.FileCheckDialog;
import com.managerlee.assessment.framework.control.DropDown;
import com.managerlee.assessment.framework.control.bean.DropDownBean;
import com.managerlee.assessment.framework.dialog.ProgressHelper;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.StringUtil;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.IArticleLevelView;
import com.managerlee.assessment.model.IFileView;
import com.managerlee.assessment.model.ISubmissionView;
import com.managerlee.assessment.model.impl.ArticleLevelViewImpl;
import com.managerlee.assessment.model.impl.FileViewImpl;
import com.managerlee.assessment.model.impl.SubmissionViewImpl;
import com.managerlee.assessment.view.ArticleSubmissionHisActivity;
import com.managerlee.assessment.view.FileListActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anins on 2018/4/28.
 */

public class ArticleSubmissionViewModel implements FileCheckDialog.OnEventListener {
    private Activity context;
    private DropDown dp;
    private IArticleLevelView levelView;
    private IFileView fileView;
    private ISubmissionView submissionView;
    private List<DropDownBean> levelBeans = new ArrayList<>();
    private FileCheckDialog dialog;
    public ObservableField<File> file = new ObservableField<>();//文件信息
    public ObservableField<String> title = new ObservableField<>();//标题
    public ObservableField<DropDownBean> level = new ObservableField<>();//级别信息
    public ObservableField<String> theme = new ObservableField<>();//主题
    public ObservableField<String> comment = new ObservableField<>();//备注
    public ObservableField<Integer> visible = new ObservableField<>();//是否显示
    private SubmissionBean CurrentSubmission;//当前需要更新的投稿信息

    public ArticleSubmissionViewModel(Activity context) {
        this.context = context;
        this.levelView = new ArticleLevelViewImpl();
        this.fileView = new FileViewImpl();
        this.submissionView = new SubmissionViewImpl();
        this.visible.set(View.GONE);
        initData();
    }

    private void initData() {
        getArticleLevelList();
    }

    /**
     * 提交投稿
     */
    public void commit() {
        try {
            if (StringUtil.isNull(title.get())) {
                ToastUtils.show("请输入标题");
            } else if (StringUtil.isNull(theme.get())) {
                ToastUtils.show("请输入主题");
            } else if (level == null || level.get() == null || StringUtil.isNull(level.get().getDpname())) {
                ToastUtils.show("请选择文章级别");
            } else if (file == null || file.get() == null || StringUtil.isNull(file.get().getName())) {
                ToastUtils.show("请选择上传文件");
            } else {
                ProgressHelper.init().show(context, "投稿中...");
                updateFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     */
    private void updateFile() {
        fileView.upload(file.get(), FileType.ARTICLE.getType(), new CallBackListener<String>() {
            @Override
            public void onSuccess(String data) {
                confirmSubmission(data);
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
                ProgressHelper.init().close();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void insertSubmission(SubmissionBean bean) {
        submissionView.insertSubmission(bean, new CallBackListener<String>() {
            @Override
            public void onSuccess(String data) {
                ToastUtils.show("投稿成功");
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
                ProgressHelper.init().close();
            }

            @Override
            public void onCompleted() {
                ProgressHelper.init().close();
                context.finish();
            }
        });
    }

    private void updateSubmission(SubmissionBean bean) {
        submissionView.updateSubmission(bean, new CallBackListener<String>() {
            @Override
            public void onSuccess(String data) {
                ToastUtils.show("修改成功");
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
                ProgressHelper.init().close();
            }

            @Override
            public void onCompleted() {
                ProgressHelper.init().close();
                context.finish();
            }
        });
    }

    /**
     * 新增投稿
     */
    private void confirmSubmission(String filePath) {
        SubmissionBean bean = new SubmissionBean();
        bean.setCompanyId(PerferenceConfig.CompanyId.get());
        bean.setLevelId(level.get().getDpid());
        bean.setLevelName(level.get().getDpname());
        bean.setPath(filePath);
        bean.setTitle(title.get());
        bean.setUserId(PerferenceConfig.UserId.get());
        bean.setUserName(PerferenceConfig.NickName.get());
        bean.setThemeName(theme.get());
        bean.setStatus(false);
        if (CurrentSubmission == null) {
            insertSubmission(bean);
        } else {
            bean.setId(CurrentSubmission.getId());
            updateSubmission(bean);
        }
    }

    /**
     * 跳转至投稿历史记录列表界面
     */
    public void gotoSubmissionHis() {
        context.startActivity(new Intent(context, ArticleSubmissionHisActivity.class));
    }

    /**
     * 关闭当前界面
     */
    public void gotoBack() {
        context.finish();
    }

    /**
     * 打开文件选择
     */
    public void showFileDialog() {
        if (dialog == null) dialog = new FileCheckDialog(context);
        dialog.setListener(this);
        dialog.show();
    }

    @Override
    public void onFileListener() {
        dialog.dismiss();
        Intent in = new Intent(context, FileListActivity.class);
        context.startActivityForResult(in, 1);
    }

    /**
     * 设置文件名称
     *
     * @param file
     */
    public void setFile(File file) {
        this.file.set(file);
    }

    /**
     * 显示下拉选择
     *
     * @param view
     */
    public void showDropDown(View view) {
        if (dp == null) {
            dp = new DropDown(context, levelBeans);
            dp.setListener(new DropDown.OnItemListener() {
                @Override
                public void onItem(DropDownBean bean) {
                    level.set(bean);
                }
            });
        }
        if (dp.isShow()) {
            dp.hide();
        } else {
            dp.show(view);
        }
    }

    /**
     * 获取文章级别
     */
    private void getArticleLevelList() {
        levelView.getArticleLevelList(PerferenceConfig.CompanyId.get(), "", new CallBackListener<List<ArticleLevelBean>>() {
            @Override
            public void onSuccess(List<ArticleLevelBean> data) {
                levelBeans = ConvertDropBean(data);
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
     * 根据ID获取投稿信息
     *
     * @param Id
     */
    private void getSubmissionById(int Id) {
        ProgressHelper.init().show(context, "正在加载数据...");
        submissionView.getSubmissionById(Id, new CallBackListener<SubmissionBean>() {
            @Override
            public void onSuccess(SubmissionBean data) {
                comment.set(data.getProcess().getComment());
            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
                ProgressHelper.init().close();
            }

            @Override
            public void onCompleted() {
                ProgressHelper.init().close();
            }
        });
    }

    /**
     * 转换
     *
     * @param mList
     * @return
     */
    private List<DropDownBean> ConvertDropBean(List<ArticleLevelBean> mList) {
        List<DropDownBean> mResult = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            ArticleLevelBean bean = mList.get(i);
            DropDownBean d = new DropDownBean(bean.getId(), bean.getName());
            mResult.add(d);
        }
        return mResult;
    }

    /**
     * 设置需要更新的稿件信息
     *
     * @param currentSubmission
     */
    public void setCurrentSubmission(SubmissionBean currentSubmission) {
        if (currentSubmission != null) {
            CurrentSubmission = currentSubmission;
            this.title.set(currentSubmission.getTitle());
            this.theme.set(currentSubmission.getThemeName());
            DropDownBean bean = new DropDownBean(currentSubmission.getLevelId(), currentSubmission.getLevelName());
            this.level.set(bean);
            getSubmissionById(currentSubmission.getId());
            this.visible.set(View.VISIBLE);
        }
    }
}
