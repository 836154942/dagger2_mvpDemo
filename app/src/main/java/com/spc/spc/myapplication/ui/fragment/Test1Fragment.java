package com.spc.spc.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spc.FragmentInject;
import com.spc.spc.myapplication.R;
import com.spc.spc.myapplication.mvp.presenter.TestFg1Presenter;
import com.spc.spc.myapplication.mvp.view.TestFg1View;

/**
 * Created by spc on 2017/6/9.
 */
@FragmentInject
public class Test1Fragment extends BaseMvpFragment<TestFg1Presenter> implements TestFg1View {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test1, null);
    }
}
