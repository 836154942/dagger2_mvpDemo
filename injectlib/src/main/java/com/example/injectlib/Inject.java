package com.example.injectlib;


import com.example.injectlib.provider.Provider;

/**
 * Created by JokAr on 16/8/6.
 */
public interface Inject<T> {

    void inject(T host, Object object, Provider provider);
    void inject(T host, Object object);
}
