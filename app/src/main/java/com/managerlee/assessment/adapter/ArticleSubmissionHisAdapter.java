package com.managerlee.assessment.adapter;

import android.content.Context;
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
    private ItemSubmissionService service;
    private Context context;

    public ArticleSubmissionHisAdapter(Context context) {
        this.context = context;
        this.service = new ItemSubmissionService();
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        SubmissionBean bean = this.data.get(position);
        holder.mBinding.setSub(bean);
        holder.mBinding.setService(service);
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

    public class ItemSubmissionService {
        /**
         * 获取流程进度颜色标示
         *
         * @param processCode
         * @return
         */
        public int getProcessColor(String processCode) {
            int textColor = context.getResources().getColor(R.color.grey);
            if ("0003".equals(processCode) || "0005".equals(processCode)) {
                textColor = context.getResources().getColor(R.color.red);
            }
            return textColor;
        }
    }
}
