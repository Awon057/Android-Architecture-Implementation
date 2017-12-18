package com.example.user.employeeattendancearchcomp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Md.Awon-Uz-Zaman on 12/15/2017.
 */

@Entity
public class Entry {
    @PrimaryKey(autoGenerate = true)
    int id;

    @SerializedName("employee_id")
    String employeeId;
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;

    public Entry(String employeeId, String name, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
