package com.managerlee.assessment.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.managerlee.assessment.R;

/**
 * 搜索dialog
 * Created by anins on 2018/5/2.
 */

public class SearchDialog extends Dialog {
    private ImageView ivClose;
    private EditText etSearch;
    private TextView search;
    private Activity context;

    public SearchDialog(Activity context) {
        super(context);
        this.context = context;
        initView();
    }

    public void initView() {
        setContentView(R.layout.dialog_search);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ivClose = findViewById(R.id.iv_close);
        etSearch = findViewById(R.id.et_search);
        search = findViewById(R.id.tv_search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onConfirm(etSearch.getText().toString());
                }
            }
        });
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    /**
     * 设置搜索条件
     *
     * @param content
     */
    public void setSearchWhere(String content) {
        etSearch.setText(content);
    }

    private OnClickListener listener;

    public interface OnClickListener {
        void onConfirm(String content);
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }
}
