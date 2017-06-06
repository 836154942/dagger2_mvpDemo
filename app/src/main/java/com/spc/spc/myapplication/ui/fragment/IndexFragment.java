package com.spc.spc.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spc.spc.myapplication.base.BaseMvpFragment;
import com.spc.spc.myapplication.di.component.FragmentComponent;
import com.spc.spc.myapplication.mvp.presenter.IndexPresenter;
import com.spc.spc.myapplication.mvp.view.IndexView;

/**
 * Created by spc on 2017/5/31.
 */

public class IndexFragment extends BaseMvpFragment<IndexPresenter> implements IndexView {

    @Override
    protected void initInject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
