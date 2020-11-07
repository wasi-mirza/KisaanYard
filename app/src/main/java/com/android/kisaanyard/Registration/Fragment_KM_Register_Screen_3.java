package com.android.kisaanyard.Registration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.android.kisaanyard.R;
import com.android.kisaanyard.Storage.KisaanMitarRegistrationSharedPref;
import com.android.kisaanyard.communication.ApiInterface;
import com.android.kisaanyard.communication.ResponseData;
import com.android.kisaanyard.communication.RetrofitBase;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_KM_Register_Screen_3 extends Fragment {

    public static final int PICK_IMAGE = 1;

    private ApiInterface apiInterface;
    private AutoCompleteTextView filled_exposed_dropdown_state, filled_exposed_dropdown_working_district,
            filled_exposed_dropdown_working_taluka, filled_exposed_dropdown_working_village, filled_exposed_dropdown_photo_id_type;

    private EditText mEdtTxtPinCode,mEdtUploadScannedCopy,mEdtStreetAddress,mEdtIDnumberSelectedIdType;
    private KisaanMitarRegistrationSharedPref sharedPref;
    private MaterialButton btnNextScreen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.km_register_screen3, container, false);

        sharedPref = KisaanMitarRegistrationSharedPref.getInstance();

        apiInterface = RetrofitBase.getInstance().create(ApiInterface.class);

        mEdtTxtPinCode = view.findViewById(R.id.pincodeEditText);
        mEdtStreetAddress = view.findViewById(R.id.streetAddressEditText);
        mEdtIDnumberSelectedIdType = view.findViewById(R.id.idNumberOfSelectedEditText);
        mEdtUploadScannedCopy = view.findViewById(R.id.uploadScannedCopyIDProof);




        mEdtUploadScannedCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Upload Scanned ID Proof"), PICK_IMAGE);
            }
        });


        mEdtTxtPinCode.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                int length = s.length();
                if (length == 6) {
                    callPincodeData();
                    Log.d("TAG", "afterTextChanged: " + length);
                } else {
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
        filled_exposed_dropdown_photo_id_type = view.findViewById(R.id.filled_exposed_dropdown_photo_id_type);

        final String[] Photo_IDs = new String[]{"Aadhar Card", "Pancard", "License", "Ration Card"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_menu_popup_item, Photo_IDs);
        filled_exposed_dropdown_photo_id_type.setAdapter(adapter);


        btnNextScreen = view.findViewById(R.id.nextButton);
        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivityRegistration) getActivity()).selectIndex(3);
            }
        });

        return view;
    }


    public void callPincodeData() {

        Call<ResponseData> responseDataCall = apiInterface.PincodeApi(mEdtTxtPinCode.getText().toString());

        responseDataCall.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {

                filled_exposed_dropdown_working_village.setText("");

                Log.d("onResponsePostal", " Status: " + response.body().getStatus() +
                        " Message " + response.body().getMessage() +
                        " Post Offices " + new Gson().toJson(response.body().getPostOffice()));

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


                } else {
                    Toast.makeText(getContext(), "No records found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.d("onResponsePostal", t.toString());

            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE) {
            //TODO: action
            try {
                if(data!=null)
                { // user selects some Image

                    Uri filePath = data.getData();

                    String filename = filePath.getLastPathSegment();

                    File file = new File(filename);
                    String strFileName = file.getName();

                    mEdtUploadScannedCopy.setText(strFileName);


                    if (filePath != null) {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
//                        pro_img.setImageBitmap(bitmap);
//                        img = getEncoded64ImageStringFromBitmap(bitmap);
                    }
                }
                else
                {
                    // user simply backpressed from gallery
                    Toast.makeText(getContext(), "No Image Selected", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    private void Get_and_SetDataUsingSharedPref() {
/*

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
*/

    }

}
