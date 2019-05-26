package com.unokim.example.iot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainItemAdapter extends RecyclerView.Adapter<MainItemAdapter.MainItemViewHolder> {

    private final List<MainItem> mItems = new ArrayList<>();
    private final LayoutInflater mInflater;
    private final ClickListener mClickListener;

    public MainItemAdapter(@NonNull Context context, @NonNull ClickListener clickListener) {
        mInflater = LayoutInflater.from(context);
        mClickListener = clickListener;
    }

    public void setItems(List<MainItem> items) {
        mItems.clear();
        mItems.addAll(items);
    }

    @NonNull
    @Override
    public MainItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.device_card_normal, parent, false);
        return new MainItemViewHolder(v, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainItemViewHolder holder, int position) {
        MainItem item = mItems.get(position);
        holder.bindItem(item);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class MainItemViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {

        private ClickListener mClickListener;
        private MainItem mItem;
        private ImageView mIcon;
        private ImageView mPower;
        private TextView mTitle;
        private TextView mDescription;
        private Button mControl01;
        private Button mControl02;
        private Button mControl03;

        MainItemViewHolder(@NonNull View itemView, @NonNull ClickListener clickListener) {
            super(itemView);
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

        void bindItem(MainItem item) {
            mItem = item;

            mTitle.setText(item.getTitle());
            mDescription.setText(item.getDescription());

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
}
