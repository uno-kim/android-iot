package com.unokim.example.iot;

import android.app.Application;

import com.unokim.example.iot.data.source.Repository;
import com.unokim.example.iot.data.source.entity.DeviceItem;
import com.unokim.example.iot.logger.Logger;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends DisposableViewModel {

    private static final String TAG = "MainViewModel";

    private final Repository mRepository;

    private MutableLiveData<List<DeviceItem>> mItems;

    public MainViewModel(@NonNull Application application) {
        super(application);
        Logger.d(TAG, "create()");
        mRepository = Injection.provideRepository(application.getApplicationContext());
    }

    public LiveData<List<DeviceItem>> getITems() {
        Logger.d(TAG, "getITems()");
        if (mItems == null) {
            mItems = new MutableLiveData<>();
            loadItems();
        }
        return mItems;
    }

    private void loadItems() {
        Logger.d(TAG, "loadItems()");
        addDisposable(mRepository.getAllFavoriteDevices()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> mItems.postValue(item)));
    }

    @Override
    protected void onCleared() {
        mRepository.clearAllDisposables();
        super.onCleared();
    }
}
