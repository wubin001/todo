package com.nico.todo.data.source;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wubin on 2016/7/7.
 * 数据仓库  用来处理调用逻辑
 */
public class DataRepository implements DataSource {

    private static DataRepository INSTANCE = null;

    private final DataSource.RemoteData mRemoteDataSource;

    private final DataSource.LocalData mLocalDataSource;

    private DataRepository(@NonNull DataSource.RemoteData tasksRemoteDataSource,
                            @NonNull DataSource.LocalData tasksLocalDataSource) {
        this.mRemoteDataSource = checkNotNull(tasksRemoteDataSource);
        this.mLocalDataSource = checkNotNull(tasksLocalDataSource);
    }

    public static DataRepository getInstance(DataSource.RemoteData tasksRemoteDataSource,
                                             DataSource.LocalData tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DataRepository(tasksRemoteDataSource, tasksLocalDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getCode(String phone) {
        mRemoteDataSource.getCode(phone);
    }

    @Override
    public void loginWithPhoneCode(String phone, String code) {
        mRemoteDataSource.loginWithPhoneCode(phone,code);
    }

    @Override
    public void getCacheUser() {

    }
}
