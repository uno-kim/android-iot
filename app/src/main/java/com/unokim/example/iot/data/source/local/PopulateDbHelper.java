package com.unokim.example.iot.data.source.local;

import com.unokim.example.iot.R;
import com.unokim.example.iot.data.source.entity.DeviceItem;
import com.unokim.example.iot.data.source.entity.GroupItem;
import com.unokim.example.iot.data.source.entity.Location;
import com.unokim.example.iot.data.source.entity.SceneItem;

import java.util.ArrayList;
import java.util.List;
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

    private static final String[] mLocations = {
            "location01", "location02", "location03", "location04", "location05"
    };

    private int getGroupId(int locationId) {
        if (locationId == 0) {
            return mRandom.nextInt(20);
        } else if (locationId == 1) {
            return mRandom.nextInt(11);
        } else if (locationId == 2) {
            return mRandom.nextInt(13);
        } else if (locationId == 3) {
            return mRandom.nextInt(9);
        } else {
            return mRandom.nextInt(17);
        }
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
        for (int i = 0; i < 100; ++i) {

            int deviceId = mRandom.nextInt(10000);
            int name = mRandom.nextInt(mDevices.length);
            int icon = mRandom.nextInt(mDeviceIcons.length);
            int locationId = mRandom.nextInt(mLocations.length);
            int groupId = getGroupId(locationId);

            DeviceItem deviceItem = new DeviceItem(
                    "device" + deviceId,
                    mDevices[name],
                    mDeviceIcons[icon],
                    mLocations[locationId],
                    Integer.toString(groupId),
                    mRandom.nextInt(10000),
                    mRandom.nextBoolean(),
                    mRandom.nextInt(3));
            deviceItems.add(deviceItem);
        }
        return deviceItems;
    }

    List<GroupItem> makeGroupItems() {
        List<GroupItem> groupItems = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {

        }
        return groupItems;
    }

    List<Location> makeLocations() {
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {

        }
        return locations;
    }

    List<SceneItem> makeSceneItems() {
        List<SceneItem> sceneItems = new ArrayList<>();
        for (int i = 0; i < 15; ++i) {

        }
        return sceneItems;
    }
}
