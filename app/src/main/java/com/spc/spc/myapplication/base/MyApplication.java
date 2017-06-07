package com.spc.spc.myapplication.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.spc.spc.myapplication.di.component.Appcomponent;
import com.spc.spc.myapplication.di.component.DaggerAppcomponent;
import com.spc.spc.myapplication.di.module.AppModule;

/**
 * Created by spc on 2017/5/31.
 */

public class MyApplication extends Application {
    private static MyApplication mInst;
    private Appcomponent mAppcomponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInst = this;
        mAppcomponent = DaggerAppcomponent.
                builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static MyApplication getInst() {
        return mInst;
    }

    public Appcomponent getAppComponent() {
        return mAppcomponent;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
