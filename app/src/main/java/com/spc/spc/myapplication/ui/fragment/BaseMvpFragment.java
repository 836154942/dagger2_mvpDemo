package com.spc.spc.myapplication.ui.fragment;

/**
 * Created by spc on 2017/6/9.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.spc.spc.myapplication.base.BaseActivity;
import com.spc.spc.myapplication.base.BaseMvpViewInterface;
import com.spc.spc.myapplication.base.BasePresenter;
import com.spc.spc.myapplication.di.aptinject.InjectFragment;

import javax.inject.Inject;

public abstract class BaseMvpFragment<P extends BasePresenter> extends Fragment implements BaseMvpViewInterface {
    @Inject
    protected P mvpPresenter;

    protected View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectFragment.inject(this);
//        initInject(DaggerFragmentComponent.builder()
//                .appcomponent(ArtApplication.getInst().getAppComponent())
//                .fragmentModule(new FragmentModule(this))
//                .build());
        if (mvpPresenter != null)
            mvpPresenter.attachView(this);
    }

//    protected abstract void initInject(FragmentComponent fragmentComponent);


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

