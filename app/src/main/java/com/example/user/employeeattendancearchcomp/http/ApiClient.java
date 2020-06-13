package com.example.user.employeeattendancearchcomp.http;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Md.Awon-Uz-Zaman on 11/24/2017.
 */

public class ApiClient {
    public static String Base_URL = "http://demo3056322.mockable.io/";
    public static Retrofit retrofit = null;
    static OkHttpClient okHttpClient;

    public static Retrofit getApiClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
        if (retrofit == null) {
            retrofit =new Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
