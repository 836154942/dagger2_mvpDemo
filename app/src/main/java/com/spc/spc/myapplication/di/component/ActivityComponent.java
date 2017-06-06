package com.spc.spc.myapplication.di.component;


import com.spc.spc.myapplication.di.module.ActivityModule;
import com.spc.spc.myapplication.di.scope.ActivityScope;
import com.spc.spc.myapplication.ui.activity.MainActivity;
import com.spc.spc.myapplication.ui.activity.SecondActivity;

import dagger.Component;

/**
 * Created by spc on 2016/11/9.
 */

@ActivityScope
@Component(dependencies = Appcomponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    MainActivity inject(MainActivity activity);

    SecondActivity inject(SecondActivity activity);
}
