package com.managerlee.assessment.viewModel;

import android.app.Activity;

import com.managerlee.assessment.adapter.FileListAdapter;
import com.managerlee.assessment.framework.utils.FileUtils;
import com.managerlee.assessment.framework.utils.ToastUtils;

import java.io.File;
import java.util.List;

/**
 * Created by anins on 2018/5/11.
 */

public class FileListViewModel {
    private FileListAdapter adapter;
    private Activity activity;

    public FileListViewModel(Activity activity, FileListAdapter adapter) {
        this.adapter = adapter;
        this.activity = activity;
        onLoad();
    }

    /**
     * 加载文件列表
     */
    private void onLoad() {
        List<File> files = FileUtils.getFileList();
        if (files == null || files.size() == 0) {
            ToastUtils.show("没有文件信息");
        } else {
            adapter.setData(files);
        }
    }

    /**
     * 返回
     */
    public void gotoBack() {
        activity.finish();
    }
}
