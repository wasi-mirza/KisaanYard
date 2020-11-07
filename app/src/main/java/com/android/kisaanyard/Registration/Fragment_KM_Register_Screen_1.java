package com.android.kisaanyard.Registration;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import com.android.kisaanyard.R;
import com.android.kisaanyard.Storage.DatabaseHelperRegister;
import com.android.kisaanyard.Storage.KisaanMitarRegistrationSharedPref;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.fragment.app.Fragment;

public class Fragment_KM_Register_Screen_1  extends Fragment {

    private KisaanMitarRegistrationSharedPref sharedPref;

    private TextInputEditText mEdtFullName,mEdtWhatsappNumber,mEdtContactNumber,mEdtEmailAddress,mEdtBirthdate,mEdtProfilePhoto,mEdtSomethingAbout;
    private MaterialButton chooseFileButton,btnNextScreen1;
    private AppCompatAutoCompleteTextView editTextFilledExposedDropdown;

    private DatabaseHelperRegister dbHelperRegister;

    private Uri filePath;
    public static final int PICK_IMAGE = 1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.km_register_screen1, container, false);

        sharedPref = KisaanMitarRegistrationSharedPref.getInstance();
        dbHelperRegister = new DatabaseHelperRegister(getContext());

        kisaanMitrScreenUi(view);
        generalInformationInit(view);
        Get_and_SetDataUsingSharedPref();


        return view;
    }

    private void kisaanMitrScreenUi(View km_register_screen_view) {

        String[] Gender = new String[]{"Male", "Female", "Other"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_menu_popup_item, Gender);

        editTextFilledExposedDropdown = km_register_screen_view.findViewById(R.id.filled_exposed_dropdown_gender);
        editTextFilledExposedDropdown.setAdapter(adapter);


    }

    private void generalInformationInit(final View view) {


        mEdtFullName = view.findViewById(R.id.fullNameEditText);
        mEdtWhatsappNumber = view.findViewById(R.id.whatsAppNumberEditText);
        mEdtContactNumber = view.findViewById(R.id.contactNumberEditText);
        mEdtEmailAddress = view.findViewById(R.id.emailAddressEditText);
        mEdtBirthdate = view.findViewById(R.id.dateOfBirthEditText);
        mEdtProfilePhoto = view.findViewById(R.id.uploadProfilePhotoPathEditText);
        mEdtSomethingAbout = view.findViewById(R.id.writeSomethingAboutEditText);
        chooseFileButton = view.findViewById(R.id.chooseFileButton);
        btnNextScreen1 = view.findViewById(R.id.nextButton);

        //FUNCTIONALITIES:

        final Calendar myCalendar = Calendar.getInstance();


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(myCalendar);
            }

        };

        mEdtBirthdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        chooseFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Profile Picture"), PICK_IMAGE);
            }
        });

        btnNextScreen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = mEdtFullName.getText().toString();
                String whatsapp = mEdtWhatsappNumber.getText().toString();
                String contact = mEdtContactNumber.getText().toString();
                String email = mEdtEmailAddress.getText().toString();
                String dob = mEdtBirthdate.getText().toString();
                String gender = editTextFilledExposedDropdown.getText().toString();
                String somethingAbout = mEdtSomethingAbout.getText().toString();

                if (filePath != null) {

                    sharedPref.setName(name);
                    sharedPref.setWhatsappNumber(whatsapp);
                    sharedPref.setMobile(contact);
                    sharedPref.setEmail(email);
                    sharedPref.setDOB(dob);
                    sharedPref.setGender(gender);
                    sharedPref.setSaySomethingAbout(somethingAbout);

                    ((MainActivityRegistration)getActivity()).selectIndex(1);

                }else{
                    Toast.makeText(getContext(), "Please Upload a Profile Picture Again", Toast.LENGTH_LONG).show();
                }



            }
        });

    }



    private void Get_and_SetDataUsingSharedPref() {

       String name =  sharedPref.getName();
       String whatsappNumber =  sharedPref.getWhatsappNumber();
       String mobile =  sharedPref.getMobile();
       String email =  sharedPref.getEmail();
       String dob =  sharedPref.getDOB();
       String gender =  sharedPref.getGender();
       String profile_photo =  sharedPref.getProfileImage();
       String something_about =  sharedPref.getSaySomethingAbout();

        Log.d("", "getDataUsingSharedPrefGeneral: " + name + " " + whatsappNumber + " "+mobile+" "+email+" "+dob+" "+gender+" "+profile_photo+" "+something_about);

        if (name != null) {
            mEdtFullName.setText(name);
        }

        if (whatsappNumber != null) {
            mEdtWhatsappNumber.setText(whatsappNumber);
        }

        if (mobile != null) {
            mEdtContactNumber.setText(mobile);
        }
        if (email != null) {
            mEdtEmailAddress.setText(email);
        }
        if (dob != null) {
            mEdtBirthdate.setText(dob);
        }
        if (gender != null) {
            editTextFilledExposedDropdown.setText(gender);
        }

        if (something_about != null) {
            mEdtSomethingAbout.setText(something_about);
        }



    }

    private void updateLabel(Calendar myCalendar) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mEdtBirthdate.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE) {
            //TODO: action
                if(data!=null)
                { // user selects some Image

                    filePath = data.getData();

                    try {
                        InputStream iStream =   getActivity().getContentResolver().openInputStream(filePath);
                        byte[] inputData = getBytes(iStream);

                        dbHelperRegister.addProfileImage(inputData);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String filename = filePath.getLastPathSegment();

                    File file = new File(filename);
                    String strFileName = file.getName();

                    mEdtProfilePhoto.setText(strFileName);

//                    if (filePath != null) {
//                       Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
//                        pro_img.setImageBitmap(bitmap);
//                        img = getEncoded64ImageStringFromBitmap(bitmap);
//                    }

                }
                else
                {
                    // user simply backpressed from gallery
                    Toast.makeText(getContext(), "No Image Selected", Toast.LENGTH_SHORT).show();
                }
        }
    }

    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }



}
