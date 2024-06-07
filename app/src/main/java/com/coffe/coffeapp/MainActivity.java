package com.coffe.coffeapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

//    BOTTOM NAVIGATION CODE
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        BOTTOM NAVIGATION CODE
        bottomNavigationView = findViewById(R.id.bottomNav);
        frameLayout = findViewById(R.id.frameLayout);
        loadFragment(new HomeFragment(), true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();

                if (itemId == R.id.navHome) {
                    loadFragment(new HomeFragment(), false);
                    return true;
                } else if (itemId == R.id.navPoint) {
                    loadFragment(new PointFragment(), false);
                    return true;
                } else if (itemId == R.id.navOrder) {
                    loadFragment(new OrderFragment(), false);
                    return  true;
                } else if (itemId == R.id.navProfile) {
                    loadFragment(new ProfileFragment(), false);
                    return true;
                }

                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (isAppInitialized) {
            fragmentTransaction.add(R.id.frameLayout, fragment);
        } else {
            fragmentTransaction.add(R.id.frameLayout, fragment);
        }

        fragmentTransaction.commit();
    }
}