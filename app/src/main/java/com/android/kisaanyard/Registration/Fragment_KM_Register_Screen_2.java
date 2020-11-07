package com.android.kisaanyard.Registration;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.kisaanyard.R;
import com.android.kisaanyard.communication.ApiInterface;
import com.android.kisaanyard.communication.ResponseData;
import com.android.kisaanyard.communication.RetrofitBase;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_KM_Register_Screen_2 extends Fragment {

    private ApiInterface apiInterface;
    private KisaanMitarRegistrationSharedPref sharedPref;

    private AutoCompleteTextView filled_exposed_dropdown_state, filled_exposed_dropdown_working_district,
            filled_exposed_dropdown_working_taluka,filled_exposed_dropdown_working_village;

    private EditText mEdtTxtPinCode;
    private MaterialButton btnNextScreen;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.km_register_screen2, container, false);

        apiInterface = RetrofitBase.getInstance().create(ApiInterface.class);

        sharedPref = KisaanMitarRegistrationSharedPref.getInstance();

        mEdtTxtPinCode = view.findViewById(R.id.pincodeEditText);

        mEdtTxtPinCode.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                int length = s.length();
                if (length == 6) {
                    callPincodeData();
                    Log.d("TAG", "afterTextChanged: " + length);
                }else {
                    Log.d("TAG", "afterTextChanged: " + length);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        filled_exposed_dropdown_state = view.findViewById(R.id.filled_exposed_dropdown_state);
        filled_exposed_dropdown_working_district = view.findViewById(R.id.filled_exposed_dropdown_working_district);
        filled_exposed_dropdown_working_taluka = view.findViewById(R.id.filled_exposed_dropdown_working_taluka);
        filled_exposed_dropdown_working_village = view.findViewById(R.id.filled_exposed_dropdown_working_village);

        kisaanMitrScreenUi(view);
        Get_and_SetDataUsingSharedPref();

        return view;
    }


    private void kisaanMitrScreenUi(final View km_register_screen_view) {

//        final String[] States = new String[]{"Maharashtra", "Karnataka", "Bengaluru"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_menu_popup_item, States);
//        final AppCompatAutoCompleteTextView editTextFilledExposedDropdown = km_register_screen_view.findViewById(R.id.filled_exposed_dropdown_state);
//        editTextFilledExposedDropdown.setAdapter(adapter);

        btnNextScreen = km_register_screen_view.findViewById(R.id.nextButton);
        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEdtTxtPinCode.getText().toString().length() >= 6) {

                    sharedPref.setPincode(mEdtTxtPinCode.getText().toString());
                    sharedPref.setState(filled_exposed_dropdown_state.getText().toString());
                    sharedPref.setDistrict(filled_exposed_dropdown_working_district.getText().toString());
                    sharedPref.setTaluka(filled_exposed_dropdown_working_taluka.getText().toString());

                    validation();

                } else {
                    mEdtTxtPinCode.setError("Empty Or Wrong Pincode");
                }

            }
        });

    }

    public void validation() {

        if (filled_exposed_dropdown_working_village.getText().toString().equals("")) {
            filled_exposed_dropdown_working_village.setError("Please Select Village");
        }else{
            sharedPref.setVillage(filled_exposed_dropdown_working_village.getText().toString());
            ((MainActivityRegistration)getActivity()).selectIndex(2);
        }
    }

    public void callPincodeData() {

        Call<ResponseData> responseDataCall= apiInterface.PincodeApi(mEdtTxtPinCode.getText().toString());

        responseDataCall.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {

                filled_exposed_dropdown_working_village.setText("");

                Log.d("onResponsePostal", " Status: " + response.body().getStatus() +
                        " Message " + response.body().getMessage()+
                        " Post Offices "+ new Gson().toJson(response.body().getPostOffice()));

                String message = response.body().getStatus();

                if (message.equals("Success")) {

                    String state = response.body().getPostOffice().get(0).getState();
                    String district = response.body().getPostOffice().get(0).getDistrict();
                    String taluka = response.body().getPostOffice().get(0).getTaluk();

                    filled_exposed_dropdown_state.setText(state);
                    filled_exposed_dropdown_working_district.setText(district);
                    filled_exposed_dropdown_working_taluka.setText(taluka);

                    String[] items = new String[response.body().getPostOffice().size()];


                    for (int i = 0; i < response.body().getPostOffice().size(); i++) {

                        items[i] = response.body().getPostOffice().get(i).getName();
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_menu_popup_item, items);
                        filled_exposed_dropdown_working_village.setAdapter(adapter);

                    }


                }else {
                    Toast.makeText(getContext(),"No records found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.d("onResponsePostal",t.toString());

            }
        });

    }



    private void Get_and_SetDataUsingSharedPref() {

        String pincode =  sharedPref.getPincode();
        String state =  sharedPref.getState();
        String district =  sharedPref.getDistrict();
        String taluka =  sharedPref.getTaluka();
        String village =  sharedPref.getVillage();

        Log.d("TAG", "getDataUsingSharedPref: " + pincode + " " + state + " "+district+" "+taluka+" "+village);

        if (pincode != null) {
            mEdtTxtPinCode.setText(pincode);
        }
        if (state != null) {
            filled_exposed_dropdown_state.setText(state);
        }
        if (district != null) {
            filled_exposed_dropdown_working_district.setText(district);
        }
        if (taluka != null) {
            filled_exposed_dropdown_working_taluka.setText(taluka);
        }
        if (village != null) {
            filled_exposed_dropdown_working_village.setText(village);
        }

    }


}
