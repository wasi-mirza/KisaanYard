package com.android.kisaanyard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d("TAG", "onCreate: " + "HELLO WORLD");

        showToast(this, "This is the New Changes after creating Fix");

    }

    @SuppressLint("ShowToast")
    private void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT);
    }
}