package com.unokim.example.iot.data.source.local;

import com.unokim.example.iot.data.source.entity.GroupItem;

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
public interface GroupItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GroupItem item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GroupItem... items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<GroupItem> items);

    @Update
    void update(GroupItem item);

    @Update
    void update(GroupItem... items);

    @Delete
    void delete(GroupItem item);

    @Delete
    void delete(GroupItem... items);

    @Query("DELETE FROM GroupItem")
    void deleteAll();

    @Query("SELECT * FROM GroupItem WHERE locationId = :locationId ORDER BY `order` ASC")
    Flowable<List<GroupItem>> getGroupsFlowable(@NonNull String locationId);

    @Query("SELECT * FROM GroupItem WHERE locationId = :locationId ORDER BY `order` ASC")
    List<GroupItem> getGroups(@NonNull String locationId);
}
