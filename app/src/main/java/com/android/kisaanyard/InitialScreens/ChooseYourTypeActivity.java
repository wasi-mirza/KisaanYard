package com.android.kisaanyard.InitialScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.kisaanyard.R;
import com.android.kisaanyard.Registration.MainActivityRegistration;
import com.android.kisaanyard.ScrLoginWithOtp;
import com.android.kisaanyard.ScrLoginWithPassword;

public class ChooseYourTypeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login_using_otp, btn_login_using_password, bt_register;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RadioButton radioButtonKM, radioButtonDM, radioButtonTM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_type);

        initUi();
    }


    public void initUi() {

        bt_register = findViewById(R.id.bt_register);
        btn_login_using_otp = findViewById(R.id.btn_login_using_otp);
        btn_login_using_password = findViewById(R.id.btn_login_using_password);

        bt_register.setEnabled(false);
        btn_login_using_otp.setEnabled(false);
        btn_login_using_password.setEnabled(false);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        bt_register.setOnClickListener(this);
        btn_login_using_otp.setOnClickListener(this);
        btn_login_using_password.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton) group.findViewById(checkedId);
                if (null != radioButton && checkedId > -1) {

                    bt_register.setEnabled(true);
                    btn_login_using_otp.setEnabled(true);
                    btn_login_using_password.setEnabled(true);

                }

            }
        });


    }

    public void onSubmit(View v) {
        radioButton = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        Toast.makeText(ChooseYourTypeActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_login_using_password:
                Intent intent = new Intent(this, ScrLoginWithPassword.class);
                intent.putExtra("type", radioButton.getText());
                startActivity(intent);
                break;

            case R.id.btn_login_using_otp:
                Intent intent1 = new Intent(this, ScrLoginWithOtp.class);
                intent1.putExtra("type", radioButton.getText());
                startActivity(intent1);
                break;

            case R.id.bt_register:
                Intent intentRegister = new Intent(this, MainActivityRegistration.class);
                intentRegister.putExtra("type", radioButton.getText());
                startActivity(intentRegister);
                break;


        }
    }


}

