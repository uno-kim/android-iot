package com.unokim.example.iot.data.source.local;

import com.unokim.example.iot.data.source.entity.DeviceItem;
import com.unokim.example.iot.logger.Logger;

import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;

public class LocalDataSource {

    private static final String TAG = "LocalDataSource";

    private static volatile LocalDataSource INSTANCE;

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @NonNull
    private final DeviceItemDao mDeviceItemDao;
    @NonNull
    private final GroupItemDao mGroupItemDao;
    @NonNull
    private final LocationDao mLocationDao;
    @NonNull
    private final SceneItemDao mSceneItemDao;

    private LocalDataSource(@NonNull DeviceItemDao deviceItemDao,
            @NonNull GroupItemDao groupItemDao,
            @NonNull LocationDao locationDao,
            @NonNull SceneItemDao sceneItemDao) {
        mDeviceItemDao = deviceItemDao;
        mGroupItemDao = groupItemDao;
        mLocationDao = locationDao;
        mSceneItemDao = sceneItemDao;
    }

    public static LocalDataSource getInstance(@NonNull DeviceItemDao deviceItemDao,
            @NonNull GroupItemDao groupItemDao,
            @NonNull LocationDao locationDao,
            @NonNull SceneItemDao sceneItemDao) {
        if (INSTANCE == null) {
            synchronized (LocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSource(deviceItemDao, groupItemDao, locationDao,
                            sceneItemDao);
                }
            }
        }
        return INSTANCE;
    }

    public Flowable<List<DeviceItem>> getDevices(@NonNull String groupId) {
        return mDeviceItemDao.getDevices(groupId);
    }

    public Flowable<List<DeviceItem>> getFavoriteDevices(@NonNull String groupId) {
        return mDeviceItemDao.getDevices(groupId);
    }

    public Flowable<List<DeviceItem>> getAllFavoriteDevices() {
        return mDeviceItemDao.getAllFavoriteDevices();
    }

    public void clearAllDisposables() {
        Logger.d(TAG, "clearAllDisposables()");
        mCompositeDisposable.clear();
    }

}
