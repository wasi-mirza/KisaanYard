package com.android.kisaanyard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

public class ScrRegistration extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout till_dob,till_whtsappno,til_aboutyourself,till_pin_code,till_address;
    private EditText et_dob,et_whtsappno,et_aboutyourself,et_pin_code;
    private MultiAutoCompleteTextView address;

    private Button bt_register;
    private TextInputLayout till_state,till_taluka,till_district;
    private AutoCompleteTextView auto_state,auto_district,auto_taluka;
    private static final String[] fruits = {"bggg","vhh","gjj"};
    private static final String[] district = {"bggg","vhh","gjj"};

    private static final String[] taluka = {"bggg","vhh","gjj"};

    private String dob,whtsappno,abtyourself,pincode,addr,state,talukaa,districtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regitrtionnn);
            initUi();
            initToolbarUi();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, fruits);
        auto_state.setThreshold(1); //will start working from first character
        auto_state.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, taluka);
        auto_district.setThreshold(1); //will start working from first character
        auto_district.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, district);
        auto_taluka.setThreshold(1); //will start working from first character
        auto_taluka.setAdapter(adapter2);

    }

    public void initUi(){
        till_state=findViewById(R.id.till_state);
        till_taluka=findViewById(R.id.till_taluka);
        till_district=findViewById(R.id.till_district);


        auto_state=findViewById(R.id.auto_state);
        auto_district=findViewById(R.id.auto_district);
        auto_taluka=findViewById(R.id.auto_taluka);

        till_dob=findViewById(R.id.till_dob);
        till_whtsappno=findViewById(R.id.till_whtsappno);
        til_aboutyourself=findViewById(R.id.til_aboutyourself);
        till_pin_code=findViewById(R.id.till_pin_code);
        till_address=findViewById(R.id.till_address);


        et_dob=findViewById(R.id.et_dob);
        et_whtsappno=findViewById(R.id.et_whtsappno);
        et_aboutyourself=findViewById(R.id.et_aboutyourself);
        et_pin_code=findViewById(R.id.et_pin_code);
        address=findViewById(R.id.address);


        bt_register=findViewById(R.id.bt_register);
        bt_register.setOnClickListener(this);

    }


    public void validate() {
        boolean isValid = false;
        dob = et_dob.getText().toString();
        whtsappno = et_whtsappno.getText().toString();
        abtyourself = et_aboutyourself.getText().toString();
        pincode = et_pin_code.getText().toString();
       state =auto_state.getText().toString();
        talukaa =auto_taluka.getText().toString();
        districtt =auto_district.getText().toString();

         addr=address.getText().toString();


        if (whtsappno.isEmpty() || whtsappno.length() < 10) {
            isValid = false;
            till_whtsappno.setError("enter 10 digit number");

        } else {
            isValid = isValid && true;
            till_whtsappno.setError(null);
        }
        if (TextUtils.isEmpty(abtyourself)) {
            isValid = false;
            til_aboutyourself.setError("Enter the details");
        } else {
            isValid = isValid && true;
            til_aboutyourself.setError(null);

        }


        if (TextUtils.isEmpty(pincode)) {
            isValid = false;
            till_pin_code.setError("Enter the pincode");
        } else {
            isValid = isValid && true;
            till_pin_code.setError(null);

        }


        if (TextUtils.isEmpty(dob)) {
            isValid = false;
            till_dob.setError("Enter the dob");
        } else {
            isValid = isValid && true;
            till_dob.setError(null);

        }

        if (TextUtils.isEmpty(state)) {
            isValid = false;
            till_state.setError("select the state");
        } else {
            isValid = isValid && true;
            till_state.setError(null);

        }



        if (TextUtils.isEmpty(talukaa)) {
            isValid = false;
            till_taluka.setError("select the taluka");
        } else {
            isValid = isValid && true;
            till_taluka.setError(null);

        }


        if (TextUtils.isEmpty(districtt)) {
            isValid = false;
            till_district.setError("select the district");
        } else {
            isValid = isValid && true;
            till_district.setError(null);

        }


      /*  if (address.isEmpty()) {
           till_address .setError("Enter atleast one city");
            isValid = isValid && false;
        } else {
            till_address.setError(null);
            isValid = isValid && true;
        }*/
    }

    private void initToolbarUi() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.def_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Register");//getResources().getString(R.string.register)
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_register:
                validate();
        }

    }
}