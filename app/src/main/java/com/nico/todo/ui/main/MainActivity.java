package com.nico.todo.ui.main;


import com.nico.todo.R;
import com.nico.todo.ui.base.BaseActivity;
import com.nico.todo.util.ActivityUtils;

/**
 * Created by wubin on 2016/7/19.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onResume() {
        super.onResume();
        MainFragment mainFragment =
                (MainFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (mainFragment == null) {
            // Create the fragment
            mainFragment = MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getFragmentManager(), mainFragment, R.id.contentFrame);
        }

        //实例化M层对象
        new MainPresenter(ActivityUtils.provideRepository(getApplicationContext()),mainFragment);
    }
}
