package com.unokim.example.iot.data.source.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "GroupItem")
public class GroupItem {

    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    private String name;
    private int image;
    @NonNull
    private String locationId;
    private int order;

    public GroupItem(@NonNull String id, @NonNull String name, int image,
            @NonNull String locationId, int order) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.locationId = locationId;
        this.order = order;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @NonNull
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(@NonNull String locationId) {
        this.locationId = locationId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
