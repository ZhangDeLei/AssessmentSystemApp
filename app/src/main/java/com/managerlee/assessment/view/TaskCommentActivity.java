package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.managerlee.assessment.R;
import com.managerlee.assessment.adapter.TaskCommentAdapter;
import com.managerlee.assessment.bean.TaskBean;
import com.managerlee.assessment.bean.TaskDetail;
import com.managerlee.assessment.databinding.ActivityTaskCommentBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.framework.listener.CompletedListener;
import com.managerlee.assessment.viewModel.TaskCommentViewModel;

/**
 * 任务评论列表
 * Created by anins on 2018/3/23.
 */

public class TaskCommentActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, CompletedListener {
    private ActivityTaskCommentBinding mBinding;
    private TaskCommentViewModel viewModel;
    private TaskCommentAdapter adapter;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_task_comment);
    }

    @Override
    public void bindData() {
        TaskDetail bean = (TaskDetail) getIntent().getSerializableExtra("task");
        adapter = new TaskCommentAdapter();
        viewModel = new TaskCommentViewModel(this, bean, adapter, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.recyclerView.setLayoutManager(layoutManager);
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mBinding.recyclerView.setAdapter(adapter);
        mBinding.recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    viewModel.CurPage++;
                    viewModel.initData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) mBinding.recyclerView.getLayoutManager();
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }
        });
        mBinding.setTask(bean);
        mBinding.setVm(viewModel);
        mBinding.swipeRegreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        if (!mBinding.swipeRegreshLayout.isRefreshing()) {
            viewModel.CurPage = 1;
            adapter.clearData();
            viewModel.initData();
        }
    }

    @Override
    public void onCompleted() {
        if (mBinding.swipeRegreshLayout.isRefreshing()) {
            mBinding.swipeRegreshLayout.setRefreshing(false);
        }
    }
}
