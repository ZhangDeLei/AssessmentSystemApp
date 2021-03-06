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
import com.managerlee.assessment.databinding.ItemArticleListBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;
import com.managerlee.assessment.view.WebviewActivity;

/**
 * 网评文章数据源
 * Created by anins on 2018/4/26.
 */

public class ArticleListAdapter extends BaseAdapter<ArticleListAdapter.Holder, ArticleBean> {
    private Context context;
    private ClickEvent clickEvent;
    public ArticleListAdapter(Context context) {
        this.context = context;
        this.clickEvent = new ClickEvent();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemArticleListBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_article_list, parent, false);
        return new Holder(mBinding);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ArticleBean bean = this.data.get(position);
        holder.binding.setArticle(bean);
        holder.binding.setClickEvent(clickEvent);
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemArticleListBinding binding;

        public Holder(ItemArticleListBinding binding) {
            super(binding.llArticleItem);
            this.binding = binding;
        }
    }

    public class ClickEvent {
        public void gotoWebview(View view, ArticleBean bean) {
            Intent in = new Intent(context, WebviewActivity.class);
            in.putExtra("web_url", bean.getUrl());
            context.startActivity(in);
        }
    }
}
