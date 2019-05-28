package com.unokim.example.iot.data.source.local;

import com.unokim.example.iot.data.source.entity.DeviceItem;
import com.unokim.example.iot.data.source.entity.GroupItem;
import com.unokim.example.iot.data.source.entity.Location;
import com.unokim.example.iot.data.source.entity.SceneItem;
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

    public Flowable<List<DeviceItem>> getDevicesFlowable(@NonNull String groupId) {
        return mDeviceItemDao.getDevicesFlowable(groupId);
    }

    public Flowable<List<DeviceItem>> getFavoriteDevicesFlowable(@NonNull String groupId) {
        return mDeviceItemDao.getDevicesFlowable(groupId);
    }

    public Flowable<List<DeviceItem>> getFavoriteDevicesFlowableByLocation(
            @NonNull String locationId) {
        return mDeviceItemDao.getFavoriteDevicesFlowableByLocation(locationId);
    }

    public List<DeviceItem> getFavoriteDevices(@NonNull String groupId) {
        return mDeviceItemDao.getFavoriteDevices(groupId);
    }

    public Flowable<List<DeviceItem>> getAllFavoriteDevicesFlowable() {
        return mDeviceItemDao.getAllFavoriteDevicesFlowable();
    }

    public Flowable<List<SceneItem>> getScenes(@NonNull String locationId) {
        return mSceneItemDao.getScenes(locationId);
    }

    public Flowable<List<GroupItem>> getGroupsFlowable(@NonNull String locationId) {
        return mGroupItemDao.getGroupsFlowable(locationId);
    }

    public List<GroupItem> getGroups(@NonNull String locationId) {
        return mGroupItemDao.getGroups(locationId);
    }

    public Flowable<List<Location>> getAllLocationsFlowable() {
        return mLocationDao.getAllLocationsFlowable();
    }

    public List<Location> getAllLocations() {
        return mLocationDao.getAllLocations();
    }

    public void clearAllDisposables() {
        Logger.d(TAG, "clearAllDisposables()");
        mCompositeDisposable.clear();
    }

}
