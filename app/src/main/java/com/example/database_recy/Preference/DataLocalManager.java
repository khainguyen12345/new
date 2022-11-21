package com.example.database_recy.Preference;

import android.content.Context;

import com.example.database_recy.UsersModel;
import com.google.gson.Gson;

public class DataLocalManager {
    public static final String PREF_OBJ_USER = "PREF_OBJ_USER";
    private static  DataLocalManager instance;
    private MySharePreferences mySharePreferences;
    public static void init(Context mContext) {
        instance= new DataLocalManager();
//        instance.mySharePreferences = new MySharePreferences(mContext);
    }
    public static DataLocalManager getInstance() {
        if (instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }
    public static void setUser(UsersModel user, String key) {
        Gson gson = new Gson();
        String strJson = gson.toJson(user);
        DataLocalManager.getInstance().mySharePreferences.putString(key, strJson);
    }
    public static UsersModel getUser() {
        String strJsonUser = DataLocalManager.getInstance().mySharePreferences.getString(PREF_OBJ_USER);
        Gson gson = new Gson();
        UsersModel user = gson.fromJson(strJsonUser , UsersModel.class);
        return user;
    }
}
