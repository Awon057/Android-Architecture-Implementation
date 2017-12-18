package com.example.user.employeeattendancearchcomp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Md.Awon-Uz-Zaman on 12/15/2017.
 */

@Database(entities = {Entry.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public static final Object LOCK = new Object();

    public abstract UserDao userDao();

    public static AppDatabase getInstance(Context context){
        if (instance==null){
            synchronized(LOCK) {
                instance = Room.databaseBuilder(context, AppDatabase.class, "Demo.db").build();
            }
        }
        return instance;
    }
}
