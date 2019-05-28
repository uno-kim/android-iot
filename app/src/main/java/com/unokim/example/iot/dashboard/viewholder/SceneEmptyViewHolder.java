package com.unokim.example.iot.dashboard.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.unokim.example.iot.ClickListener;
import com.unokim.example.iot.data.source.entity.DashboardItem;

import androidx.annotation.NonNull;

public class SceneEmptyViewHolder extends BaseViewHolder {

    public SceneEmptyViewHolder(@NonNull Context context,
            int layoutRes,
            @NonNull ViewGroup parent,
            @NonNull ClickListener clickListener) {
        super(context, layoutRes, parent);
    }

    @Override
    public void bind(DashboardItem item) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
