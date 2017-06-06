package com.spc.spc.myapplication.ui.activity;

import android.os.Bundle;

import com.spc.ActivityInject;
import com.spc.spc.myapplication.R;
import com.spc.spc.myapplication.base.BaseMVPActivity;
import com.spc.spc.myapplication.mvp.view.SecondAcView;
import com.spc.spc.myapplication.ui.fragment.SecondAcPresenter;

import butterknife.OnClick;

/**
 * Created by spc on 2017/6/6.
 */


public class SecondActivity extends BaseMVPActivity<SecondAcPresenter> implements SecondAcView {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    @ActivityInject//apt注解注入。不需要手写
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.button)
    public void textonclick() {
        finish();
    }

}
