package com.nico.todo.ui.login;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nico.todo.R;
import com.nico.todo.ui.base.BaseFragment;
import com.nico.todo.util.ActivityUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wubin on 2016/7/6.
 */
public class LoginFragment extends BaseFragment implements LoginContract.View{

    @InjectView(R.id.img_title)
    ImageView imageView;
    @InjectView(R.id.base)
    RelativeLayout layout;

    private Scene scene2;
    private LoginContract.Presenter mPresenter;
    private CountDownTimer mCodecountDownTimer;
    private ViewHolder viewHolder;


    public static LoginFragment newInstance(){
        return new LoginFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fm_login;
    }


    @Override
    protected void startPresenter() {
        mPresenter.start();
    }

    @Override
    protected void unRegistPresenter() {
        mPresenter.unregister();
    }

    protected void initData(LayoutInflater inflater){
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable){
            ((Animatable) drawable).start();
        }

        View layout2 = inflater.inflate(R.layout.scene_login_2,null);

        scene2 = new Scene(layout,layout2);
        viewHolder = new ViewHolder(layout2);
    }

    @OnClick(R.id.btn_begin)
    public void onclick_jump(){
        TransitionManager.go(scene2);
    }



    @Override
    public void callBackWithLoginState(@NonNull ActivityUtils.MsgMode msgMode) {
        switch (msgMode){
            case BEGIN:
                //显示等待框
                showProgressDialog();
                break;
            case SUCCESS:
                //跳转到主页面
                startActivity();
                break;
        }
    }


    @Override
    public void showProgressDialog() {
        viewHolder.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismisProgressDialog() {
        if(mCodecountDownTimer!=null){
            mCodecountDownTimer.cancel();
            mCodecountDownTimer = null;
        }
        viewHolder.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
    }

    private void startActivity(){
        dismisProgressDialog();

    }


    private void startCountDown(){
        viewHolder.tv_recode.setEnabled(false);
        if(mCodecountDownTimer==null){
            mCodecountDownTimer = new CountDownTimer(1000 * 60, 1000){
                @Override
                public void onTick(long millisUntilFinished) {
                    viewHolder.tv_recode.setText("剩余" + millisUntilFinished / 1000 + "s");
                }

                @Override
                public void onFinish() {
                    viewHolder.tv_recode.setText("重新获取");
                    viewHolder.tv_recode.setEnabled(true);
                }
            };
        }

        mCodecountDownTimer.start();

    }


    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        this.mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        mPresenter.unregister();
    }

    class ViewHolder{
        @InjectView(R.id.img_title) ImageView img_title;
        @InjectView(R.id.edit_phone) EditText et_phone;
        @InjectView(R.id.edit_code) EditText et_code;
        @InjectView(R.id.btn_begin) Button btn_begin;
        @InjectView(R.id.progress_bar) ProgressBar progressBar;
        @InjectView(R.id.tv_recode) TextView tv_recode;

        public ViewHolder(View view){
            ButterKnife.inject(this,view);
        }

        @OnClick(R.id.btn_begin)
        public void onclick_login(){
            //点击登陆
            Log.e("TEst",et_phone.getText().toString().trim()+"=="+et_code.getText().toString().trim());
            String phone = viewHolder.et_phone.getText().toString().trim();
            String code = viewHolder.et_code.getText().toString().trim();
            mPresenter.LoginWithPhoneCode(phone,code);
        }

        @OnClick(R.id.tv_recode)
        public void onclick_getCode(){
            startCountDown();
            mPresenter.getCode(viewHolder.et_phone.getText().toString().trim());
        }
    }
}
