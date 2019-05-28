package com.unokim.example.iot.data.source.entity;

import android.text.TextUtils;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

public class DashboardItemDiffCallback extends DiffUtil.Callback {

    private final List<DashboardItem> oldList;
    private final List<DashboardItem> newList;

    public DashboardItemDiffCallback(
            List<DashboardItem> oldList,
            List<DashboardItem> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }


    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        String oldId = oldList.get(oldItemPosition).getId();
        String newId = newList.get(newItemPosition).getId();
        return TextUtils.equals(oldId, newId);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final DashboardItem oldItem = oldList.get(oldItemPosition);
        final DashboardItem newItem = newList.get(newItemPosition);
        return oldItem.equals(newItem);
    }
}
