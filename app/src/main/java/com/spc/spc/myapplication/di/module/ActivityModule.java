package com.spc.spc.myapplication.di.module;


import com.spc.spc.myapplication.base.BaseMVPActivity;
import com.spc.spc.myapplication.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by spc on 2016/11/9.
 */
@Module
public class ActivityModule {
    BaseMVPActivity activity;

    public ActivityModule(BaseMVPActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public BaseMVPActivity provideBindMobActivity() {
        return activity;
    }

}
