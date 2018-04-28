package com.managerlee.assessment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.ArticleLevelBean;
import com.managerlee.assessment.databinding.ItemArticleTypeBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;

/**
 * Created by anins on 2018/4/25.
 */

public class ArticleTypeAdapter extends BaseAdapter<ArticleTypeAdapter.Holder, ArticleLevelBean> {
    private ClickEvent event;
    private int CurrentId = -1;
    private int CurrentPosition = 0;

    public ArticleTypeAdapter() {
        this.event = new ClickEvent();
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ArticleLevelBean bean = this.data.get(position);
        if (CurrentId == -1) {
            CurrentId = bean.getId();
        }
        if (CurrentId == bean.getId()) {
            CurrentPosition = position;
        }
        holder.binding.setLevel(bean);
        holder.binding.setSelectIndex(CurrentId == bean.getId());
        holder.binding.setClickEvent(event);
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

    /**
     * 获取当前Position
     *
     * @return
     */
    public int getCurrentPosition() {
        return CurrentPosition;
    }

    public class ClickEvent {
        /**
         * 点击
         *
         * @param view
         * @param bean
         */
        public void itemClick(View view, ArticleLevelBean bean) {
            CurrentId = bean.getId();
            notifyDataSetChanged();
            if (listener != null) {
                listener.getArticleList(bean);
            }
        }
    }

    private ItemListener listener;

    public void setListener(ItemListener listener) {
        this.listener = listener;
    }

    public interface ItemListener {
        void getArticleList(ArticleLevelBean bean);
    }
}
