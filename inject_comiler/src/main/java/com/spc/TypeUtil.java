package com.spc;


import com.squareup.javapoet.ClassName;

/**
 * Created by spc on 17/6/6.
 */
public class TypeUtil {
    public static final String METHOD_NAME = "inject";//生成类的方法名字
    public static final ClassName ANDROID_VIEW = ClassName.get("android.view", "View");
    public static final ClassName ANDROID_ON_CLICK_LISTENER = ClassName.get("android.view", "View", "OnClickListener");
    public static final ClassName INJET = ClassName.get("com.example.injectlib", "Inject");
    public static final ClassName PROVIDER = ClassName.get("com.example.injectlib.provider", "Provider");
}
