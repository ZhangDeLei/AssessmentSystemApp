package com.managerlee.assessment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.bean.TaskInfo;
import com.managerlee.assessment.databinding.ItemTaskBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;

/**
 * Created by anins on 2018/3/27.
 */

public class TaskAdapter extends BaseAdapter<TaskAdapter.Holder, TaskBean> {

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTaskBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_task, parent, false);
        return new Holder(itemBinding);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        TaskInfo taskInfo= new TaskInfo();
        holder.mBinding.setTask(taskInfo);
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
}
