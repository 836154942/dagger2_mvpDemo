package com.spc.spc.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.spc.spc.myapplication.di.component.DaggerFragmentComponent;
import com.spc.spc.myapplication.di.component.FragmentComponent;
import com.spc.spc.myapplication.di.module.FragmentModule;

import javax.inject.Inject;

/**
 * Created by spc on 2017/5/31.
 */

public abstract class BaseMvpFragment<P extends BasePresenter> extends BaseFragment implements BaseMvpViewInterface {
    @Inject
    protected P mvpPresenter;

    protected View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject(DaggerFragmentComponent.builder()
                .appcomponent(MyApplication.getInst().getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build());
        if (mvpPresenter != null)
            mvpPresenter.attachView(this);
    }

    protected abstract void initInject(FragmentComponent fragmentComponent);


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void hideLoading() {
        ((BaseActivity) getActivity()).dismissProgressDialog();
    }

    @Override
    public void showLoading() {
        ((BaseActivity) getActivity()).showProgressDialog();
    }
}

