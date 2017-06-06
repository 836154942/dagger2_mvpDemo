package com.example.injectlib;

import android.content.res.ObbInfo;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by JokAr on 16/8/6.
 */
public class ActivityInject {
    private static final ArrayMap<String, Inject> injectMap = new ArrayMap<>();



    public static void inject(AppCompatActivity host, Object object) {
        String className = host.getClass().getName();
        try {
            Inject inject = injectMap.get(className);

            if (inject == null) {
                Class<?> aClass = Class.forName(className + "$$ActivityInject");
                inject = (Inject) aClass.newInstance();
                injectMap.put(className, inject);
            }
            inject.inject(host, object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
