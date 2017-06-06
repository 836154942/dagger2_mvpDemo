package com.spc.spc.myapplication.ui.activity;

import com.spc.spc.myapplication.R;
import com.spc.spc.myapplication.base.BaseMVPActivity;
import com.spc.spc.myapplication.di.component.ActivityComponent;
import com.spc.spc.myapplication.mvp.view.SecondAcView;
import com.spc.spc.myapplication.ui.fragment.SecondAcPresenter;

/**
 * Created by spc on 2017/6/6.
 */

public class SecondActivity extends BaseMVPActivity<SecondAcPresenter> implements SecondAcView {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void initInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
