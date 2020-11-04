package com.android.kisaanyard;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ScrCardView extends AppCompatActivity {

    private TextInputLayout till_pincode,till_dob,till_whtsappnumber,till_about_your_self,till_address;
    private TextInputEditText et_pincode,et_dob,et_whtsappnumber,et_about_your_self,et_address;
    private Button bt_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        initUi();
        initToolbarUi();
    }

    public void initUi(){

        till_pincode=findViewById(R.id.till_pincode);
        till_dob=findViewById(R.id.till_dob);
        till_whtsappnumber=findViewById(R.id.till_whtsappnumber);
        till_about_your_self=findViewById(R.id.till_about_your_self);
        till_address=findViewById(R.id.till_address);

        et_pincode=findViewById(R.id.et_pincode);
        et_dob=findViewById(R.id.et_dob);
        et_whtsappnumber=findViewById(R.id.et_whtsappnumber);
        et_about_your_self=findViewById(R.id.et_about_your_self);
        et_address=findViewById(R.id.et_address);

        bt_update=findViewById(R.id.bt_update);
    }


    private void initToolbarUi() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.def_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Profile");//getResources().getString(R.string.register)
    }
}
