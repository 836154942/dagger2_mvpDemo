package com.spc.spc.myapplication.mvp.presenter;

import com.spc.spc.myapplication.base.BaseMVPActivity;
import com.spc.spc.myapplication.base.BasePresenter;
import com.spc.spc.myapplication.mvp.view.SecondView;

import javax.inject.Inject;

/**
 * Created by spc on 2017/6/7.
 */

public class SecondPrsenter extends BasePresenter<SecondView> {
    @Inject
    public SecondPrsenter(BaseMVPActivity activity) {
    }
}
