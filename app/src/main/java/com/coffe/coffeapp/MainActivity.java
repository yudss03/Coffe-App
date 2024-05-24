package com.coffe.coffeapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coffe.coffeapp.model.DataProducts;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    DatabaseReference reference;
    ProductsAdapter productsAdapter;
    ArrayList<DataProducts> dataProducts;
    List<String> productTitle, productPrice;

//    OUR PRODUCTS CODE
    List<String>  ourProductsTitle, ourProductsPrice;

//    BOTTOM NAVIGATION CODE
    private BottomNavigationView bottomNavigationView;
    public FrameLayout frameLayout;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        PRODUCT FIREBASE CODE START
        productTitle = new ArrayList<>();
        productPrice = new ArrayList<>();
        recyclerView = findViewById(R.id.productCard);

        productTitle.add("Kopi Robusta");
        productPrice.add("IDR 20.000");
        productTitle.add("Kopi Robusta");
        productPrice.add("IDR 20.000");
        productTitle.add("Kopi Robusta");
        productPrice.add("IDR 20.000");
        productTitle.add("Kopi Robusta");
        productPrice.add("IDR 20.000");
        productTitle.add("Kopi Robusta");
        productPrice.add("IDR 20.000");
        productTitle.add("Kopi Robusta");
        productPrice.add("IDR 20.000");

        linearLayoutManager = new LinearLayoutManager(this, linearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterData = new AdapterData(this, productTitle, productPrice);
        recyclerView.setAdapter(adapterData);
//        PRODUCT FIREBASE CODE END

//        OUR PRODUCTS CODE
        ourProductsTitle = new ArrayList<>();
        ourProductsPrice = new ArrayList<>();
        recyclerView = findViewById(R.id.ourProductsCard);

        ourProductsTitle.add("Kopi Robusta");
        ourProductsPrice.add("IDR 20.000");
        ourProductsTitle.add("Kopi Robusta");
        ourProductsPrice.add("IDR 20.000");
        ourProductsTitle.add("Kopi Robusta");
        ourProductsPrice.add("IDR 20.000");
        ourProductsTitle.add("Kopi Robusta");
        ourProductsPrice.add("IDR 20.000");

        linearLayoutManager = new LinearLayoutManager(this, linearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        productsAdapter = new ProductsAdapter(this, ourProductsTitle, ourProductsTitle);
        recyclerView.setAdapter(productsAdapter);
        productsAdapter.notifyDataSetChanged();

//        BOTTOM NAVIGATION CODE
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        frameLayout = findViewById(R.id.frameLayout);

        if(savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment selectedFragment = null;


                switch (menuItem.getItemId()) {
                    case 1:
                        selectedFragment = new HomeFragment();
                        break;
                    case 2:
                        selectedFragment = new PointFragment();
                        break;
                    case 3:
                        selectedFragment = new OrderFragment();
                        break;
                    case 4:
                        selectedFragment = new ProfileFragment();
                        break;
                }

                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                }

                loadFragment(new HomeFragment());
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new HomeFragment());
        fragmentTransaction.commit();
    }
}