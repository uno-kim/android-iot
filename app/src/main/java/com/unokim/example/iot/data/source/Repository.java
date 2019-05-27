package com.unokim.example.iot.data.source;

import com.unokim.example.iot.data.source.entity.DeviceItem;
import com.unokim.example.iot.data.source.local.LocalDataSource;
import com.unokim.example.iot.logger.Logger;

import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Flowable;

public class Repository {

    private static final String TAG = "Repository";

    private static volatile Repository INSTANCE;

    @NonNull
    private final LocalDataSource mLocalDataSource;

    private Repository(@NonNull LocalDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    public static Repository getInstance(@NonNull LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Repository(localDataSource);
                }
            }
        }
        return INSTANCE;
    }


    public Flowable<List<DeviceItem>> getDevices(@NonNull String groupId) {
        return mLocalDataSource.getDevices(groupId);
    }

    public Flowable<List<DeviceItem>> getFavoriteDevices(@NonNull String groupId) {
        return mLocalDataSource.getDevices(groupId);
    }

    public Flowable<List<DeviceItem>> getAllFavoriteDevices() {
        return mLocalDataSource.getAllFavoriteDevices();
    }

    public void clearAllDisposables() {
        Logger.d(TAG, "clearAllDisposables()");
        mLocalDataSource.clearAllDisposables();
    }
}
