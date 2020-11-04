package com.android.kisaanyard.Model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class HomeModel {


    private int profileimg;
    String title;


    public HomeModel(int profileimg, String title) {
        this.profileimg = profileimg;
        this.title = title;
    }

    public int getProfileimg() {
        return profileimg;
    }

    public void setProfileimg(int profileimg) {
        this.profileimg = profileimg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

