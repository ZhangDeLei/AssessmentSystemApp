package com.managerlee.assessment.framework.control.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ItemPopupDropdownViewBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;
import com.managerlee.assessment.framework.control.bean.DropDownBean;

/**
 * Created by anins on 2018/5/11.
 */

public class DropDownAdapter extends BaseAdapter<DropDownAdapter.Holder, DropDownBean> {
    private ClickEvent ce;

    public DropDownAdapter() {
        this.ce = new ClickEvent();
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.mBinding.setDdb(this.data.get(position));
        holder.mBinding.setClick(ce);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPopupDropdownViewBinding binding = DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popup_dropdown_view, parent, false));
        return new Holder(binding);
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemPopupDropdownViewBinding mBinding;

        public Holder(ItemPopupDropdownViewBinding binding) {
            super(binding.llDropdown);
            this.mBinding = binding;
        }
    }

    public class ClickEvent {
        public void itemClick(DropDownBean bean) {
            if (listener != null) {
                listener.onItemClick(bean);
            }
        }
    }

    private ItemClickListener listener;

    public interface ItemClickListener {
        void onItemClick(DropDownBean bean);
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }
}
