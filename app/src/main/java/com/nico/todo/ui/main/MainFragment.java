package com.nico.todo.ui.main;

import android.view.LayoutInflater;

import com.nico.todo.R;
import com.nico.todo.ui.base.BaseFragment;
import com.nico.todo.ui.login.LoginContract;
import com.nico.todo.ui.login.LoginFragment;
import com.nico.todo.util.ActivityUtils;

/**
 * Created by wubin on 2016/7/27.
 */
public class MainFragment extends BaseFragment implements LoginContract.View {

    private LoginContract.Presenter presenter;

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    protected void initData(LayoutInflater inflater) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fm_main;
    }

    @Override
    protected void startPresenter() {
        presenter.start();
    }

    @Override
    protected void unRegistPresenter() {
        presenter.unregister();
    }

    @Override
    public void callBackWithLoginState(ActivityUtils.MsgMode msgMode) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismisProgressDialog() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
