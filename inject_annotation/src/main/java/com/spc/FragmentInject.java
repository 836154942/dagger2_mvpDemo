package com.spc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by spc on 2017/6/9.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface FragmentInject {
}