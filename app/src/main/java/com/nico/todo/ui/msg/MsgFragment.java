package com.nico.todo.ui.msg;

import android.view.LayoutInflater;
import android.view.View;

import com.nico.todo.R;
import com.nico.todo.ui.base.BaseFragment;

/**
 * Created by wubin on 2016/8/8.
 */

public class MsgFragment extends BaseFragment implements MsgContract.View{
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

    @Override
    public void setPresenter(MsgContract.Presenter presenter) {

    }
}
