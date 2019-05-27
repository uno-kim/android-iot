package com.unokim.example.iot.data.source.local;

import com.unokim.example.iot.data.source.entity.SceneItem;

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
public interface SceneItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SceneItem item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SceneItem... items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<SceneItem> items);

    @Update
    void update(SceneItem item);

    @Update
    void update(SceneItem... items);

    @Delete
    void delete(SceneItem item);

    @Delete
    void delete(SceneItem... items);

    @Query("DELETE FROM SceneItem")
    void deleteAll();

    @Query("SELECT * FROM SceneItem WHERE locationId = :locationId ORDER BY `order` ASC, favorite"
            + " ASC")
    Flowable<List<SceneItem>> getScenes(@NonNull String locationId);

    @Query("SELECT * FROM SceneItem WHERE locationId = :locationId AND favorite = 1 ORDER BY "
            + "`order` ASC")
    Flowable<List<SceneItem>> getFavoriteScenes(@NonNull String locationId);
}
