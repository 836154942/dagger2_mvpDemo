package com.spc.spc.myapplication.base;

import android.os.Bundle;

import com.spc.spc.myapplication.di.aptinject.InjectActivity;

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
        InjectActivity.inject(this);
        mvpPresenter.attachView(this);

    }

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

