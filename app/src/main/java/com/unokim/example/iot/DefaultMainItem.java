package com.unokim.example.iot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultMainItem {

    private static final Random mRandom = new Random();
    private static String[] mTitles = {
            "Air Purifier 2010", "TV 2010", "AC 2010", "Robot 2010", "Cloud 2010", "AV 2010", "Washer 2010", "Oven 2010",
            "Air Purifier 2019", "TV 2019", "AC 2019", "Robot 2019", "Cloud 2019", "AV 2019", "Washer 2019", "Oven 2019"
    };
    private List<MainItem> mItems = new ArrayList<>();

    private DefaultMainItem() {
        makeItems();
    }

    public static DefaultMainItem getInstance() {
        return LazyHolder.INSTANCE;
    }

    private void makeItems() {
        for (int i = 0; i < 20; ++i) {
            int index = mRandom.nextInt(mTitles.length);
            MainItem item = new MainItem(
                    R.drawable.ic_cloud_circle_black_24dp,
                    R.drawable.ic_power_settings_new_black_24dp,
                    mTitles[index],
                    "Condition is good!"
            );
            mItems.add(item);
        }
    }

    public List<MainItem> getItems() {
        return mItems;
    }

    private static class LazyHolder {
        private static final DefaultMainItem INSTANCE = new DefaultMainItem();
    }
}
