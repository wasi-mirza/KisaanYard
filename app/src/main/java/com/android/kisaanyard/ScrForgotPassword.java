package com.android.kisaanyard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ScrForgotPassword extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout till_password,till_confirm_password;
    private TextInputEditText et_password,et_confirm_password;
    private Button bt_set_password;
    private String password,confirm_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initUi();


    }
    public void initUi(){
        till_password=findViewById(R.id.til_password);
        till_confirm_password=findViewById(R.id.til_confirm_password);
        et_password=findViewById(R.id.et_password);
        et_confirm_password=findViewById(R.id.et_confirm_password);
        bt_set_password=findViewById(R.id.bt_set_password);
        bt_set_password.setOnClickListener(this);
    }

    public void validate(){
        password=et_password.getText().toString();
        confirm_password=et_confirm_password.getText().toString();
        boolean isValid=true;
        if(password.isEmpty()){
            isValid=false;
            till_password.setError("Enter Password");
        }else {
            isValid=false && true;
            till_password.setError(null);
        }


        if(confirm_password.isEmpty()){
            isValid=false;
            till_confirm_password.setError("Enter Confirm Password");
        }else {
            isValid=false && true;
            till_confirm_password.setError(null);
        }

        if(isValid)
        {
            Log.d("TAG","call api");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_set_password:
                validate();
        }
    }
}
