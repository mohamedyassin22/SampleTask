package com.etisalat.sampletask.bases.data.remote;

import com.etisalat.sampletask.bases.data.model.Menu;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MohamedYassin on 7/21/2018.
 */

public interface ApiService {
    @GET("pizza/?format=xml")
    Call<Menu> getMenuItem();
}
