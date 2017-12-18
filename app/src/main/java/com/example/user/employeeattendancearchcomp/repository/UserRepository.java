package com.example.user.employeeattendancearchcomp.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.user.employeeattendancearchcomp.database.Entry;
import com.example.user.employeeattendancearchcomp.database.UserDao;
import com.example.user.employeeattendancearchcomp.http.ApiClient;
import com.example.user.employeeattendancearchcomp.http.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Md.Awon-Uz-Zaman on 11/24/2017.
 */

public class UserRepository {
    private static ApiInterface api;

    public static LiveData<List<Entry>> getAll() {

        final MutableLiveData<List<Entry>> data = new MutableLiveData<>();
        try {
            api = ApiClient.getApiClient().create(ApiInterface.class);
            Call<List<Entry>> call = api.getUsers();
            call.enqueue(new Callback<List<Entry>>() {
                @Override
                public void onResponse(Call<List<Entry>> call, Response<List<Entry>> response) {
                    if (response.isSuccessful()) {
                        System.out.println(""+response.body());
                        data.postValue(response.body());
                    } else {
                    }
                }

                @Override
                public void onFailure(Call<List<Entry>> call, Throwable t) {
                }
            });
            /*List<Entry> e = new ArrayList<>();
            e.add(new Entry("7008", "Awon", "awon@dadaijdi.dmada"));
            e.add(new Entry("7007", "Pial", "awon@dadaijdi.dmada"));
            data.postValue(e);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
