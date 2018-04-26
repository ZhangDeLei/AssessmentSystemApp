package com.managerlee.assessment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.ArticleBean;
import com.managerlee.assessment.databinding.ItemArticleListBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;

/**
 * 网评文章数据源
 * Created by anins on 2018/4/26.
 */

public class ArticleListAdapter extends BaseAdapter<ArticleListAdapter.Holder,ArticleBean> {

    public ArticleListAdapter() {
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
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemArticleListBinding binding;

        public Holder(ItemArticleListBinding binding) {
            super(binding.llArticleItem);
            this.binding = binding;
        }
    }
}
