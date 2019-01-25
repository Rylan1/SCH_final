package com.example.rylan.scheduler;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.rylan.scheduler.Model.SchData;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }
}
