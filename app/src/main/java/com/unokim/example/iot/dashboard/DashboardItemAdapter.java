package com.unokim.example.iot.dashboard;

import android.content.Context;
import android.view.ViewGroup;

import com.unokim.example.iot.ClickListener;
import com.unokim.example.iot.dashboard.viewholder.BaseViewHolder;
import com.unokim.example.iot.dashboard.viewholder.ViewHolderHelper;
import com.unokim.example.iot.data.source.entity.DashboardItem;
import com.unokim.example.iot.data.source.entity.DashboardItemDiffCallback;
import com.unokim.example.iot.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "DashboardItemAdapter";

    private final List<DashboardItem> mItems = new ArrayList<>();
    private final ClickListener mClickListener;
    private final Context mContext;

    public DashboardItemAdapter(@NonNull Context context, @NonNull ClickListener clickListener) {
        Logger.d(TAG, "DashboardItemAdapter()");
        mContext = context;
        mClickListener = clickListener;
    }

    public void updateList(List<DashboardItem> newItems) {
        Logger.d(TAG, "updateList()");
        final DiffUtil.DiffResult diffResult =
                DiffUtil.calculateDiff(new DashboardItemDiffCallback(mItems, newItems));
        mItems.clear();
        mItems.addAll(newItems);
        diffResult.dispatchUpdatesTo(DashboardItemAdapter.this);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolderHelper.createViewHolder(mContext, parent, viewType, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final DashboardItem item = mItems.get(position);
        if (holder instanceof BaseViewHolder) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
            baseViewHolder.bind(item);
        }
    }

    @Override
    public int getItemViewType(int position) {
        final DashboardItem item = mItems.get(position);
        return item.getItemType().getValue();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
