/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nico.todo.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.nico.todo.data.source.DataRepository;
import com.nico.todo.data.source.local.LocalDataSource;
import com.nico.todo.data.source.remote.RemoteDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This provides methods to help Activities load their UI.
 */
public class ActivityUtils {

    /**
     * 消息枚举类型定义
     */
    public enum MsgMode{
        BEGIN,SUCCESS,FAILD
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }


    public static DataRepository provideRepository(@NonNull Context context) {
        checkNotNull(context);
        return DataRepository.getInstance(RemoteDataSource.getInstance(),
                LocalDataSource.getInstance(context));
    }

}
