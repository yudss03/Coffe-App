package com.coffe.coffeapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView, recyclerViewOther;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;
    DatabaseReference databaseReference, databaseReference1;
    private ArrayList<ProductModel> list = new ArrayList<>();
    private ArrayList<OtherProductsModel> otherList = new ArrayList<>();
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
        clearPicassoCache();
//        buildData();
        return view;
    }

    private void initRecylerView(View view) {
        recyclerView = view.findViewById(R.id.productCard);
        linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
    
        recyclerView.setLayoutManager(linearLayoutManager);
        AdapterData adapterData = new AdapterData(list);
        databaseReference = FirebaseDatabase.getInstance().getReference("products");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    ProductModel product = dataSnapshot.getValue(ProductModel.class);
                    list.add(product);
                }
                adapterData.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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
        databaseReference1 = FirebaseDatabase.getInstance().getReference("products");
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    OtherProductsModel otherProducts = dataSnapshot.getValue(OtherProductsModel.class);
                    otherList.add(otherProducts);
                }
                otherAdapterData.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recyclerViewOther.setAdapter(otherAdapterData);
        otherAdapterData.notifyDataSetChanged();
    }

    private void clearPicassoCache() {
        try {
            File cache = new File(getActivity().getCacheDir(), "picasso-cache");
            if (cache.exists()) {
                File[] files = cache.listFiles();
                if (files != null) {
                    for (File file : files) {
                        file.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   

//    private void buildData() {
//        list.add(new ProductModel("Kopi Robusta", 20000));
//        list.add(new ProductModel("Kopi Robusta", 20000));
//        list.add(new ProductModel("Kopi Robusta", 20000));
//        list.add(new ProductModel("Kopi Robusta", 20000));
//        list.add(new ProductModel("Kopi Robusta", 20000));
//
//        otherList.add(new OtherProducts("Kopi Robusta", 20000));
//        otherList.add(new OtherProducts("Kopi Robusta", 20000));
//        otherList.add(new OtherProducts("Kopi Robusta", 20000));
//        otherList.add(new OtherProducts("Kopi Robusta", 20000));
//        otherList.add(new OtherProducts("Kopi Robusta", 20000));
//        otherList.add(new OtherProducts("Kopi Robusta", 20000));
//        otherList.add(new OtherProducts("Kopi Robusta", 20000));
//        otherList.add(new OtherProducts("Kopi Robusta", 20000));
//    }
}