package com.nico.todo.data.source.remote;

import android.content.Context;

import com.nico.todo.data.source.DataSource;

/**
 * Created by wubin on 2016/7/14.
 */
public class RemoteDataSource implements DataSource {

    public static RemoteDataSource INSTANCE;

    public RemoteDataSource(){

    };

    public static RemoteDataSource getInstance(){
        if(INSTANCE == null){
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }



}
