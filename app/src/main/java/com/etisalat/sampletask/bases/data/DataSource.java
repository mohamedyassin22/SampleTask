package com.etisalat.sampletask.bases.data;

import com.etisalat.sampletask.bases.data.model.Item;
import java.util.List;

/**
 * The interface that exposes fetching  data through helper methods. This is to be
 * implemented by all data sources such as
 * {@link com.etisalat.sampletask.bases.data.remote.RemoteDataSource}
 */

public interface DataSource {

    interface GetMenuCallback{
        void onSuccess(List<Item> menuItems, String date);
        void onFailure(Throwable throwable);

    }
    void getMenuItem(GetMenuCallback getMenuCallback);


}
