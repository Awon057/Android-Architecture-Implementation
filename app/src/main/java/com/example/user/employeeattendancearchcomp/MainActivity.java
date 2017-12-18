package com.example.user.employeeattendancearchcomp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.user.employeeattendancearchcomp.adapter.UserListAdapter;
import com.example.user.employeeattendancearchcomp.database.AppDatabase;
import com.example.user.employeeattendancearchcomp.database.Entry;
import com.example.user.employeeattendancearchcomp.database.UserDao;
import com.example.user.employeeattendancearchcomp.http.ApiClient;
import com.example.user.employeeattendancearchcomp.http.ApiInterface;
import com.example.user.employeeattendancearchcomp.repository.UserRepository;
import com.example.user.employeeattendancearchcomp.viewmodel.UserViewModel;
import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private UserListAdapter adapter;
    private List<Entry> users;
    private UserViewModel viewModel;
    private UserDao userDao;
    AppDatabase instance;

    ApiInterface api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.userlist_recycler_view);

        Stetho.initializeWithDefaults(this);

        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new UserListAdapter();
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        viewModel.setUsers();
        mRecyclerView.setAdapter(adapter);

        instance = AppDatabase.getInstance(MainActivity.this);

        adapter.setUsers(users);
        viewModel.getUsers().observe(this, new Observer<List<Entry>>() {
            @Override
            public void onChanged(@Nullable List<Entry> users) {
                adapter.setUsers(users);
                final List<Entry> data = users;
                for(Entry e:data){
                    System.out.println(e.getEmployeeId());
                }
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        instance.userDao().insertUsers(data);
                    }
                };
                new Thread(runnable).start();
            }
        });
    }
}
