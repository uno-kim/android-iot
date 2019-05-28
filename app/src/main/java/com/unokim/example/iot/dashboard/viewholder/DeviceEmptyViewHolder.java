package com.unokim.example.iot.dashboard.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unokim.example.iot.ClickListener;
import com.unokim.example.iot.R;
import com.unokim.example.iot.data.source.entity.DashboardItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class DeviceEmptyViewHolder extends BaseViewHolder {

    private DashboardItem mItem;
    private TextView mTitle;

    public DeviceEmptyViewHolder(@NonNull Context context,
            int layoutRes,
            @NonNull ViewGroup parent,
            @NonNull ClickListener clickListener) {
        super(context, layoutRes, parent);

        mTitle = itemView.findViewById(R.id.title);
    }

    @Override
    public void bind(DashboardItem item) {
        mItem = item;
        mTitle.setText(mItem.getName());

        final ViewGroup.LayoutParams lp = itemView.getLayoutParams();
        if (lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams sglp =
                    (StaggeredGridLayoutManager.LayoutParams) lp;
            sglp.setFullSpan(true);
            itemView.setLayoutParams(sglp);
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
