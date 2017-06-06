package com.example.spc.myapplication.mvp.presenter;

import com.example.spc.myapplication.base.BaseMVPActivity;
import com.example.spc.myapplication.base.BasePresenter;
import com.example.spc.myapplication.mvp.view.MainacView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by spc on 2017/5/31.
 */

public class MainPresenter extends BasePresenter<MainacView> {
    @Inject
    public MainPresenter(BaseMVPActivity activity) {
    }


    public void loadData() {
        mCompositeSubscription.add(
                Observable.timer(1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                new Action1<Long>() {
                                    @Override
                                    public void call(Long aLong) {
                                        mvpView.getDataSuccess("加载数据完成");
                                    }
                                })
        );

    }
}
