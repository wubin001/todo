package com.nico.todo.ui.mall;

import android.support.annotation.NonNull;

import com.nico.todo.data.source.DataRepository;

/**
 * Created by wubin on 2016/8/8.
 */

public class MallPresenter implements MallContract.Presenter  {

    private DataRepository dataRepository;
    private MallContract.View mallFragment;

    public MallPresenter(@NonNull DataRepository dataRepository, @NonNull MallContract.View mallFragment) {
        this.dataRepository = dataRepository;
        this.mallFragment = mallFragment;
        mallFragment.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void unregister() {

    }
}
