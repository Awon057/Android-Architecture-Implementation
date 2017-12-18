package com.example.user.employeeattendancearchcomp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.user.employeeattendancearchcomp.database.Entry;
import com.example.user.employeeattendancearchcomp.repository.UserRepository;

import java.util.List;

/**
 * Created by Md.Awon-Uz-Zaman on 11/24/2017.
 */

public class UserViewModel extends ViewModel {
    public LiveData<List<Entry>> users;
    public UserRepository userRepository;

    public void setUsers() {
        users = UserRepository.getAll();
    }

    public LiveData<List<Entry>> getUsers() {
        return users;
    }
}
