package com.unokim.example.iot.dashboard.viewholder;

import android.content.Context;
import android.view.ViewGroup;

import com.unokim.example.iot.ClickListener;
import com.unokim.example.iot.R;
import com.unokim.example.iot.data.source.entity.DashboardItemType;

import androidx.annotation.NonNull;

public class ViewHolderHelper {

    public static BaseViewHolder createViewHolder(@NonNull Context context,
            @NonNull ViewGroup parent, int viewType, ClickListener clickListener) {

        if (viewType == DashboardItemType.ROOM_TITLE.getValue()) {
            return new RoomTitleViewHolder(context, R.layout.room_title, parent, clickListener);
        } else if (viewType == DashboardItemType.DEVICE_ITEM.getValue()) {
            return new DeviceItemViewHolder(context, R.layout.device_card_normal, parent,
                    clickListener);
        } else if (viewType == DashboardItemType.DEVICE_EMPTY.getValue()) {
            return new DeviceEmptyViewHolder(context, R.layout.device_empty, parent, clickListener);
        } else if (viewType == DashboardItemType.SCENE_TITLE.getValue()) {
            return new SceneTitleViewHolder(context, R.layout.room_title, parent, clickListener);
        } else if (viewType == DashboardItemType.SCENE_ITEM.getValue()) {
            return new SceneItemViewHolder(context, R.layout.room_title, parent, clickListener);
        } else if (viewType == DashboardItemType.SCENE_EMPTY.getValue()) {
            return new SceneEmptyViewHolder(context, R.layout.room_title, parent, clickListener);
        }
        // default
        return new RoomTitleViewHolder(context, R.layout.room_title, parent, clickListener);
    }
}
