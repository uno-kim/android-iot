package com.unokim.example.iot.data.source.local;

import com.unokim.example.iot.data.source.entity.DeviceItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Flowable;

@Dao
public interface DeviceItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DeviceItem item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DeviceItem... items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<DeviceItem> items);

    @Update
    void update(DeviceItem item);

    @Update
    void update(DeviceItem... items);

    @Delete
    void delete(DeviceItem item);

    @Delete
    void delete(DeviceItem... items);

    @Query("DELETE FROM DeviceItem")
    void deleteAll();

    @Query("SELECT * FROM DeviceItem WHERE groupId = :groupId ORDER BY `order` ASC, favorite ASC")
    Flowable<List<DeviceItem>> getDevices(@NonNull String groupId);

    @Query("SELECT * FROM DeviceItem WHERE groupId = :groupId AND favorite = 1 ORDER BY `order` "
            + "ASC")
    Flowable<List<DeviceItem>> getFavoriteDevices(@NonNull String groupId);

    @Query("SELECT * FROM DeviceItem WHERE favorite = 1 ORDER BY `order` ASC")
    Flowable<List<DeviceItem>> getAllFavoriteDevices();
}
