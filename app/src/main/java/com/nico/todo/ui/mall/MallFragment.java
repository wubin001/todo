package com.nico.todo.ui.mall;

import android.view.LayoutInflater;
import android.view.View;

import com.nico.todo.R;
import com.nico.todo.ui.base.BaseFragment;

/**
 * Created by wubin on 2016/8/8.
 */

public class MallFragment extends BaseFragment implements MallContract.View {

    @Override
    public void setPresenter(MallContract.Presenter presenter) {

    }

    @Override
    protected void initData(View rootView, LayoutInflater inflater) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fm_main;
    }

    @Override
    protected void startPresenter() {

    }

    @Override
    protected void unRegistPresenter() {

    }
}
