package com.managerlee.assessment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.managerlee.assessment.R;
import com.managerlee.assessment.bean.SubmissionBean;
import com.managerlee.assessment.databinding.ItemArticleSubmissionHisBinding;
import com.managerlee.assessment.framework.base.BaseAdapter;

/**
 * Created by anins on 2018/4/28.
 */

public class ArticleSubmissionHisAdapter extends BaseAdapter<ArticleSubmissionHisAdapter.Holder, SubmissionBean> {

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        SubmissionBean bean = this.data.get(position);
        holder.mBinding.setSub(bean);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemArticleSubmissionHisBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_article_submission_his, parent, false);
        return new Holder(binding);
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemArticleSubmissionHisBinding mBinding;

        public Holder(ItemArticleSubmissionHisBinding binding) {
            super(binding.llSubmissionHis);
            this.mBinding = binding;
        }
    }
}
