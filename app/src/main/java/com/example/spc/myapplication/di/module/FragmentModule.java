package com.example.spc.myapplication.di.module;


import com.example.spc.myapplication.base.BaseMvpFragment;
import com.example.spc.myapplication.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by spc on 2016/11/9.
 */
@Module
public class FragmentModule {
    private BaseMvpFragment fragment;

    public FragmentModule(BaseMvpFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public BaseMvpFragment provideBaseMvpFragment() {
        return fragment;
    }

}
