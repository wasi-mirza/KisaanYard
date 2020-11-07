package com.android.kisaanyard.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.android.kisaanyard.R;
import com.android.kisaanyard.Storage.KisaanMitarRegistrationSharedPref;
import com.google.android.material.tabs.TabLayout;

public class MainActivityRegistration extends AppCompatActivity {

    private KisaanMitarRegistrationSharedPref sharedPref;
    CustomViewPager viewPager;
    private String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_wasi_main);

        sharedPref = KisaanMitarRegistrationSharedPref.getInstance();

        Intent intent = getIntent();
        type = intent.getStringExtra("type");

        sharedPref.setType(type);

        this.setTitle("Register as " + type);


        viewPager = (CustomViewPager) findViewById(R.id.viewpagerRegistration);
        viewPager.setAdapter(new SimpleFragmentPagerTabbedAdapter(getSupportFragmentManager(), this));
        viewPager.setCurrentItem(0);
        viewPager.setPagingEnabled(false);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayoutRegistration);
        tabLayout.setupWithViewPager(viewPager, true);

    }

    public void selectIndex(int newIndex) {
        viewPager.setCurrentItem(newIndex);
    }


    @Override
    public void onBackPressed() {
        int currentPosition = viewPager.getCurrentItem();

        if (currentPosition == 1) {
            viewPager.setCurrentItem(0);
        } else if (currentPosition == 2) {
            viewPager.setCurrentItem(1);
        } else if (currentPosition == 3) {
            viewPager.setCurrentItem(2);
        } else {
            super.onBackPressed();
        }
    }


}