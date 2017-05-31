package com.example.spc.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spc.myapplication.base.BaseMvpFragment;
import com.example.spc.myapplication.di.component.FragmentComponent;
import com.example.spc.myapplication.mvp.presenter.IndexPresenter;
import com.example.spc.myapplication.mvp.view.IndexView;

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
