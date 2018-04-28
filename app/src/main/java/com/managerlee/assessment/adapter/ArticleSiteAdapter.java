package com.managerlee.assessment.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.ArticleBean;
import com.managerlee.assessment.databinding.ItemArticleSiteBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;
import com.managerlee.assessment.view.WebviewActivity;

/**
 * 网站合集数据源
 * Created by anins on 2018/4/28.
 */

public class ArticleSiteAdapter extends BaseAdapter<ArticleSiteAdapter.Holder, ArticleBean> {
    private Context context;
    private ClickEvent clickEvent;

    public ArticleSiteAdapter(Context context) {
        this.context = context;
        this.clickEvent = new ClickEvent();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemArticleSiteBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_article_site, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ArticleBean bean = this.data.get(position);
        holder.mBinding.setArticle(bean);
        holder.mBinding.setClickEvent(clickEvent);
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemArticleSiteBinding mBinding;

        public Holder(ItemArticleSiteBinding binding) {
            super(binding.llItemArticleSite);
            this.mBinding = binding;
        }
    }

    public class ClickEvent {
        public void gotoPage(View view, ArticleBean bean) {
            Intent in = new Intent(context, WebviewActivity.class);
            in.putExtra("web_url", bean.getUrl());
            context.startActivity(in);
        }
    }
}
