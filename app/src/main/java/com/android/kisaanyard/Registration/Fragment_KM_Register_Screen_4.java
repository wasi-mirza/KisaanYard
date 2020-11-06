package com.android.kisaanyard.Registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.kisaanyard.R;

public class Fragment_KM_Register_Screen_4 extends Fragment {

    private AutoCompleteTextView basicComputerKnowledgeDropDown,twoWheelerDropDown,smartPhoneDropDown,laptopDropDown;

    private EditText mEdtMobileNumber,mEdtSetYourPassword,mEdtYourEducation,mEdtCurrentJobDetail,mEdtAnnualIncome,mEdtExperienceInYear;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.km_register_screen4, container, false);

        kisaanMitrScreenUi(view);

        return view;
    }


    private void kisaanMitrScreenUi(View km_register_screen_view) {

        mEdtMobileNumber = km_register_screen_view.findViewById(R.id.mobileNumberEditText);
        mEdtSetYourPassword = km_register_screen_view.findViewById(R.id.setYourPasswordEditText);
        mEdtYourEducation = km_register_screen_view.findViewById(R.id.yourEducationEditText);
        mEdtCurrentJobDetail = km_register_screen_view.findViewById(R.id.currentJobDetailEditText);
        mEdtAnnualIncome = km_register_screen_view.findViewById(R.id.annualIncomeEditText);
        mEdtExperienceInYear = km_register_screen_view.findViewById(R.id.experienceInYearEditText);


        basicComputerKnowledgeDropDown = km_register_screen_view.findViewById(R.id.basicComputerKnowledgeDropDown);
        twoWheelerDropDown = km_register_screen_view.findViewById(R.id.twoWheelerDropDown);
        smartPhoneDropDown = km_register_screen_view.findViewById(R.id.smartPhoneDropDown);
        laptopDropDown = km_register_screen_view.findViewById(R.id.laptopDropDown);

        String[] YesOrNo = new String[]{"Yes", "No"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>( getActivity() , R.layout.dropdown_menu_popup_item, YesOrNo);

        basicComputerKnowledgeDropDown.setAdapter(adapter);
        twoWheelerDropDown.setAdapter(adapter);
        smartPhoneDropDown.setAdapter(adapter);
        laptopDropDown.setAdapter(adapter);
    }


}
