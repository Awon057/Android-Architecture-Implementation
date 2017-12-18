package com.example.user.employeeattendancearchcomp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;


import java.util.List;

/**
 * Created by Md.Awon-Uz-Zaman on 12/15/2017.
 */
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(List<Entry> users);
}
