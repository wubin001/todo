package com.nico.todo.ui.splash;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.AutoTransition;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nico.todo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by wubin on 2016/7/7.
 */
public class SplashActivity extends Activity {

    @InjectView(R.id.img_title)
    ImageView imageView;
    @InjectView(R.id.base)
    RelativeLayout layout;
    private Scene scene1, scene2;
    private boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);
        Drawable drawable = imageView.getDrawable();
//AnimatedVectorDrawableCompat实现了Animatable接口
        if (drawable instanceof Animatable){
            ((Animatable) drawable).start();
        }

        scene1 = new Scene(layout, layout.findViewById(R.id.contant));
        View layout2 = getLayoutInflater().inflate(R.layout.scene_2,null);
        scene2 = new Scene(layout,layout2);
        Button btn_entry = (Button)layout2.findViewById(R.id.btn_begin);
        Button btn_begin = (Button)layout.findViewById(R.id.btn_begin);
        btn_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Transition transition = new AutoTransition();
//                transition.setDuration(1000);
//                transition.setInterpolator(new AccelerateDecelerateInterpolator());
                TransitionManager.go(scene2);
//                TransitionManager.go(scene2, transition);
//                boolean isVisible = btn_begin.getVisibility() == View.VISIBLE;
            }
        });
        btn_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(scene1);
            }
        });
    }



}
