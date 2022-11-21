package com.example.database_recy.Preference;

import android.app.Application;

public class MyApplycation extends Application {
@Override
    public void onCreate() {
    super.onCreate();
    DataLocalManager.init(getApplicationContext());
}
}
