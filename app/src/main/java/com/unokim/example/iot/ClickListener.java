package com.unokim.example.iot;

import com.unokim.example.iot.data.source.entity.DashboardItem;

public interface ClickListener {

    void onItemClicked(DashboardItem item);

    boolean onItemLongClicked(DashboardItem item);
}
