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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.kisaanyard.Registration.MainActivityRegistration;
import com.google.android.material.textfield.TextInputLayout;

public class ScrLoginWithOtp extends AppCompatActivity implements View.OnClickListener, TextWatcher, RadioGroup.OnCheckedChangeListener {
    private TextInputLayout til_otp, till_contact_number,till_email;
    private EditText et_otp, et_contact_number,et_email;
    private TextView tv_resend;
    private TextView tv_otp_timer;
    private Button bt_continue, bt_generaateotp;
    private LinearLayout ll_otp_timer;
    private LinearLayout ll_otp;
    private LinearLayout ll_email,ll_mobile;
    private RadioGroup radioGroup,rg_login_type;
    private RadioButton rbt_email,rbt_mobile;

    private String otp, contact_number,type,email;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



    private String otp, contact_number;

    private String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_with_otp);



        Intent intent = getIntent();
        type = intent.getStringExtra("type");

        startTimer();

        initUi();
    }

    public void initUi() {

        ll_otp_timer = findViewById(R.id.ll_otp_timer);
        ll_otp = findViewById(R.id.ll_otp);

        til_otp = findViewById(R.id.til_otp);
        till_contact_number = findViewById(R.id.till_contact_number);
        till_email = findViewById(R.id.till_email);

        et_otp = findViewById(R.id.et_otp);
        et_contact_number = findViewById(R.id.et_contact_number);
        et_contact_number.addTextChangedListener(this);

        et_email=findViewById(R.id.et_email);
        et_email.addTextChangedListener(this);

        tv_otp_timer = findViewById(R.id.otp_timer);
        tv_otp_timer.setOnClickListener(this);


        bt_continue = findViewById(R.id.bt_continue);


        tv_resend = findViewById(R.id.tv_resend);


        tv_resend.setOnClickListener(this);

        bt_continue = findViewById(R.id.bt_continue);
        bt_continue.setOnClickListener(this);


        bt_generaateotp = findViewById(R.id.bt_generateotp);


        bt_generaateotp=findViewById(R.id.bt_generateotp);
        tv_loginpassword.setOnClickListener(this);

        bt_generaateotp.setOnClickListener(this);

       // radioGroup=findViewById(R.id.radiogroup);
        bt_generaateotp.setClickable(false);

        rg_login_type=findViewById(R.id.rg_login_type);
        rg_login_type.setOnCheckedChangeListener(this);
        rbt_email=findViewById(R.id.rbt_email);
        rbt_mobile=findViewById(R.id.rbt_mobile);

        ll_email=findViewById(R.id.ll_email);
        ll_mobile=findViewById(R.id.ll_mobile);
    }

    public void validateMobile()
    {
        boolean isValid = true;
        contact_number = et_contact_number.getText().toString();
        email=et_email.getText().toString();

        if (contact_number.isEmpty()) {
            isValid = false;
            till_contact_number.setError("Enter Mobile Number");
        } else if (contact_number.length() < 10) {
            isValid = false;
            till_contact_number.setError("Please enter Valid Mobile Number");
        } else {
            isValid = isValid && true;
            till_contact_number.setError(null);
        }

        /*if(radioGroup.getCheckedRadioButtonId()==-1)
        {
            isValid=false;
            Toast.makeText(ScrLoginWithOtp.this, "Please select Type", Toast.LENGTH_SHORT).show();
        }
        else
        {
           isValid=isValid && true;
           getType();
        }*/

        if (isValid)
        {
            ll_otp.setVisibility(View.VISIBLE);
            bt_generaateotp.setVisibility(View.GONE);
        }


    }

    public void validateEmail()
    {
        boolean isValid = true;
        email=et_email.getText().toString();

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

        if (isValid)
        {
            ll_otp.setVisibility(View.VISIBLE);
            bt_generaateotp.setVisibility(View.GONE);
        }



    }

    public void validateOtp() {
        boolean isValid = true;
        otp = et_otp.getText().toString();

        if (otp.isEmpty()) {
            isValid = false;
            til_otp.setError("Enter OTP");
        } else if (otp.length() < 4) {
            isValid = false;
            til_otp.setError("Please enter Valid OTP");
        } else {
            isValid = isValid && true;
            til_otp.setError(null);
        }

        if (isValid) {
            Log.d("TAG","call check otp");
        }


    }

    public void getType()
    {
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(id);
        type = radioButton.getText().toString();
    }

    public void startTimer() {
        new CountDownTimer(90000, 1000) {

            public void onTick(long millisUntilFinished) {
                tv_resend.setClickable(false);
                tv_otp_timer.setText("" + millisUntilFinished / 1000);
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
        bt_generaateotp.setAlpha(1);
        bt_generaateotp.setClickable(true);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_generateotp:
                if (rbt_email.isChecked())
                {
                    validateEmail();
                }else {
                    validateMobile();
                }

                break;

            case R.id.bt_continue:
                validateOtp();
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

