package com.managerlee.assessment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ItemFileListBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;

import java.io.File;

/**
 * Created by anins on 2018/5/11.
 */

public class FileListAdapter extends BaseAdapter<FileListAdapter.Holder, File> {
    private ClickEvent clickEvent;

    public FileListAdapter() {
        clickEvent = new ClickEvent();
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.mBinding.setFile(this.data.get(position));
        holder.mBinding.setClick(clickEvent);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemFileListBinding binding = DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_list, parent, false));
        return new Holder(binding);
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemFileListBinding mBinding;

        public Holder(ItemFileListBinding binding) {
            super(binding.llItem);
            this.mBinding = binding;
        }
    }

    public class ClickEvent {
        public void onItemClick(File file) {
            if (listener != null) {
                listener.onItemClick(file);
            }
        }
    }

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(File file);
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
