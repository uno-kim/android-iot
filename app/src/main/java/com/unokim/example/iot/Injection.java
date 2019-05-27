package com.unokim.example.iot;

import android.content.Context;

import com.unokim.example.iot.data.source.Repository;
import com.unokim.example.iot.data.source.local.LocalDataSource;
import com.unokim.example.iot.data.source.local.LocalDatabase;

import androidx.annotation.NonNull;

public class Injection {

    public static Repository provideRepository(@NonNull Context context) {
        LocalDatabase db = LocalDatabase.getDatabase(context);
        return Repository.getInstance(LocalDataSource.getInstance(db.deviceItemDao(),
                db.groupItemDao(),
                db.locationDao(),
                db.sceneItemDao()));
    }
}
