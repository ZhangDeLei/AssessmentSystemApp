package com.managerlee.assessment.framework.dialog.viewModel;

import android.databinding.ObservableField;
import android.view.View;

/**
 * Created by anins on 2018/3/23.
 */

public class ConfirmDialogViewModel {
    ObservableField<String> title = new ObservableField<>();
    ObservableField<String> content = new ObservableField<>();

    public ConfirmDialogViewModel(String title, String content) {
        this.title.set(title);
        this.content.set(content);
    }

    /**
     * 关闭弹框
     *
     * @param view
     */
    public void close(View view) {

    }

    /**
     * 确认弹框
     *
     * @param view
     */
    public void confirm(View view) {

    }
}
