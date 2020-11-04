package com.android.kisaanyard;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ScrUpdateProfile extends AppCompatActivity {

    private AutoCompleteTextView textView,textViewDistrict,textViewTaluka;
    ImageView iv_state,iv_taluka,iv_district;
    private static final String[] fruits = {"bggg","vhh","gjj"};
    private static final String[] district = {"bggg","vhh","gjj"};

    private static final String[] taluka = {"bggg","vhh","gjj"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textView=findViewById(R.id.auto_state);
        textViewDistrict=findViewById(R.id.auto_district);

        textViewTaluka=findViewById(R.id.auto_taluka);

        iv_state=findViewById(R.id.iv_state);
        iv_district=findViewById(R.id.iv_district);

        iv_taluka=findViewById(R.id.iv_taluka);




        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits);
        textView.setThreshold(1); //will start working from first character
        textView.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, taluka);
        textView.setThreshold(1); //will start working from first character
        textView.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, district);
        textView.setThreshold(1); //will start working from first character
        textView.setAdapter(adapter2);

        iv_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.showDropDown();
            }
        });


        iv_taluka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewTaluka.showDropDown();
            }
        });


        iv_district.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewDistrict.showDropDown();
            }
        });

        initToolbarUi();

    }


    private void initToolbarUi() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.def_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Update Profile");//getResources().getString(R.string.register)
    }

}