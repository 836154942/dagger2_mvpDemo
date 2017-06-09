package com.spc.spc.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.spc.ActivityInject;
import com.spc.spc.myapplication.R;
import com.spc.spc.myapplication.base.BaseMVPActivity;
import com.spc.spc.myapplication.mvp.presenter.MainPresenter;
import com.spc.spc.myapplication.mvp.view.MainacView;
import com.spc.spc.myapplication.ui.fragment.Test1Fragment;

import butterknife.OnClick;

@ActivityInject//apt注解注入。不需要手写
public class MainActivity extends BaseMVPActivity<MainPresenter> implements MainacView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpPresenter.loadData();
        getSupportFragmentManager().beginTransaction().add(R.id.frame1, new Test1Fragment()).commit();
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
