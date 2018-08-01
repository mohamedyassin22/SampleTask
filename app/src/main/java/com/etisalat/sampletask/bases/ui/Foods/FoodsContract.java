package com.etisalat.sampletask.bases.ui.Foods;

import android.content.Context;

import com.etisalat.sampletask.bases.BaseControllerListener;
import com.etisalat.sampletask.bases.BasePresenterListener;
import com.etisalat.sampletask.bases.data.model.Item;

import java.util.List;

/**
 * The interface that exposes the functionalities of a Foods View and Presenter
 */

public interface FoodsContract {
    interface View extends BasePresenterListener{
        void showMenuItem(List<Item> foodItem);

    }
    interface Presenter extends BaseControllerListener{
        void getMenuItem(Context context);

    }
}
