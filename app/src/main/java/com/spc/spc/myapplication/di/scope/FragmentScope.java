package com.spc.spc.myapplication.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by spc on 2016/11/9.
 */

@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
