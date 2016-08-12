package com.nico.todo.data.source;

import java.util.List;

/**
 * Created by wubin on 2016/7/7.
 * 对外的数据接口
 */
public interface DataSource {

    //回调接口暂时用eventbus代替
//    interface LoadDatasCallback<T> {
//
//        void onDatasLoaded(List<T> tasks);
//
//        void onDataNotAvailable();
//    }
//
//    interface GetDataCallback<T> {
//
//        void onDataLoaded(T task);
//
//        void onDataNotAvailable();
//    }


    interface LocalData{
        void getCacheUser();
    }

    interface RemoteData{
        /**
         * 获取验证码
         * @param phone
         */
        void getCode(String phone);

        /**
         * 手机号码一键注册和登录
         * @param phone
         * @param code
         */
        void loginWithPhoneCode(String phone,String code);
    }

    void getCacheUser();

    /**
     * 获取验证码
     * @param phone
     */
    void getCode(String phone);

    /**
     * 手机号码一键注册和登录
     * @param phone
     * @param code
     */
    void loginWithPhoneCode(String phone,String code);
    //更新
    //退出
    //密码修改
}
