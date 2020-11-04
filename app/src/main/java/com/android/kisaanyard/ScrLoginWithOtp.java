package com.android.kisaanyard;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class ScrLoginWithOtp extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    private TextInputLayout til_otp, till_contact_number;
    private EditText et_otp, et_contact_number;


    private TextView tv_resend;
    private TextView tv_otp_timer;
    private TextView tv_loginpassword;

    private Button bt_continue,bt_generaateotp;
    private LinearLayout ll_otp_timer;
    private LinearLayout ll_otp;

    private String otp, contact_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_with_otp);
        startTimer();
        initUi();
    }


    public void initUi() {

        ll_otp_timer = findViewById(R.id.ll_otp_timer);
        ll_otp = findViewById(R.id.ll_otp);

        til_otp = findViewById(R.id.til_otp);
        till_contact_number = findViewById(R.id.till_contact_number);

        tv_loginpassword=findViewById(R.id.tv_loginpassword);

        et_otp = findViewById(R.id.et_otp);
        et_contact_number = findViewById(R.id.et_contact_number);
        et_contact_number.addTextChangedListener(this);
        tv_otp_timer = findViewById(R.id.otp_timer);
        tv_otp_timer.setOnClickListener(this);
        bt_continue = findViewById(R.id.bt_continue);
        tv_resend = findViewById(R.id.tv_resend);
        tv_resend.setOnClickListener(this);
        bt_continue.setOnClickListener(this);
        bt_generaateotp=findViewById(R.id.bt_generateotp);
        tv_loginpassword.setOnClickListener(this);
        bt_generaateotp.setOnClickListener(this);

    }

    public void validate() {
        boolean isValid = true;
        otp = et_otp.getText().toString();
        contact_number=et_contact_number.getText().toString();

        if (TextUtils.isEmpty(otp)) {
            til_otp.setError("Enter Valid Otp");
            return;
        } else {
            til_otp.setError(null);
        }




        if (otp.length() < 4) {
            til_otp.setError("Enter Valid Otp");
            isValid = false;
        } else {
            til_otp.setError(null);
        }

        if (TextUtils.isEmpty(contact_number) || contact_number.length() < 10) {
            isValid = false;
            till_contact_number.setError("Enter Mobile");

        } else {
            isValid = isValid && true;
            till_contact_number.setError(null);

        }

        if (isValid) {
            //call_verify_login_with_otp_client();
        } else {
            Log.d("TAG", "validate: " + "invalidate");

        }
    }

    public void startTimer() {
        new CountDownTimer(90000, 1000) {

            public void onTick(long millisUntilFinished) {
                tv_resend.setClickable(false);
                tv_otp_timer.setText("" + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                tv_resend.setClickable(true);
                ll_otp_timer.setVisibility(View.GONE);
            }

        }.start();
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.bt_continue:
                validate();
                break;

            case R.id.tv_resend:
                ll_otp_timer.setVisibility(View.VISIBLE);
                startTimer();
                break;

            case R.id.tv_loginpassword:
                Intent intent=new Intent(this,ScrLoginWithPassword.class);
                startActivity(intent);
                break;
            case R.id.bt_generateotp:
                ll_otp.setVisibility(View.VISIBLE);
                ll_otp_timer.setVisibility(View.VISIBLE);
                bt_generaateotp.setVisibility(View.GONE);



        }
    }



    }

