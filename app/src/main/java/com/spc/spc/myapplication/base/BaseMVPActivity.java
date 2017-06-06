package com.spc.spc.myapplication.base;

import android.os.Bundle;

import com.example.injectlib.ActivityInject;
import com.spc.spc.myapplication.di.component.ActivityComponent;

import javax.inject.Inject;

/**
 * Created by spc on 2017/5/31.
 */

public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements BaseMvpViewInterface {

    @Inject
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInject.inject(this);
//        initInject(DaggerActivityComponent.builder()
//                .appcomponent(MyApplication.getInst().getAppComponent())
//                .activityModule(new ActivityModule(this))
//                .build());
        mvpPresenter.attachView(this);

    }

    protected abstract void initInject(ActivityComponent activityComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        dismissProgressDialog();
    }

}

