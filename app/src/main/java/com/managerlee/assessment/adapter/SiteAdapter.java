package com.managerlee.assessment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.NewBean;
import com.managerlee.assessment.databinding.ItemSiteBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;

/**
 * Created by anins on 2018/3/28.
 */

public class SiteAdapter extends BaseAdapter<SiteAdapter.Holder, NewBean> {

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSiteBinding itemSiteBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_site, parent, false);
        return new Holder(itemSiteBinding);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemSiteBinding itemSiteBinding;

        public Holder(ItemSiteBinding itemBinding) {
            super(itemBinding.itemSite);
            this.itemSiteBinding = itemBinding;
        }
    }
}
