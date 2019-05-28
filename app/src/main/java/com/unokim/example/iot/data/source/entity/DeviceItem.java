package com.unokim.example.iot.data.source.entity;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DeviceItem")
public class DeviceItem {

    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    private String name;
    private int iconId;
    @NonNull
    private String locationId;
    @NonNull
    private String groupId;
    private int order;
    private boolean favorite;
    private int deviceStatus;

    public DeviceItem(@NonNull String id, @NonNull String name, int iconId,
            @NonNull String locationId, @NonNull String groupId, int order, boolean favorite,
            int deviceStatus) {
        this.id = id;
        this.name = name;
        this.iconId = iconId;
        this.locationId = locationId;
        this.groupId = groupId;
        this.order = order;
        this.favorite = favorite;
        this.deviceStatus = deviceStatus;
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

    @NonNull
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(@NonNull String groupId) {
        this.groupId = groupId;
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

    public int getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(int deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DeviceItem) {
            DeviceItem item = (DeviceItem) obj;
            return TextUtils.equals(item.getId(), this.getId())
                    && TextUtils.equals(item.getName(), this.getName())
                    && item.getIconId() == this.getIconId()
                    && TextUtils.equals(item.getLocationId(), this.getLocationId())
                    && TextUtils.equals(item.getGroupId(), this.getGroupId())
                    && item.getOrder() == this.getOrder()
                    && item.isFavorite() == this.isFavorite()
                    && item.getDeviceStatus() == this.getDeviceStatus();
        }
        return false;
    }
}
