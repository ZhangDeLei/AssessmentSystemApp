package com.managerlee.assessment.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.managerlee.assessment.R;
import com.managerlee.assessment.adapter.FileListAdapter;
import com.managerlee.assessment.databinding.ActivityFileListBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.viewModel.FileListViewModel;

import java.io.File;

/**
 * Created by anins on 2018/5/11.
 */

public class FileListActivity extends BaseActivity implements FileListAdapter.OnItemClickListener {
    private ActivityFileListBinding mBinding;
    private FileListViewModel viewModel;
    private FileListAdapter adapter;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_file_list);
    }

    @Override
    public void bindData() {
        adapter = new FileListAdapter();
        viewModel = new FileListViewModel(this, adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.recyclerView.setLayoutManager(layoutManager);
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mBinding.recyclerView.setAdapter(adapter);
        adapter.setListener(this);
        mBinding.setViewModel(viewModel);
    }

    @Override
    public void onItemClick(File file) {
        if (file != null) {
            Intent in = new Intent();
            in.putExtra("file", file);
            setResult(100, in);
            finish();
        }
    }
}

