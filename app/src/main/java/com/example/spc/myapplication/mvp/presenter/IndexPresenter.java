package com.example.spc.myapplication.mvp.presenter;

import com.example.spc.myapplication.base.BaseMvpFragment;
import com.example.spc.myapplication.base.BasePresenter;
import com.example.spc.myapplication.mvp.view.IndexView;

import javax.inject.Inject;

/**
 * Created by spc on 2017/5/31.
 */

public class IndexPresenter extends BasePresenter<IndexView> {
    @Inject
    public IndexPresenter(BaseMvpFragment fragment) {
    }
}
