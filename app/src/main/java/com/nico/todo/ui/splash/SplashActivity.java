package com.nico.todo.ui.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.nico.todo.R;
import com.nico.todo.ui.base.BaseActivity;
import com.nico.todo.ui.main.MainActivity;

/**
 * Created by wubin on 2016/8/16.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //判断是否有缓存登录信息，有则进入到Main，无则进入登录

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        }, 3000);
    }
}
