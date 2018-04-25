package com.managerlee.assessment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.DictBean;
import com.managerlee.assessment.databinding.ItemArticleTypeBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;

/**
 * Created by anins on 2018/4/25.
 */

public class ArticleTypeAdapter extends BaseAdapter<ArticleTypeAdapter.Holder, DictBean> {
    private ClickEvent event;
    private Integer CurrentPosition = null;

    public ArticleTypeAdapter() {
        this.event = new ClickEvent();
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        DictBean bean = this.data.get(position);
        if (CurrentPosition == null) {
            CurrentPosition = bean.getId();
        }
        holder.binding.setDict(bean);
        holder.binding.setSelectIndex(CurrentPosition == bean.getId());
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemArticleTypeBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_article_type, parent, false);
        return new Holder(binding);
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemArticleTypeBinding binding;

        public Holder(ItemArticleTypeBinding mBinding) {
            super(mBinding.llType);
            this.binding = mBinding;
        }
    }

    public class ClickEvent {
        /**
         * 点击
         *
         * @param view
         * @param bean
         */
        public void itemClick(View view, DictBean bean) {
            CurrentPosition = bean.getId();
        }
    }
}
