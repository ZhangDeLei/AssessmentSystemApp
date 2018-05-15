package com.managerlee.assessment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.UserCommentBean;
import com.managerlee.assessment.databinding.ItemTaskCommentBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;

/**
 * Created by anins on 2018/5/15.
 */

public class TaskCommentAdapter extends BaseAdapter<TaskCommentAdapter.Holder, UserCommentBean> {

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        UserCommentBean bean = this.data.get(position);
        holder.mBinding.setComment(bean);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTaskCommentBinding binding = DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_comment, parent, false));
        return new Holder(binding);
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemTaskCommentBinding mBinding;

        public Holder(ItemTaskCommentBinding binding) {
            super(binding.llTaskComment);
            this.mBinding = binding;
        }
    }
}
