package com.managerlee.assessment.view;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;

import com.managerlee.assessment.R;
import com.managerlee.assessment.databinding.ActivityIndexBinding;
import com.managerlee.assessment.framework.base.BaseActivity;
import com.managerlee.assessment.viewModel.IndexViewModel;

/**
 * Created by anins on 2018/3/22.
 */

public class IndexActivity extends BaseActivity {
    private ActivityIndexBinding mBinding;
    private IndexViewModel viewModel;
    private FragmentManager fm;

    @Override
    public void bindLayout() {
        mBinding = DataBindingUtil.setContentView(mAct, R.layout.activity_index);
    }

    @Override
    public void bindData() {
        fm = getSupportFragmentManager();
        viewModel = new IndexViewModel(mAct, fm);
        viewModel.setTagType(2);
        viewModel.selectFragment(1);
        mBinding.setViewModel(viewModel);
    }
}
