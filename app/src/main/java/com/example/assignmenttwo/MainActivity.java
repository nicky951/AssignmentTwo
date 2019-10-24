package com.example.assignmenttwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set BottomNavigation View
        BottomNavigationView bottomNavigationView = findViewById(R.id.navbar);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        //Logic to switch between Fragments using Bottom Naviation Bar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Source Code/Inspiration: https://stackoverflow.com/questions/44424985/switch-between-fragments-in-bottomnavigationview
                Fragment currentSelected = null;

                switch (menuItem.getItemId()){
                    case R.id.menunav:
                        currentSelected = Menu.Menu();
                        break;

                    case R.id.ordernav:
                        currentSelected = Order.Order();
                        break;
                }

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainframe, currentSelected);
                fragmentTransaction.commit();

                return true;
            }
        });

        Menu.Menu();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainframe, Menu.Menu());
        fragmentTransaction.commit();
    }
}

