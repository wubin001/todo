package com.nico.todo.data.source.remote;

import android.util.Log;

import com.nico.todo.data.source.DataSource;

import org.greenrobot.eventbus.EventBus;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;

/**
 * Created by wubin on 2016/7/14.
 */
public class RemoteDataSource implements DataSource.RemoteData {

    public static RemoteDataSource INSTANCE;

    public RemoteDataSource(){

    };

    public static RemoteDataSource getInstance(){
        if(INSTANCE == null){
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getCode(String phone) {
        BmobSMS.requestSMSCode(phone,"todosms", new QueryListener<Integer>() {

            @Override
            public void done(Integer smsId,BmobException ex) {
                if(ex==null){//验证码发送成功
                    Log.e("smile","获取验证码成功");
                    EventBus.getDefault().post(smsId);
                }
            }
        });
    }

    @Override
    public void loginWithPhoneCode(String phone, String code) {
        BmobUser.loginBySMSCode(phone, code, new LogInListener<BmobUser>() {

            @Override
            public void done(BmobUser user, BmobException e) {
                if(user!=null){
                    Log.e("smile","用户登陆成功");
                    EventBus.getDefault().post(user);
                }else{
                    Log.e("smile","用户登陆失败"+e);
                }
            }
        });
    }
}
