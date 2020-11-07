package com.android.kisaanyard.general;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.kisaanyard.R;
import com.bumptech.glide.Glide;

public class ImageViewSingleActivity extends AppCompatActivity {

    String image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.imageview_single_activity);

        Intent intent = getIntent();
        image = intent.getStringExtra("image");

        TouchImageView imgflag1 = new TouchImageView(this);
        imgflag1.setMaxZoom(6f);
        setContentView(imgflag1);

/*        byte[] array = Base64.decode(UserSharedPref.getInstance().getImage(), Base64.DEFAULT);
        Bitmap bmp = BitmapFactory.decodeByteArray(array, 0, array.length);*/

        Glide.with(this).load(image).into(imgflag1);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
