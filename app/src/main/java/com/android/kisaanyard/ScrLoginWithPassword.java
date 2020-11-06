package com.android.kisaanyard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class ScrLoginWithPassword extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {


    private EditText et_contact_number, et_password, et_email;
    private TextView tv_forgotpassword;
    private TextInputLayout till_contact_number, till_password,till_email;
    private Button bt_login;


    private String password, contact_number, email;
    private RadioGroup rg_login_type;
    private RadioButton rbt_email,rbt_mobile;
    private LinearLayout ll_email,ll_mobile;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    private String password, contact_number;
    private String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_password);

        Intent intent = getIntent();
        type = intent.getStringExtra("type");

        initUi();

        tv_forgotpassword.setOnClickListener(this);

    }


    public void initUi() {
        et_contact_number = findViewById(R.id.et_contact_number);
        et_password = findViewById(R.id.et_password);
        et_email = findViewById(R.id.et_email);
        tv_forgotpassword = findViewById(R.id.tv_forgotpassword);
        till_password = findViewById(R.id.til_password);
        till_contact_number = findViewById(R.id.till_contact_number);
        till_email = findViewById(R.id.till_email);

        bt_login = findViewById(R.id.bt_login);

    public void initUi(){

        et_contact_number=findViewById(R.id.et_contact_number);
        et_password=findViewById(R.id.et_password);
        tv_forgotpassword=findViewById(R.id.tv_forgotpassword);
        till_password=findViewById(R.id.til_password);
        till_contact_number=findViewById(R.id.till_contact_number);
        bt_login=findViewById(R.id.bt_login);

        bt_login.setOnClickListener(this);

        rg_login_type=findViewById(R.id.rg_login_type);
        rg_login_type.setOnCheckedChangeListener(this);
        rbt_email=findViewById(R.id.rbt_email);
        rbt_mobile=findViewById(R.id.rbt_mobile);

        ll_email=findViewById(R.id.ll_email);
        ll_mobile=findViewById(R.id.ll_mobile);

    }


    public void validate() {

    public void validate(){


        boolean isValid = true;
        contact_number = et_contact_number.getText().toString();
        email=et_email.getText().toString();
        password = et_password.getText().toString();

        if (rbt_mobile.isChecked())
        {
            if (contact_number.isEmpty()) {
                isValid = false;
                till_contact_number.setError("Enter Mobile");

            }else if (contact_number.length()<10){
                isValid = false;
                till_contact_number.setError("Enter Valid Mobile Number");
            }else {
                isValid = isValid && true;
                till_contact_number.setError(null);
            }

        }else {
            if (email.isEmpty())
            {
                isValid=false;
                till_email.setError("Enter Email Address");
            }else if (!email.matches(emailPattern))
            {
                isValid=false;
                till_email.setError("Enter Valid Email Address");

            }else {
                isValid=isValid && true;
                till_email.setError(null);
            }

        }
        
        if (password.isEmpty()) {
            isValid = false;
            till_password.setError("Enter Password");
        } else {

            isValid = isValid && true;
            till_password.setError(null);
        }

        if (isValid) {
            Log.d("TAG", "call login Api");
            Toast.makeText(ScrLoginWithPassword.this,"Valid",Toast.LENGTH_LONG).show();
        }

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_forgotpassword:
                Intent intent = new Intent(this, ScrForgotPassword.class);
                startActivity(intent);
                break;


            case R.id.bt_login:
                validate();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if(checkedId==R.id.rbt_email)
        {
            ll_email.setVisibility(View.VISIBLE);
            ll_mobile.setVisibility(View.GONE);
        }
        else if(checkedId==R.id.rbt_mobile)
        {
            ll_mobile.setVisibility(View.VISIBLE);
            ll_email.setVisibility(View.GONE);
        }
    }
}
