package com.nico.todo.data.source;

import java.util.List;

/**
 * Created by wubin on 2016/7/7.
 * 对外的数据接口
 */
public interface DataSource {

    interface LoadDatasCallback<T> {

        void onDatasLoaded(List<T> tasks);

        void onDataNotAvailable();
    }

    interface GetDataCallback<T> {

        void onDataLoaded(T task);

        void onDataNotAvailable();
    }
    //注册
    //登录
    //更新
    //退出
    //密码修改
}
