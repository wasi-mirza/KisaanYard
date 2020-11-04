package com.android.kisaanyard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ScrEditProfileCard extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout till_dob,till_whtsappno,til_aboutyourself,till_pin_code,till_address;
    private EditText et_dob,et_whtsappno,et_aboutyourself,et_pin_code;
    private MultiAutoCompleteTextView address;
    private Button bt_update;

    private String dob,whtsappno,abtyourself,pincode,addr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_card);

       /* getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/
        initUi();
        initToolbarUi();
    }

    public void  initUi(){
        till_dob=findViewById(R.id.till_dob);
        till_whtsappno=findViewById(R.id.till_whtsappno);
        til_aboutyourself=findViewById(R.id.til_aboutyourself);
        till_pin_code=findViewById(R.id.till_pin_code);
        till_address=findViewById(R.id.till_pin_code);


        et_dob=findViewById(R.id.et_dob);
        et_whtsappno=findViewById(R.id.et_whtsappno);
        et_aboutyourself=findViewById(R.id.et_aboutyourself);
        et_pin_code=findViewById(R.id.et_pin_code);

        address=findViewById(R.id.address);
        bt_update=findViewById(R.id.bt_update);
        bt_update.setOnClickListener(this);
    }

    public void validate(){
        boolean isValid=false;
        dob=et_dob.getText().toString();
        whtsappno=et_whtsappno.getText().toString();
        abtyourself=et_aboutyourself.getText().toString();
        pincode=et_pin_code.getText().toString();
        addr=address.getText().toString();


        if(whtsappno.isEmpty()||whtsappno.length()<10){
            isValid=false;
            till_whtsappno.setError("enter 10 digit number");

        }else {
            isValid=isValid && true;
            till_whtsappno.setError(null);
        }

        if(TextUtils.isEmpty(abtyourself)){
            isValid=false;
            til_aboutyourself.setError("Enter the details");
        }
        else {
            isValid=isValid && true;
            til_aboutyourself.setError(null);

        }


        if(TextUtils.isEmpty(pincode)){
            isValid=false;
            till_pin_code.setError("Enter the pincode");
        }
        else {
            isValid=isValid && true;
            till_pin_code.setError(null);

        }


        if (addr.isEmpty()) {
            isValid=false;
            till_address.setError("Enter addreass");

        } else {
            isValid = isValid && true;
            till_address.setError(null);

        }
       /* if(TextUtils.isEmpty(addr)){
            isValid=false;
            till_address.setError("Enter the pincode");
        }
        else {
            isValid=isValid && true;
            till_address.setError(null);

        }*/
    }

    private void initToolbarUi() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.def_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Update Profile");//getResources().getString(R.string.register)
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.bt_update:
                validate();
                break;
        }
    }
}