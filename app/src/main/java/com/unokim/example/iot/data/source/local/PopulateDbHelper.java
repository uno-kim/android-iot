package com.unokim.example.iot.data.source.local;

import com.unokim.example.iot.R;
import com.unokim.example.iot.data.source.entity.DeviceItem;
import com.unokim.example.iot.data.source.entity.GroupItem;
import com.unokim.example.iot.data.source.entity.Location;
import com.unokim.example.iot.data.source.entity.SceneItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

class PopulateDbHelper {

    private static final Random mRandom = new Random();

    private static final String[] mDevices = {
            "AV", "Tracker", "TV", "Wi-Fi", "Dryer", "Air purifier", "Fridge", "Robot cleaner",
            "Washer", "Dishwasher", "Air dresser", "Air conditioner", "Oven"
    };

    private static final int[] mDeviceIcons = {
            R.drawable.ic_cloud_circle_black_24dp,
            R.drawable.ic_power_settings_new_black_24dp,
            R.drawable.ic_remove_red_eye_black_24dp,
            R.drawable.ic_router_black_24dp,
            R.drawable.ic_wb_incandescent_black_24dp,
            R.drawable.ic_storage_black_24dp,
            R.drawable.ic_speaker_group_black_24dp
    };

    private static final int[] mSceneIcons = {
            R.drawable.ic_cloud_circle_black_24dp,
            R.drawable.ic_power_settings_new_black_24dp,
            R.drawable.ic_remove_red_eye_black_24dp,
            R.drawable.ic_router_black_24dp,
            R.drawable.ic_wb_incandescent_black_24dp,
            R.drawable.ic_storage_black_24dp,
            R.drawable.ic_speaker_group_black_24dp
    };

    private static final String[] mLocationNames = {
            "Home", "Office", "USA", "Uncle Joe", "Studio"
    };

    private static int[] mGroupCount = {20, 11, 13, 9, 17};

    private int getGroupId(int locationId) {
        return mRandom.nextInt(mGroupCount[locationId]);
    }

    static PopulateDbHelper getInstance() {
        return PopulateDbHelper.LazyHolder.INSTANCE;
    }

    private PopulateDbHelper() {
    }

    private static class LazyHolder {
        private static final PopulateDbHelper INSTANCE = new PopulateDbHelper();
    }

    List<DeviceItem> makeDeviceItems() {
        List<DeviceItem> deviceItems = new ArrayList<>();
        for (int i = 0; i < 500; ++i) {

            int deviceId = mRandom.nextInt(50000);
            int name = mRandom.nextInt(mDevices.length);
            int icon = mRandom.nextInt(mDeviceIcons.length);
            int locationId = mRandom.nextInt(5);
            boolean favorite = mRandom.nextBoolean();
            int groupId = getGroupId(locationId);

            DeviceItem deviceItem = new DeviceItem(
                    String.format(Locale.getDefault(), "device%05d", deviceId),
                    mDevices[name],
                    mDeviceIcons[icon],
                    String.format(Locale.getDefault(), "location%02d", locationId),
                    String.format(Locale.getDefault(), "group%d%02d", locationId, groupId),
                    mRandom.nextInt(50000),
                    favorite,
                    mRandom.nextInt(3));
            deviceItems.add(deviceItem);
        }
        return deviceItems;
    }

    List<GroupItem> makeGroupItems() {
        List<GroupItem> groupItems = new ArrayList<>();
        for (int locationId = 0; locationId < 5; ++locationId) {
            int groupCount = mGroupCount[locationId];
            for (int i = 0; i < groupCount; ++i) {
                GroupItem groupItem = new GroupItem(
                        String.format(Locale.getDefault(), "group%d%02d", locationId, i),
                        String.format(Locale.getDefault(), "group%02d", i),
                        0,
                        String.format(Locale.getDefault(), "location%02d", locationId),
                        0
                );
                groupItems.add(groupItem);
            }
        }
        return groupItems;
    }

    List<Location> makeLocations() {
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            Location location = new Location(
                    String.format(Locale.getDefault(), "location%02d", i),
                    mLocationNames[i],
                    0,
                    0,
                    "owner");
            locations.add(location);
        }
        return locations;
    }

    List<SceneItem> makeSceneItems() {
        List<SceneItem> sceneItems = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            int sceneId = mRandom.nextInt(900);
            int icon = mRandom.nextInt(mSceneIcons.length);
            int locationId = mRandom.nextInt(5);
            boolean favorite = mRandom.nextBoolean();

            SceneItem sceneItem = new SceneItem(
                    String.format(Locale.getDefault(), "scene%03d", sceneId),
                    String.format(Locale.getDefault(), "scene%03d", sceneId),
                    icon,
                    String.format(Locale.getDefault(), "location%02d", locationId),
                    mRandom.nextInt(900),
                    favorite,
                    mRandom.nextInt(3));
            sceneItems.add(sceneItem);
        }
        return sceneItems;
    }
}
