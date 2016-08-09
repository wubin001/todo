package com.nico.todo.ui.main;

import com.nico.todo.base.BasePresenter;
import com.nico.todo.base.BaseView;
import com.nico.todo.ui.apater.ViewPagerAdapter;
import com.nico.todo.ui.login.LoginContract;

/**
 * Created by wubin on 2016/7/27.
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {
        void setViewPagerAdapter(ViewPagerAdapter adapter);
    }


    interface Presenter extends BasePresenter{

    }




}
