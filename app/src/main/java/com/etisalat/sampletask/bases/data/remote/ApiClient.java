package com.etisalat.sampletask.bases.data.remote;

import android.content.Context;

import com.etisalat.sampletask.bases.util.App;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by MohamedYassin on 7/21/2018.
 */

public class ApiClient {
    public static final String BASE_URL = "https://api.androidhive.info/";
    private static Retrofit sRetrofit = null;




    public static Retrofit getClient() {
        if (sRetrofit == null) {
            synchronized (Retrofit.class) {
                if (sRetrofit == null) {



                    sRetrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)

                            .addConverterFactory(SimpleXmlConverterFactory.create())
                            .build();

                }
            }
        }
        return sRetrofit;
    }
}
