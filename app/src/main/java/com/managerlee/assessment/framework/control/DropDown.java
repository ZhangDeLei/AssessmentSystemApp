package com.managerlee.assessment.framework.control;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.managerlee.assessment.R;
import com.managerlee.assessment.framework.control.adapter.DropDownAdapter;
import com.managerlee.assessment.framework.control.bean.DropDownBean;

import java.util.List;

/**
 * Created by anins on 2018/5/11.
 */

public class DropDown<T extends DropDownBean> implements DropDownAdapter.ItemClickListener {
    private Context context;
    private PopupWindow pw;
    private List<DropDownBean> data;
    private DropDownAdapter adapter;
    private RecyclerView rv;
    private View parentView;

    public DropDown(Context context, List<T> data) {
        this.context = context;
        this.data = (List<DropDownBean>) data;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.popup_dropdown_view, null);
        pw = new PopupWindow(context);
        pw.setContentView(view);
        pw.setOutsideTouchable(true);
        rv = view.findViewById(R.id.recyclerView);
        adapter = new DropDownAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        rv.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        rv.setAdapter(adapter);
        adapter.setData(data);
        adapter.setListener(this);
    }

    @Override
    public void onItemClick(DropDownBean bean) {
        if (parentView instanceof TextView) {
            ((TextView) parentView).setText(bean.getDpname());
            parentView.setTag(bean.getDpid());
        }
        if (listener != null) {
            listener.onItem(bean);
        }
        hide();
    }

    /**
     * 显示
     */
    public void show(View parent) {
        parentView = parent;
        if (pw != null && !pw.isShowing()) {
            pw.setWidth(parent.getWidth());
            pw.setHeight(500);
            pw.showAsDropDown(parent);
        } else {
            hide();
        }
    }

    /**
     * 取消显示
     */
    public void hide() {
        if (pw != null && pw.isShowing()) {
            pw.dismiss();
        }
    }

    /**
     * 是否已经显示
     *
     * @return
     */
    public boolean isShow() {
        return pw.isShowing();
    }

    private OnItemListener listener;

    public interface OnItemListener {
        void onItem(DropDownBean bean);
    }

    public void setListener(OnItemListener listener) {
        this.listener = listener;
    }
}