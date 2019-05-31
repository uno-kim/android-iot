package com.unokim.example.iot.dashboard;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.unokim.example.iot.ClickListener;
import com.unokim.example.iot.FontActivity;
import com.unokim.example.iot.R;
import com.unokim.example.iot.data.source.entity.DashboardItem;
import com.unokim.example.iot.logger.Logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements ClickListener {

    private static final String TAG = "DashboardFragment";

    private RecyclerView mMainRecyclerView;
    private DashboardItemAdapter mDashboardItemAdapter;
    private DashboardViewModel mDashboardViewModel;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        Logger.d(TAG, "onCreateView()");

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        Button button01 = v.findViewById(R.id.navButton01);
        button01.setOnClickListener(v1 -> {
            mDashboardViewModel.update01();
        });
        Button button02 = v.findViewById(R.id.navButton02);
        button02.setOnClickListener(v12 -> {
            mDashboardViewModel.update02();
        });

        mMainRecyclerView = v.findViewById(R.id.main_recycler_view);
        mDashboardItemAdapter = new DashboardItemAdapter(getContext(), this);
        mMainRecyclerView.setAdapter(mDashboardItemAdapter);
        mMainRecyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mMainRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.d(TAG, "onActivityCreated()");

        mDashboardViewModel = ViewModelProviders.of(getActivity()).get(DashboardViewModel.class);
        mDashboardViewModel.getDashboardItems().observe(this, items -> {
            Logger.d(TAG, "getDashboardItems(), size = " + items.size());
            mDashboardItemAdapter.updateList(items);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.d(TAG, "onStart()");
    }

    @Override
    public void onItemClicked(DashboardItem item) {
        Intent intent = new Intent(getContext(), FontActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClicked(DashboardItem item) {
        return false;
    }
}
