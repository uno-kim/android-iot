package com.unokim.example.iot.data.source.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SceneItem")
public class SceneItem {

    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    private String name;
    private int iconId;
    @NonNull
    private String locationId;
    private int order;
    private boolean favorite;
    private int sceneStatus;

    public SceneItem(@NonNull String id, @NonNull String name, int iconId,
            @NonNull String locationId, int order, boolean favorite, int sceneStatus) {
        this.id = id;
        this.name = name;
        this.iconId = iconId;
        this.locationId = locationId;
        this.order = order;
        this.favorite = favorite;
        this.sceneStatus = sceneStatus;
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

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getSceneStatus() {
        return sceneStatus;
    }

    public void setSceneStatus(int sceneStatus) {
        this.sceneStatus = sceneStatus;
    }
}
