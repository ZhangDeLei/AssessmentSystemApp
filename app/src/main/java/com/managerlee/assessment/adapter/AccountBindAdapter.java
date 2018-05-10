package com.managerlee.assessment.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.UserNewAuthBean;
import com.managerlee.assessment.databinding.ItemAccountBindBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;

/**
 * Created by anins on 2018/5/2.
 */

public class AccountBindAdapter extends BaseAdapter<AccountBindAdapter.Holder, UserNewAuthBean> {
    private Context context;

    public AccountBindAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemAccountBindBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_account_bind, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        UserNewAuthBean bean = this.data.get(position);
        holder.binding.setNewBean(bean);
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemAccountBindBinding binding;

        public Holder(ItemAccountBindBinding binding) {
            super(binding.llAccountBinding);
            this.binding = binding;
        }
    }
}
