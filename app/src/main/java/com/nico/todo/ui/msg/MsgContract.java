package com.nico.todo.ui.msg;

import com.nico.todo.base.BasePresenter;
import com.nico.todo.base.BaseView;
import com.nico.todo.ui.mall.MallContract;

import java.util.Observer;

/**
 * Created by wubin on 2016/8/8.
 */

public interface MsgContract {

    interface View extends BaseView<MsgContract.Presenter> {
        
    }

    interface Presenter extends BasePresenter {

    }
}
