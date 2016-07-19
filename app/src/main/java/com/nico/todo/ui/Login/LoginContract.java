package com.nico.todo.ui.login;

import com.nico.todo.base.BasePresenter;
import com.nico.todo.base.BaseView;
import com.nico.todo.util.ActivityUtils;

/**
 * Created by wubin on 2016/7/6.
 */
public interface LoginContract {

    interface View extends BaseView<Presenter>{

        //登录状态返回
        void callBackWithLoginState(ActivityUtils.MsgMode msgMode);

        void showProgressDialog();

        void dismisProgressDialog();

        void showToast(String msg);

    }

    interface Presenter extends BasePresenter{
        void getCode(String phone);
        void LoginWithPhoneCode(String phone,String code);
    }
}
