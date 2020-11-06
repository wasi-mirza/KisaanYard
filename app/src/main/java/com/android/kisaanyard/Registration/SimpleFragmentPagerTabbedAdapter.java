package com.android.kisaanyard.Registration;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.android.kisaanyard.R;

public class SimpleFragmentPagerTabbedAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerTabbedAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new Fragment_KM_Register_Screen_1();
        } else if (position == 1) {
            return new Fragment_KM_Register_Screen_2();
        } else if (position == 2) {
            return new Fragment_KM_Register_Screen_3();
        } else {
            return new Fragment_KM_Register_Screen_4();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ViewPagerHomeObject customPagerEnum = ViewPagerHomeObject.values()[position];
        return mContext.getString(customPagerEnum.getTitleResId());
    }


    public enum ViewPagerHomeObject {

        LEFT(R.string.general_information, R.layout.km_register_screen1),
        MAIN(R.string.operational_area, R.layout.km_register_screen2),
        RIGHT(R.string.permanent_address, R.layout.km_register_screen3),
        UP(R.string.kisaan_mitr_info, R.layout.km_register_screen4);
        /*
        RIGHT(R.string.table_quiz_question, R.layout.fragment_tq_family_quiz_type),
        UP(R.string.family_quiz_question,R.layout.fragment_tq_family_quiz_type);*/

        private int mTitleResId;
        private int mLayoutResId;

        ViewPagerHomeObject(int titleResId, int layoutResId) {
            mTitleResId = titleResId;
            mLayoutResId = layoutResId;
        }

        public int getTitleResId() {
            return mTitleResId;
        }

        public int getLayoutResId() {
            return mLayoutResId;
        }

    }

}

