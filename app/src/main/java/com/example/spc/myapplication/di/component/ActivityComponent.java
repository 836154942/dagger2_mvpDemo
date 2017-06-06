package com.example.spc.myapplication.di.component;


import com.example.spc.myapplication.di.module.ActivityModule;
import com.example.spc.myapplication.di.scope.ActivityScope;
import com.example.spc.myapplication.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by spc on 2016/11/9.
 */

@ActivityScope
@Component(dependencies = Appcomponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    MainActivity inject(MainActivity activity);
}
