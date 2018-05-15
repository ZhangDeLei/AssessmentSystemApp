package com.managerlee.assessment.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.bean.TaskDetail;
import com.managerlee.assessment.databinding.ItemTaskBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;
import com.managerlee.assessment.view.TaskDetailActivity;

/**
 * Created by anins on 2018/3/27.
 */

public class TaskAdapter extends BaseAdapter<TaskAdapter.Holder, TaskDetail> {
    private Context context;
    private ClickEvent clickEvent;

    public TaskAdapter(Context context) {
        this.context = context;
        this.clickEvent = new ClickEvent();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTaskBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_task, parent, false);
        return new Holder(itemBinding);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.mBinding.setTask(this.data.get(position));
        holder.mBinding.setClick(clickEvent);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        private ItemTaskBinding mBinding;

        public Holder(ItemTaskBinding itemTaskBinding) {
            super(itemTaskBinding.itemView);
            this.mBinding = itemTaskBinding;
        }
    }

    /**
     * 点击事件处理
     */
    public class ClickEvent {
        /**
         * 进入详情
         */
        public void gotoTaskDetail(TaskBean bean) {
            Intent in = new Intent(context, TaskDetailActivity.class);
            in.putExtra("task", bean);
            context.startActivity(in);
        }
    }
}
