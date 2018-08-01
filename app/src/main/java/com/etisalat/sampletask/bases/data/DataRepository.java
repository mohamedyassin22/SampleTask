package com.etisalat.sampletask.bases.data;

import android.content.Context;



import com.etisalat.sampletask.bases.util.NetworkHelper;

/**
 * Created by MohamedYassin on 7/21/2018.
 */

public class DataRepository {
    private DataSource remoteDataSource;
    private NetworkHelper networkHelper;
    private static DataRepository dataRepository;

    public DataRepository(DataSource remoteDataSource,NetworkHelper networkHelper) {
        this.remoteDataSource = remoteDataSource;
        this.networkHelper=networkHelper;
    }
    public static synchronized DataRepository getInstance(DataSource remoteDataSource,NetworkHelper networkHelper) {
        if (dataRepository == null) {
            dataRepository = new DataRepository(remoteDataSource,networkHelper);
        }
        return dataRepository;
    }
    public void getMenuItem(Context context,
                            final DataSource.GetMenuCallback getMenuCallback){
            remoteDataSource.getMenuItem(getMenuCallback);
    }
}
