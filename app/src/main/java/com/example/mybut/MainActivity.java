package com.example.mybut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mybut.fragment.CalendarFragment;
import com.example.mybut.fragment.HomeFragment;
import com.example.mybut.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    CalendarFragment calendarFragment = new CalendarFragment();
    SettingFragment settingFragment = new SettingFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnavigation);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setBackground(null);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, homeFragment).commit();
                item.setChecked(true);
                return true;

            case  R.id.calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, calendarFragment).commit();
                item.setChecked(true);
                return true;

            case  R.id.setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, settingFragment).commit();
                item.setChecked(true);
                return  true;
        }

        return false;
    }
}