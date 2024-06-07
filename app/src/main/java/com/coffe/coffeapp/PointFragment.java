package com.coffe.coffeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coffe.coffeapp.model.DataProducts;

import java.util.ArrayList;
import java.util.List;

public class PointFragment extends Fragment {
    ArrayList<PointModel> list;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        gridLayoutManager = new GridLayoutManager(getActivity(), 2, gridLayoutManager.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(gridLayoutManager);
        PointAdapter pointAdapter = new PointAdapter(list);
        recyclerView.setAdapter(pointAdapter);
        pointAdapter.notifyDataSetChanged();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_point, container, false);
    }
}