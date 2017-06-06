package com.example.injectlib;


/**
 * Created by JokAr on 16/8/6.
 */
public interface Inject<T> {

    void inject(T host, Object object);
}
