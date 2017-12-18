package com.example.user.employeeattendancearchcomp.http;

import com.example.user.employeeattendancearchcomp.database.Entry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Md.Awon-Uz-Zaman on 11/24/2017.
 */

public interface ApiInterface {
    @GET("users")
    Call<List<Entry>> getUsers();
}
