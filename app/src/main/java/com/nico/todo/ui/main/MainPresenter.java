package com.nico.todo.ui.main;

import android.support.annotation.NonNull;

import com.nico.todo.data.source.DataRepository;
import com.nico.todo.ui.apater.ViewPagerAdapter;
import com.nico.todo.ui.mall.MallFragment;
import com.nico.todo.ui.mall.MallPresenter;
import com.nico.todo.ui.mine.MineFragment;
import com.nico.todo.ui.mine.MinePresenter;
import com.nico.todo.ui.msg.MsgFragment;
import com.nico.todo.ui.msg.MsgPresenter;
import com.nico.todo.util.ActivityUtils;

import org.greenrobot.eventbus.EventBus;

import static cn.bmob.v3.Bmob.getApplicationContext;

/**
 * Created by wubin on 2016/7/27.
 */
public class MainPresenter implements MainContract.Presenter {

    private DataRepository dataRepository;
    private MainContract.View mainFragment;
    private ViewPagerAdapter adapter;

    public MainPresenter(@NonNull DataRepository dataRepository,@NonNull MainContract.View mainFragment){
        this.dataRepository = dataRepository;
        this.mainFragment = mainFragment;
        mainFragment.setPresenter(this);
    }

    private ViewPagerAdapter getViewPagerAdapter(){
        adapter = new ViewPagerAdapter(((MainFragment)mainFragment).getFragmentManager());
        iniFragment();
        return adapter;
    }

    private void iniFragment(){
        //添加买卖，消息，我的 对应的fragment
        MallFragment mallFragment = new MallFragment();
        new MallPresenter(dataRepository,mallFragment);
        MsgFragment msgFragment = new MsgFragment();
        new MsgPresenter(dataRepository,msgFragment);
        MineFragment mineFragment = new MineFragment();
        new MinePresenter(dataRepository,mineFragment);
        adapter.addFragment(mallFragment);
        adapter.addFragment(msgFragment);
        adapter.addFragment(mineFragment);
    }


    @Override
    public void start() {
        EventBus.getDefault().register(this);
        mainFragment.setViewPagerAdapter(getViewPagerAdapter());
    }

    @Override
    public void unregister() {
        EventBus.getDefault().unregister(this);
    }


}
