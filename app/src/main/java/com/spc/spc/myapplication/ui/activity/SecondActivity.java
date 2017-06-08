package com.spc.spc.myapplication.ui.activity;


import com.spc.ActivityInject;
import com.spc.spc.myapplication.R;
import com.spc.spc.myapplication.base.BaseMVPActivity;
import com.spc.spc.myapplication.mvp.presenter.SecondPrsenter;
import com.spc.spc.myapplication.mvp.view.SecondView;

/**
 * Created by spc on 2017/6/7.
 */
@ActivityInject
public class SecondActivity extends BaseMVPActivity<SecondPrsenter>  implements SecondView {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_second;
    }
}
