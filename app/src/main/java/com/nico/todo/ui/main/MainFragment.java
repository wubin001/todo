package com.nico.todo.ui.main;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.nico.todo.R;
import com.nico.todo.ui.apater.ViewPagerAdapter;
import com.nico.todo.ui.base.BaseFragment;

/**
 * Created by wubin on 2016/7/27.
 */
public class MainFragment extends BaseFragment implements MainContract.View {

    private MainContract.Presenter presenter;
    private ViewPager viewPager;

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    protected void initData(View rootView,LayoutInflater inflater) {
        viewPager = (ViewPager)rootView.findViewById(R.id.viewpager);
    }

    @Override
    public void setViewPagerAdapter(ViewPagerAdapter adapter) {
        viewPager.setAdapter(adapter);
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
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
