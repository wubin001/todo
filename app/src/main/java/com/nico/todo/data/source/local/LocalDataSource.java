package com.nico.todo.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nico.todo.data.source.DataSource;

/**
 * Created by wubin on 2016/7/14.
 */
public class LocalDataSource implements DataSource.LocalData {

    public static LocalDataSource INSTANCE;


    public LocalDataSource(Context context) {

    }

    public static LocalDataSource getInstance(@NonNull Context context){
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(context);
        }
        return INSTANCE;

    }



}
