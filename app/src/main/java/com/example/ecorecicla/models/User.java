package com.example.ecorecicla.models;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;


import com.example.ecorecicla.helper.FileManager;

public class User extends Application {
    public String email;
    public String password;

    public User() {
        this.email = "";
        this.password = "";
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setDefaultData() {
        this.email      = "";
        this.password   = "";
    }

    public void copyData(User newData) {
        this.email      = newData.email;
        this.password   = newData.password;
    }

    public String objectToJson() {

        String jsonData = new Gson().toJson(this);
        Log.e("msg", "user to jsonData: " + jsonData);
        return jsonData;
    }

}

