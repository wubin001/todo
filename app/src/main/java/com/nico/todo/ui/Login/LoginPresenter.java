package com.nico.todo.ui.login;

import android.support.annotation.NonNull;
import android.util.Log;

import com.nico.todo.data.source.DataRepository;
import com.nico.todo.util.ActivityUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.bmob.v3.BmobUser;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wubin on 2016/7/6.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private final DataRepository dataRepository;
    private final LoginContract.View fragment;

    public LoginPresenter(@NonNull DataRepository dataRepository,@NonNull LoginContract.View fragmentView) {
        this.dataRepository = checkNotNull(dataRepository,"DataRepository cannot be null");
        fragment = checkNotNull(fragmentView,"LoginContract.View cannot be null");
        fragment.setPresenter(this);

    }

    @Override
    public void start() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void unregister() {
        EventBus.getDefault().unregister(this);
    }

    //订阅获取验证码事件
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void callBackWithGetCode(Integer smsId)
    {
        Log.e("COde",String.valueOf(smsId)) ;
    }

    //订阅登录事件
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void callBackWithLogin(@NonNull BmobUser user)
    {
        //等待框消失
        fragment.dismisProgressDialog();
        //登录成功
        fragment.callBackWithLoginState(ActivityUtils.MsgMode.SUCCESS);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void callBackError(@NonNull String errorMsg){
        fragment.showToast(errorMsg);
    }


    @Override
    public void getCode(@NonNull String phone) {
        //基础校验手机号码
        Log.e("smile","获取验证码"+phone);
        String msg = checkTel(phone);
        if(msg!=null&&msg.length()>1){
            fragment.showToast(msg);
        }else{
            //访问数据
            dataRepository.getCode(phone);
        }

    }

    @Override
    public void LoginWithPhoneCode(@NonNull String phone,@NonNull String code) {
        //等待框显示
        fragment.showProgressDialog();
        dataRepository.loginWithPhoneCode(phone,code);
    }

    private String checkTel(String phone){
        String rtMsg = "";
        if (phone==null||phone.isEmpty()){
            rtMsg="请输入手机号码";
            return rtMsg;
        }
        Pattern pattern = Pattern.compile("^[1][34578]\\d{9}$");
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.matches()){
            rtMsg = "请输入正确格式的手机号码";
        }
        return rtMsg;
    }
}
