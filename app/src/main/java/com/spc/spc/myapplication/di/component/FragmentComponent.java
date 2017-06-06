package com.spc.spc.myapplication.di.component;


import com.spc.spc.myapplication.di.module.FragmentModule;
import com.spc.spc.myapplication.di.scope.FragmentScope;
import com.spc.spc.myapplication.ui.fragment.IndexFragment;

import dagger.Component;

/**
 * Created by spc on 2016/11/9.
 */
@FragmentScope
@Component(dependencies = Appcomponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(IndexFragment fragment);
}
