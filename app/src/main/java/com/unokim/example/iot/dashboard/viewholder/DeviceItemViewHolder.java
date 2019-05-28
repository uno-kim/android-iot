package com.unokim.example.iot.dashboard.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.unokim.example.iot.ClickListener;
import com.unokim.example.iot.R;
import com.unokim.example.iot.data.source.entity.DashboardItem;

import androidx.annotation.NonNull;

public class DeviceItemViewHolder extends BaseViewHolder {

    private ClickListener mClickListener;
    private DashboardItem mItem;
    private ImageView mIcon;
    private ImageView mPower;
    private TextView mTitle;
    private TextView mDescription;
    private Button mControl01;
    private Button mControl02;
    private Button mControl03;

    public DeviceItemViewHolder(@NonNull Context context,
            int layoutRes,
            @NonNull ViewGroup parent,
            @NonNull ClickListener clickListener) {
        super(context, layoutRes, parent);

        mClickListener = clickListener;
        mIcon = itemView.findViewById(R.id.icon);
        mPower = itemView.findViewById(R.id.button_power);
        mPower.setOnClickListener(this);

        mTitle = itemView.findViewById(R.id.title);
        mDescription = itemView.findViewById(R.id.description);

        mControl01 = itemView.findViewById(R.id.control_01);
        mControl01.setOnClickListener(this);
        mControl02 = itemView.findViewById(R.id.control_02);
        mControl02.setOnClickListener(this);
        mControl03 = itemView.findViewById(R.id.control_03);
        mControl03.setOnClickListener(this);
    }

    @Override
    public void bind(DashboardItem item) {
        mItem = item;
        mTitle.setText(
                String.format("%s%s", mItem.getName(), mItem.isFavorite() ? " [favorite]" : ""));
        mDescription.setText(String.format("%s [%s, %s, %s]", mItem.getId(), mItem.getLocationId(),
                mItem.getGroupId(), mItem.getOrder()));
        mIcon.setImageResource(mItem.getIconId());
    }

    @Override
    public void onClick(View v) {
        mClickListener.onItemClicked(mItem);
    }

    @Override
    public boolean onLongClick(View v) {
        return mClickListener.onItemLongClicked(mItem);
    }
}
