package com.spc.spc.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by spc on 2017/5/31.
 */
public class BaseFragment extends Fragment {

    protected CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeSubscription.unsubscribe();
    }
}
