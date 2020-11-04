package com.android.kisaanyard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class ScrLoginWithPassword extends AppCompatActivity implements View.OnClickListener {


    private EditText et_contact_number,et_password;
    private TextView tv_forgotpassword;
    private TextInputLayout till_contact_number,till_password;
    private Button bt_login;

    private String password, contact_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_password);
        initUi();
        tv_forgotpassword.setOnClickListener(this);

    }

    public void initUi(){
        et_contact_number=findViewById(R.id.et_contact_number);
        et_password=findViewById(R.id.et_password);
        tv_forgotpassword=findViewById(R.id.tv_forgotpassword);
        till_password=findViewById(R.id.til_password);
        till_contact_number=findViewById(R.id.till_contact_number);
        bt_login=findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
    }

    public void validate(){
        boolean isValid = true;
        contact_number=et_contact_number.getText().toString();
        password=et_password.getText().toString();

        if (TextUtils.isEmpty(contact_number) || contact_number.length() < 10) {
            isValid = false;
            till_contact_number.setError("Enter Mobile");

        } else {
            isValid = isValid && true;
            till_contact_number.setError(null);

        }

        if(password.isEmpty()){
            isValid=false;
            till_password.setError("Enter Password");
        }else {

            isValid=isValid && true;
            till_password.setError(null);
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_forgotpassword:
                Intent intent =new Intent(this,ScrForgotPassword.class);
                startActivity(intent);
                break;


            case R.id.bt_login:
                    validate();
                break;
        }
    }
}
