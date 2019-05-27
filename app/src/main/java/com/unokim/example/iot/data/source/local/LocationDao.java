package com.unokim.example.iot.data.source.local;

import com.unokim.example.iot.data.source.entity.Location;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Flowable;

@Dao
public interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Location item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Location... items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Location> items);

    @Update
    void update(Location item);

    @Update
    void update(Location... items);

    @Delete
    void delete(Location item);

    @Delete
    void delete(Location... items);

    @Query("DELETE FROM Location")
    void deleteAll();

    @Query("SELECT * FROM Location")
    Flowable<List<Location>> getAllLocations();
}
