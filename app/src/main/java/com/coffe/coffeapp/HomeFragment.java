package com.coffe.coffeapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView, recyclerViewOther;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;
    private ArrayList<ProductModel> list = new ArrayList<>();
    private ArrayList<OtherProducts> otherList = new ArrayList<>();
    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initRecylerView(view);
        initOtherRecyclerView(view);
        buildData();
        return view;
    }

    private void initRecylerView(View view) {
        recyclerView = view.findViewById(R.id.productCard);
        linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        AdapterData adapterData = new AdapterData(list);
        recyclerView.setAdapter(adapterData);
        adapterData.notifyDataSetChanged();


    }

    private void initOtherRecyclerView(View view) {
        //        Other Recycler View (for other products)
        recyclerViewOther = view.findViewById(R.id.otherProductsCard);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false) {

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerViewOther.setLayoutManager(gridLayoutManager);
        OtherAdapterData otherAdapterData = new OtherAdapterData(otherList);
        recyclerViewOther.setAdapter(otherAdapterData);
        otherAdapterData.notifyDataSetChanged();
    }

    private void buildData() {
        list.add(new ProductModel("Kopi Robusta", 20000));
        list.add(new ProductModel("Kopi Robusta", 20000));
        list.add(new ProductModel("Kopi Robusta", 20000));
        list.add(new ProductModel("Kopi Robusta", 20000));
        list.add(new ProductModel("Kopi Robusta", 20000));

        otherList.add(new OtherProducts("Kopi Robusta", 20000));
        otherList.add(new OtherProducts("Kopi Robusta", 20000));
        otherList.add(new OtherProducts("Kopi Robusta", 20000));
        otherList.add(new OtherProducts("Kopi Robusta", 20000));
        otherList.add(new OtherProducts("Kopi Robusta", 20000));
        otherList.add(new OtherProducts("Kopi Robusta", 20000));
        otherList.add(new OtherProducts("Kopi Robusta", 20000));
        otherList.add(new OtherProducts("Kopi Robusta", 20000));
    }
}