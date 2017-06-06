package com.example.injectlib;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;

import com.example.injectlib.provider.ActivityProvider;
import com.example.injectlib.provider.Provider;


/**
 * Created by JokAr on 16/8/6.
 */
public class ActivityInject {
    private static final ActivityProvider activityProvider = new ActivityProvider();
    private static final ArrayMap<String, Inject> injectMap = new ArrayMap<>();

    public static void inject(AppCompatActivity activity) {
        inject(activity, activity, activityProvider);
    }


    private static void inject(Object host, Object object, Provider provider) {
        String className = host.getClass().getName();
        try {
            Inject inject = injectMap.get(className);

            if (inject == null) {
                Class<?> aClass = Class.forName(className + "$$ActivityInject");
                inject = (Inject) aClass.newInstance();
                injectMap.put(className, inject);
            }
            inject.inject(host, object, provider);
            inject.inject(host,object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
