package com.unokim.example.iot.data.source.entity;

public enum DashboardItemType {
    ROOM_TITLE(0),
    DEVICE_ITEM(1),
    DEVICE_EMPTY(2),
    SCENE_TITLE(3),
    SCENE_ITEM(4),
    SCENE_EMPTY(5);

    private final int value;

    DashboardItemType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
