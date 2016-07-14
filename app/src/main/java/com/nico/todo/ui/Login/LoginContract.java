package com.nico.todo.ui.login;

import com.nico.todo.base.BasePresenter;
import com.nico.todo.base.BaseView;
import com.nico.todo.util.ActivityUtils;

/**
 * Created by wubin on 2016/7/6.
 */
public interface LoginContract {

    interface View extends BaseView<Presenter>{

        //获取验证码状态返回
        void callBackWithGetCode(ActivityUtils.MsgMode msgMode,String msg);
        //登录状态返回
        void callBackWithLoginState(ActivityUtils.MsgMode msgMode,String msg);

        void showProgressDialog();

        void dismisProgressDialog();

        void showToast(String msg);

    }

    interface Presenter extends BasePresenter{

    }
}
