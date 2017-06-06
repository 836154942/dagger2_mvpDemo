package com.spc.spc.myapplication.mvp.presenter;

import com.spc.spc.myapplication.base.BaseMvpFragment;
import com.spc.spc.myapplication.base.BasePresenter;
import com.spc.spc.myapplication.mvp.view.IndexView;

import javax.inject.Inject;

/**
 * Created by spc on 2017/5/31.
 */

public class IndexPresenter extends BasePresenter<IndexView> {
    @Inject
    public IndexPresenter(BaseMvpFragment fragment) {
    }
}
