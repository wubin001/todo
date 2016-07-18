package com.nico.todo;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by wubin on 2016/7/18.
 */
public class TDApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //替换自己的ID
        Bmob.initialize(this, "a58211070010c438c1effd8958687a75");
    }
}
