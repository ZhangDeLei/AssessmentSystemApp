package com.managerlee.assessment.framework.utils;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anins on 2018/5/11.
 */

public class FileUtils {
    private static final String[] fileTypes = new String[]{"doc", "docx", "ppt", "pptx"};
    private static final File sdFile = Environment.getExternalStorageDirectory();

    public static List<File> getFileList() {
        List<File> mData = new ArrayList<>();
        getFileList(mData, sdFile);
        return mData;
    }

    /**
     * 递归获取文件信息
     *
     * @param files
     * @param file
     */
    private static void getFileList(List<File> files, File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (null == listFiles) return;
            for (int i = 0; i < listFiles.length; i++) {
                getFileList(files, listFiles[i]);
            }
        } else {
            String fileName = file.getName();
            String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (Arrays.asList(fileTypes).contains(prefix)) {
                files.add(file);
            }
        }
    }

}
