package com.unokim.example.iot;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements ClickListener {


    private RecyclerView mMainRecyclerView;
    private MainItemAdapter mMainItemAdapter;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        mMainRecyclerView = v.findViewById(R.id.main_recycler_view);
        mMainItemAdapter = new MainItemAdapter(getContext(), this);
        mMainItemAdapter.setItems(DefaultMainItem.getInstance().getItems());
        mMainRecyclerView.setAdapter(mMainItemAdapter);
        mMainRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mMainRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return v;
    }

    @Override
    public void onItemClicked(MainItem item) {
        Intent intent = new Intent(getContext(), FontActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClicked(MainItem item) {
        return false;
    }
}
