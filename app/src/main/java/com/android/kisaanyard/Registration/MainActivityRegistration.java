package com.android.kisaanyard.Registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.kisaanyard.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivityRegistration extends AppCompatActivity {
    CustomViewPager viewPager;
    private String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_wasi_main);


        Intent intent = getIntent();
        type = intent.getStringExtra("type");

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