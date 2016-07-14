package com.nico.todo.ui.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Fragment;
import android.app.ListFragment;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.nico.todo.R;
import com.nico.todo.util.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wubin on 2016/7/6.
 */
public class LoginFragment extends Fragment implements LoginContract.View{

    @InjectView(R.id.img_title)
    ImageView imageView;
    @InjectView(R.id.base)
    RelativeLayout layout;
    private Scene scene1, scene2;
    private LoginContract.Presenter mPresenter;


    public LoginFragment(){

    }

    public static LoginFragment newInstance(){
        return new LoginFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fm_login,null);
        ButterKnife.inject(this, root);
        initData(inflater);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    private void initData(LayoutInflater inflater){
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable){
            ((Animatable) drawable).start();
        }
        View layout2 = inflater.inflate(R.layout.scene_login_2,null);
        scene1 = new Scene(layout, layout.findViewById(R.id.contant));
        scene2 = new Scene(layout,layout2);
        Button btn_entry = (Button)layout2.findViewById(R.id.btn_begin);
        Button btn_begin = (Button)layout.findViewById(R.id.btn_begin);
        btn_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(scene2);
            }
        });
    }

    @Override
    public void callBackWithGetCode(@NonNull ActivityUtils.MsgMode msgMode,@NonNull String msg) {

    }

    @Override
    public void callBackWithLoginState(@NonNull ActivityUtils.MsgMode msgMode,@NonNull String msg) {
        switch (msgMode){
            case BEGIN:
                //显示等待框
                showProgressDialog();
                break;
            case SUCCESS:
                //跳转到主页面
                startActivity();
                break;
            case FAILD:
                //提示错误信息
                checkNotNull(msg);
                showToast(msg);
                break;
        }
    }


    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismisProgressDialog() {

    }

    @Override
    public void showToast(String msg) {

    }

    private void startActivity(){
        dismisProgressDialog();

    }

    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        this.mPresenter = checkNotNull(presenter);
    }
}
