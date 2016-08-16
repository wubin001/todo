package com.nico.todo.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nico.todo.data.source.DataSource;

import cn.bmob.v3.BmobUser;

/**
 * Created by wubin on 2016/7/14.
 */
public class LocalDataSource implements DataSource.LocalData {
    private static Context mContext;
    private static class SingletonHolder{
        private static final LocalDataSource INSTANCE = new LocalDataSource();
    }


    public final static LocalDataSource getInstance(@NonNull Context context){
        mContext = context;
        return SingletonHolder.INSTANCE;

    }

    @Override
    public void getCacheUser() {
        BmobUser user = BmobUser.getCurrentUser();
        if(user!=null){

        }
    }
}
