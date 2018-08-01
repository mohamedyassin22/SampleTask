package com.etisalat.sampletask.bases.ui.Foods;

import android.content.Context;

import com.etisalat.sampletask.R;
import com.etisalat.sampletask.bases.data.DataRepository;
import com.etisalat.sampletask.bases.data.DataSource;
import com.etisalat.sampletask.bases.data.model.Item;

import java.util.List;


/**
 * The Presenter that fetches  data by calling {@link DataRepository} at the request of
 * its View "{@link FoodsContract.View}", and then delivers the data back to
 * its View.
 * The presenter also calls other relevant methods of its View such as for
 * showing/hiding progress Dialog and for showing Snakbar

 */

public class FoodsPresenter  implements FoodsContract.Presenter {
    private DataRepository dataRepository;
    private FoodsContract.View view;
    public FoodsPresenter(FoodsContract.View view,DataRepository dataRepository){
        this.dataRepository=dataRepository;
        this.view=view;
    }


    @Override
    public void getMenuItem(final Context context) {
        if (view == null) {
            return;
        }
        view.showProgress();
        dataRepository.getMenuItem(context, new DataSource.GetMenuCallback() {
            @Override
            public void onSuccess(List<Item> menuItems, String date) {
                if(view!=null){
                    view.showMenuItem(menuItems, date);
                    view.hideProgress();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                if (view!= null){
                    view.hideProgress();
                    view.showSnackbar(context.getString(R.string.network_failure_msg));
                }

            }


        });

    }
}
