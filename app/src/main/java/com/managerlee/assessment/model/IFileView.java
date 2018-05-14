package com.managerlee.assessment.model;

import com.managerlee.assessment.framework.http.event.CallBackListener;

import java.io.File;

/**
 * Created by anins on 2018/5/14.
 */

public interface IFileView {
    void upload(File file, CallBackListener<String> listener);
}
