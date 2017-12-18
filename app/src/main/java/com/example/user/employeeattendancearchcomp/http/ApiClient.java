package com.example.user.employeeattendancearchcomp.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Md.Awon-Uz-Zaman on 11/24/2017.
 */

public class ApiClient {
    public static String Base_URL = "http://demo8544954.mockable.io/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit =new Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
