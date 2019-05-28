package com.unokim.example.iot.data.source.entity;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

public class DashboardItem {

    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    private DashboardItemType itemType;
    @NonNull
    private String name;
    private int iconId;
    private int order;
    private boolean favorite;
    @NonNull
    private String locationId;
    @NonNull
    private String groupId;

    public DashboardItem(@NonNull String id,
            @NonNull DashboardItemType itemType, @NonNull String name, int iconId, int order,
            boolean favorite, @NonNull String locationId, @NonNull String groupId) {
        this.id = id;
        this.itemType = itemType;
        this.name = name;
        this.iconId = iconId;
        this.order = order;
        this.favorite = favorite;
        this.locationId = locationId;
        this.groupId = groupId;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public DashboardItemType getItemType() {
        return itemType;
    }

    public void setItemType(@NonNull DashboardItemType itemType) {
        this.itemType = itemType;
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

    @NonNull
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(@NonNull String locationId) {
        this.locationId = locationId;
    }

    @NonNull
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(@NonNull String groupId) {
        this.groupId = groupId;
    }
}
