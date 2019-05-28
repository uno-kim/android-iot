package com.unokim.example.iot.dashboard;

import android.app.Application;

import com.unokim.example.iot.DisposableViewModel;
import com.unokim.example.iot.Injection;
import com.unokim.example.iot.data.source.Repository;
import com.unokim.example.iot.data.source.entity.DashboardItem;
import com.unokim.example.iot.data.source.entity.DashboardItemType;
import com.unokim.example.iot.data.source.entity.DeviceItem;
import com.unokim.example.iot.data.source.entity.GroupItem;
import com.unokim.example.iot.data.source.entity.Location;
import com.unokim.example.iot.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class DashboardViewModel extends DisposableViewModel {

    private static final String TAG = "DashboardViewModel";

    private final Repository mRepository;
    private MutableLiveData<List<DashboardItem>> mDashboardItems;

    public DashboardViewModel(@NonNull Application application) {
        super(application);
        Logger.d(TAG, "create()");
        mRepository = Injection.provideRepository(application.getApplicationContext());
    }

    LiveData<List<DashboardItem>> getDashboardItems() {
        Logger.d(TAG, "getDashboardItems()");
        if (mDashboardItems == null) {
            mDashboardItems = new MutableLiveData<>();
            addDisposable(Single.just("").subscribeOn(Schedulers.io())
                    .subscribe(s -> subscribeDashboardItems()));
        }
        return mDashboardItems;
    }

    private void subscribeDashboardItems() {
        List<Location> locations = mRepository.getAllLocations();
        if (locations.size() == 0) {
            return;
        }
        String locationId = locations.get(0).getId();
        Flowable<String> source1 = mRepository.getGroupsFlowable(locationId).map(groupItems -> "");
        Flowable<String> source2 = mRepository.getFavoriteDevicesFlowableByLocation(locationId).map(
                items -> "");
        addDisposable(Flowable.merge(source1, source2)
                .subscribeOn(Schedulers.io())
                .subscribe(s -> updateDashboardItems()));
    }

    @WorkerThread
    private void updateDashboardItems() {
        Logger.d(TAG, "makeDashboardItems()");
        List<DashboardItem> dashboardItems = new ArrayList<>();
        List<Location> locations = mRepository.getAllLocations();
        if (locations.size() == 0) return;

        // group list
        List<GroupItem> groupItems = mRepository.getGroups(locations.get(0).getId());
        groupItems.forEach(groupItem -> {
            DashboardItem item = new DashboardItem(
                    groupItem.getId(),
                    DashboardItemType.ROOM_TITLE,
                    groupItem.getName(),
                    0,
                    groupItem.getOrder(),
                    true,
                    groupItem.getLocationId(),
                    groupItem.getId()
            );
            dashboardItems.add(item);

            List<DeviceItem> deviceItems = mRepository.getFavoriteDevices(groupItem.getId());

            if (deviceItems.size() == 0) {
                DashboardItem item1 = new DashboardItem(
                        "",
                        DashboardItemType.DEVICE_EMPTY,
                        "No devices",
                        0,
                        0,
                        true,
                        "",
                        "");
                dashboardItems.add(item1);
            } else {
                deviceItems.forEach(deviceItem -> {
                    DashboardItem item1 = new DashboardItem(
                            deviceItem.getId(),
                            DashboardItemType.DEVICE_ITEM,
                            deviceItem.getName(),
                            deviceItem.getIconId(),
                            deviceItem.getOrder(),
                            deviceItem.isFavorite(),
                            deviceItem.getLocationId(),
                            deviceItem.getGroupId()
                    );
                    dashboardItems.add(item1);
                });
            }
        });
        mDashboardItems.postValue(dashboardItems);
    }

    @Override
    protected void onCleared() {
        mRepository.clearAllDisposables();
        super.onCleared();
    }
}
