package com.etisalat.sampletask.bases.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.etisalat.sampletask.R;
import com.etisalat.sampletask.bases.BaseActivity;
import com.etisalat.sampletask.bases.BasePresenter;
import com.etisalat.sampletask.bases.ui.Foods.FoodsFragment;
import com.etisalat.sampletask.bases.util.NetworkHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

/**
 * The container responsible for showing and destroying relevant {@link android.support.v4.app.Fragment}
 */

public class MainActivity extends BaseActivity{
    @BindView(R.id.fragmentPlaceHolder)
    FrameLayout fragmentPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentPlaceHolder,
                        FoodsFragment.newInstance())
                .commit();

    }



    @Override
    protected BasePresenter setupPresenter() {
        return null;
    }


}
