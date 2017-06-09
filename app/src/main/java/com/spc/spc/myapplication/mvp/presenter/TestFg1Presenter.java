package com.spc.spc.myapplication.mvp.presenter;

import com.spc.spc.myapplication.base.BasePresenter;
import com.spc.spc.myapplication.mvp.view.TestFg1View;
import com.spc.spc.myapplication.base.BaseMvpFragment;

import javax.inject.Inject;

/**
 * Created by spc on 2017/6/9.
 */

public class TestFg1Presenter extends BasePresenter<TestFg1View> {

    @Inject
    public TestFg1Presenter(BaseMvpFragment fragment) {
    }
}
