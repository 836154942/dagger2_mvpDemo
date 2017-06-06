package com.spc.spc.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.spc.ActivityInject;
import com.spc.spc.myapplication.R;
import com.spc.spc.myapplication.base.BaseMVPActivity;
import com.spc.spc.myapplication.mvp.presenter.MainPresenter;
import com.spc.spc.myapplication.mvp.view.MainacView;

import butterknife.OnClick;


public class MainActivity extends BaseMVPActivity<MainPresenter> implements MainacView {

    @ActivityInject//apt注解注入。不需要手写
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpPresenter.loadData();

    }

    @OnClick(R.id.btn1)
    public void onClick() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void getDataSuccess(String res) {
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
    }
}
