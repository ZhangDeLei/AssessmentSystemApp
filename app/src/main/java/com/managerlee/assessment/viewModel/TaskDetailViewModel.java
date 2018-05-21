package com.managerlee.assessment.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.os.Environment;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.bean.UserCommentBean;
import com.managerlee.assessment.constant.FileType;
import com.managerlee.assessment.framework.base.BaseViewModel;
import com.managerlee.assessment.framework.dialog.ProgressHelper;
import com.managerlee.assessment.framework.http.event.CallBackListener;
import com.managerlee.assessment.framework.preference.PerferenceConfig;
import com.managerlee.assessment.framework.utils.ToastUtils;
import com.managerlee.assessment.model.IFileView;
import com.managerlee.assessment.model.IUserCommentView;
import com.managerlee.assessment.model.impl.FileViewImpl;
import com.managerlee.assessment.model.impl.UserCommentViewImpl;
import com.managerlee.assessment.view.TaskCommentActivity;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by anins on 2018/5/2.
 */

public class TaskDetailViewModel extends BaseViewModel {

    public ObservableField<Integer> visible = new ObservableField<>();
    public ObservableField<Boolean> sendVisible = new ObservableField<>();
    public ObservableField<Boolean> isAll = new ObservableField<>();
    private WebView webView;
    private IFileView fileView;
    private IUserCommentView commentView;
    private TaskBean taskBean;

    public TaskDetailViewModel(Activity activity, TaskBean taskBean) {
        super(activity);
        fileView = new FileViewImpl();
        commentView = new UserCommentViewImpl();
        this.taskBean = taskBean;
        visible.set(View.VISIBLE);
        sendVisible.set(false);
        isAll.set(false);
    }

    /**
     * 跳转至评论列表界面
     *
     * @param bean
     */
    public void gotoCommentList(TaskBean bean) {
        Intent in = new Intent(activity, TaskCommentActivity.class);
        in.putExtra("task", bean);
        activity.startActivity(in);
    }

    public void setIsFocus(boolean focus) {
        visible.set(focus ? View.GONE : View.VISIBLE);
        sendVisible.set(focus);
    }

    /**
     * 完成任务
     *
     * @param view
     */
    public void startComplated(View view) {
        ProgressHelper.init().show(activity, "正在提交数据...");
        File file = scanView();
        fileView.upload(file, FileType.TASK.getType(), new CallBackListener<String>() {
            @Override
            public void onSuccess(String data) {
                commit(data);
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

    /**
     * 全屏
     *
     * @param view
     */
    public void allWindow(View view) {
        this.isAll.set(!this.isAll.get());
    }

    /**
     * 提交数据
     */
    private void commit(String path) {
        UserCommentBean bean = new UserCommentBean();
        bean.setCompanyId(PerferenceConfig.CompanyId.get());
        bean.setContent("");
        bean.setImageUrl(path);
        bean.setTaskId(taskBean.getId());
        bean.setUserId(PerferenceConfig.UserId.get());
        bean.setExecTypeId(taskBean.getExecTypeId());
        bean.setExecTypeCode(taskBean.getExecTypeCode());
        bean.setExecTypeName(taskBean.getExecTypeName());
        commentView.insert(bean, new CallBackListener<String>() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onError(String msg) {
                ToastUtils.show(msg);
                ProgressHelper.init().close();
            }

            @Override
            public void onCompleted() {
                activity.finish();
                ToastUtils.show("任务完成成功");
                ProgressHelper.init().close();
            }
        });
    }

    /**
     * 屏幕截图
     */
    private File scanView() {
        Picture picture = webView.capturePicture();
        Bitmap bmp = Bitmap.createBitmap(picture.getWidth(), picture.getWidth(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        picture.draw(canvas);
        File file = null;
        if (bmp != null) {
            try {
                // 获取内置SD卡路径
                String sdCardPath = Environment.getExternalStorageDirectory().getPath();
                // 图片文件路径
                String filePath = sdCardPath + File.separator + "screenshot.png";
                file = new File(filePath);
                FileOutputStream os = new FileOutputStream(file);
                bmp.compress(Bitmap.CompressFormat.PNG, 100, os);
                os.flush();
                os.close();
            } catch (Exception e) {
            }
        }
        return file;
    }

    public void setWebView(WebView webView) {
        this.webView = webView;
    }
}
