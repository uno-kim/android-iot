package com.unokim.example.iot.data.source;

import com.unokim.example.iot.data.source.entity.DeviceItem;
import com.unokim.example.iot.data.source.entity.GroupItem;
import com.unokim.example.iot.data.source.entity.Location;
import com.unokim.example.iot.data.source.entity.SceneItem;
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

    public void update01() {
        mLocalDataSource.update01();
    }

    public void update02() {
        mLocalDataSource.update02();
    }

    public Flowable<List<DeviceItem>> getDevicesFlowable(@NonNull String groupId) {
        return mLocalDataSource.getDevicesFlowable(groupId);
    }

    public Flowable<List<DeviceItem>> getFavoriteDevicesFlowable(@NonNull String groupId) {
        return mLocalDataSource.getDevicesFlowable(groupId);
    }

    public List<DeviceItem> getFavoriteDevices(@NonNull String groupId) {
        return mLocalDataSource.getFavoriteDevices(groupId);
    }

    public Flowable<List<DeviceItem>> getFavoriteDevicesFlowableByLocation(
            @NonNull String locationId) {
        return mLocalDataSource.getFavoriteDevicesFlowableByLocation(locationId);
    }

    public Flowable<List<DeviceItem>> getAllFavoriteDevicesFlowable() {
        return mLocalDataSource.getAllFavoriteDevicesFlowable();
    }

    public Flowable<List<SceneItem>> getScenes(@NonNull String locationId) {
        return mLocalDataSource.getScenes(locationId);
    }

    public Flowable<List<GroupItem>> getGroupsFlowable(@NonNull String locationId) {
        return mLocalDataSource.getGroupsFlowable(locationId);
    }

    public List<GroupItem> getGroups(@NonNull String locationId) {
        return mLocalDataSource.getGroups(locationId);
    }

    public Flowable<List<Location>> getAllLocationsFlowable() {
        return mLocalDataSource.getAllLocationsFlowable();
    }

    public List<Location> getAllLocations() {
        return mLocalDataSource.getAllLocations();
    }

    public void clearAllDisposables() {
        Logger.d(TAG, "clearAllDisposables()");
        mLocalDataSource.clearAllDisposables();
    }
}
