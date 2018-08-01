package com.etisalat.sampletask.bases.data.remote;

import com.etisalat.sampletask.bases.data.DataSource;
import com.etisalat.sampletask.bases.data.model.Menu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The class for fetching data on a background thread and returning data via
 * callbacks on the main UI thread
 */

public class RemoteDataSource implements DataSource {
    private static RemoteDataSource remoteDataSource;
    private RemoteDataSource() {

    }

    public static synchronized RemoteDataSource getInstance() {
        if (remoteDataSource == null) {

            remoteDataSource = new RemoteDataSource();
        }
        return remoteDataSource;
    }

    @Override
    public void getMenuItem(final GetMenuCallback getMenuCallback) {

        Call<Menu>call =ApiClient.getClient().create(ApiService.class).getMenuItem();
        call.enqueue(new Callback<Menu>() {
            @Override
            public void onResponse(Call<Menu> call, Response<Menu> response) {
                if (response.isSuccessful()){
                    DateFormat df = new SimpleDateFormat("dd MM yyyy, HH:mm", Locale.ENGLISH);

                    Menu menu=response.body();
                    getMenuCallback.onSuccess(menu.getFoodItem(),  df.format(response.headers().getDate("Date")));
                }
                else {
                    getMenuCallback.onFailure(new Throwable());

                }
            }

            @Override
            public void onFailure(Call<Menu> call, Throwable t) {
                getMenuCallback.onFailure(t);

            }
        });
    }
}
