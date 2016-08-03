package com.nico.todo.ui.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nico.todo.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by wubin on 2016/7/27.
 */
public abstract class BaseFragment extends Fragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(),null);
        ButterKnife.inject(this, root);
        initData(inflater);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        startPresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        unRegistPresenter();
    }

    protected abstract void initData(LayoutInflater inflater);

    protected abstract int getLayoutId();

    protected abstract void startPresenter();

    protected abstract void unRegistPresenter();

}
