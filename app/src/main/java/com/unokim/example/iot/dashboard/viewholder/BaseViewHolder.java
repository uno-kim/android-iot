package com.unokim.example.iot.dashboard.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unokim.example.iot.data.source.entity.DashboardItem;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener, View.OnLongClickListener {

    public BaseViewHolder(@NonNull Context context, @LayoutRes int layoutRes,
            @NonNull ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(layoutRes, parent, false));
    }

    public abstract void bind(DashboardItem item);
}