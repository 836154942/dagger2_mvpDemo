package com.spc.spc.myapplication.di.module;

import com.spc.spc.myapplication.di.scope.FragmentScope;
import com.spc.spc.myapplication.ui.fragment.BaseMvpFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by spc on 2017/6/9.
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

