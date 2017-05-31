package com.example.spc.myapplication.base;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by spc on 2017/5/31.
 */

public abstract class BasePresenter<V extends BaseMvpViewInterface>  {
    protected V mvpView;
    protected CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }


    public void detachView() {
        this.mvpView = null;
        onUnsubscribe();
    }


    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

}
