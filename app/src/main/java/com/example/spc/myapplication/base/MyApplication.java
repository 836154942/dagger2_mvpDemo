package com.example.spc.myapplication.base;

import android.app.Application;

import com.example.spc.myapplication.di.component.Appcomponent;
import com.example.spc.myapplication.di.component.DaggerAppcomponent;
import com.example.spc.myapplication.di.module.AppModule;

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
    Appcomponent getAppComponent() {
        return mAppcomponent;
    }
}
