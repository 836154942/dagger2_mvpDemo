package com.example.spc.myapplication.ui.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.example.spc.myapplication.base.BaseMVPActivity;
import com.example.spc.myapplication.di.component.ActivityComponent;
import com.example.spc.myapplication.mvp.presenter.MainPresenter;
import com.example.spc.myapplication.mvp.view.MainacView;
import com.spc.spc.myapplication.R;

public class MainActivity extends BaseMVPActivity<MainPresenter> implements MainacView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpPresenter.loadData();
    }

    @Override
    protected void initInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
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
