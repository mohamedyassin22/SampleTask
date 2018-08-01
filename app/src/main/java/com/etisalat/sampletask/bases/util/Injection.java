package com.etisalat.sampletask.bases.util;

import com.etisalat.sampletask.bases.data.DataRepository;
import com.etisalat.sampletask.bases.data.remote.RemoteDataSource;

/**
 * Created by MohamedYassin on 7/22/2018.
 */

public class Injection {
    public static DataRepository provideDataRepository() {
        return DataRepository.getInstance(RemoteDataSource.getInstance(),NetworkHelper.getInstance());
    }

}
