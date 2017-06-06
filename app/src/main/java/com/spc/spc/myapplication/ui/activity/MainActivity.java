package com.spc.spc.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.spc.InjectActivity;
import com.spc.OnClick2;
import com.spc.spc.myapplication.R;
import com.spc.spc.myapplication.base.BaseMVPActivity;
import com.spc.spc.myapplication.di.component.ActivityComponent;
import com.spc.spc.myapplication.mvp.presenter.MainPresenter;
import com.spc.spc.myapplication.mvp.view.MainacView;

import butterknife.OnClick;

@InjectActivity
public class MainActivity extends BaseMVPActivity<MainPresenter> implements MainacView {

    @OnClick2(R.id.txt)
    public void textonclick() {
        Toast.makeText(this, "test撒发射点发射点发生", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpPresenter.loadData();

    }

    @Override
    protected void initInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
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
