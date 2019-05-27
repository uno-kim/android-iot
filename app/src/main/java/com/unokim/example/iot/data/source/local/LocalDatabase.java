package com.unokim.example.iot.data.source.local;

import android.content.Context;
import android.os.AsyncTask;

import com.unokim.example.iot.R;
import com.unokim.example.iot.data.source.entity.DeviceItem;
import com.unokim.example.iot.data.source.entity.GroupItem;
import com.unokim.example.iot.data.source.entity.Location;
import com.unokim.example.iot.data.source.entity.SceneItem;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {DeviceItem.class, GroupItem.class, Location.class,
        SceneItem.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {

    private static volatile LocalDatabase INSTANCE;

    public abstract DeviceItemDao deviceItemDao();

    public abstract GroupItemDao groupItemDao();

    public abstract LocationDao locationDao();

    public abstract SceneItemDao sceneItemDao();

    private static final Object sLock = new Object();

    public static LocalDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LocalDatabase.class, "dashboard.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final DeviceItemDao mDeviceItemDao;
        private final GroupItemDao mGroupItemDao;
        private final LocationDao mLocationDao;
        private final SceneItemDao mSceneItemDao;

        PopulateDbAsync(LocalDatabase db) {
            mDeviceItemDao = db.deviceItemDao();
            mGroupItemDao = db.groupItemDao();
            mLocationDao = db.locationDao();
            mSceneItemDao = db.sceneItemDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDeviceItemDao.deleteAll();
            mGroupItemDao.deleteAll();
            mLocationDao.deleteAll();
            mSceneItemDao.deleteAll();

            mDeviceItemDao.insert(
                    new DeviceItem("001", "device001", R.drawable.ic_cloud_circle_black_24dp,
                            "home", "room01", 0, true, 1));
            return null;
        }
    }
}
