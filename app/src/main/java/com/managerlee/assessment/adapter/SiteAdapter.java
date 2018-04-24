package com.managerlee.assessment.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.NewBean;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.databinding.ItemSiteBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;
import com.managerlee.assessment.view.WebviewActivity;

/**
 * Created by anins on 2018/3/28.
 */

public class SiteAdapter extends BaseAdapter<SiteAdapter.Holder, NewBean> {
    public ClickEvent clickEvent;
    private Context context;

    public SiteAdapter(Context context) {
        this.context = context;
        this.clickEvent = new ClickEvent();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSiteBinding itemSiteBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_site, parent, false);
        return new Holder(itemSiteBinding);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.itemSiteBinding.setNb(this.data.get(position));
        holder.itemSiteBinding.setBaseUrl(URLConstant.BASE_URL.substring(0, URLConstant.BASE_URL.length() - 1));
        holder.itemSiteBinding.setClickEvent(clickEvent);
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemSiteBinding itemSiteBinding;

        public Holder(ItemSiteBinding itemBinding) {
            super(itemBinding.itemSite);
            this.itemSiteBinding = itemBinding;
        }
    }

    public class ClickEvent {
        public void onClick(View view, NewBean bean) {
            Intent in = new Intent(context, WebviewActivity.class);
            in.putExtra("web_url", bean.getUrl());
            context.startActivity(in);
        }
    }
}
