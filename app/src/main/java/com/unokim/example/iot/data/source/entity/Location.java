package com.unokim.example.iot.data.source.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Location")
public class Location {

    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    private String name;
    private int image;
    private int iconId;
    @NonNull
    private String ownerId;

    public Location(@NonNull String id, @NonNull String name, int image, int iconId,
            @NonNull String ownerId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.iconId = iconId;
        this.ownerId = ownerId;
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

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    @NonNull
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(@NonNull String ownerId) {
        this.ownerId = ownerId;
    }
}
