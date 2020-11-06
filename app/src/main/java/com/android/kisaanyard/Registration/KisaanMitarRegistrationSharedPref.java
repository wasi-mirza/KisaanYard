package com.android.kisaanyard.Registration;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.android.kisaanyard.Application;

public class KisaanMitarRegistrationSharedPref {

    private static KisaanMitarRegistrationSharedPref _instance = null;
    private static SharedPreferences _sharedPreferences = null;
    private static Editor _sharedPrefEditor = null;
    private final String SHARED_PREFERENCE_NAME = "KISAAN_MITAR_REGISTRATION";


    private final String KEY_ID = "ID";
    private final String KEY_IMAGE = "IMAGE";
    private final String KEY_NAME = "NAME";
    private final String KEY_MOBILE = "MOBILE";
    private final String KEY_WHATSAPP = "WHATSAPP";
    private final String KEY_EMAIL = "EMAIL";
    private final String KEY_GENDER = "GENDER";
    private final String KEY_DOB = "DATE_OF_BIRTH";
    private final String KEY_SOMETHING_ABOUT_YOURSELF = "SOMETHING_ABOUT_YOURSELF";

    private final String KEY_PINCODE = "PINCODE";
    private final String KEY_STATE = "STATE";
    private final String KEY_DISTRICT = "DISTRICT";
    private final String KEY_TALUKA = "TALUKA";
    private final String KEY_VILLAGE = "VILLAGE";

    private final String KEY_PERMANENT_PINCODE = "PERMANENT_PINCODE";
    private final String KEY_PERMANENT_STATE = "PERMANENT_STATE";
    private final String KEY_PERMANENT_DISTRICT = "PERMANENT_DISTRICT";
    private final String KEY_PERMANENT_TALUKA = "PERMANENT_TALUKA";
    private final String KEY_PERMANENT_VILLAGE_CITY = "PERMANENT_VILLAGE_CITY";
    private final String KEY_STREET_ADDRESS = "PERMANENT_STREET_ADDRESS";
    private final String KEY_PHOTO_ID_TYPE = "PERMANENT_PHOTO_ID_TYPE";
    private final String KEY_PHOTO_ID_NUMBER = "PERMANENT_PHOTO_ID_NUMBER";
    private final String KEY_PHOTO_ID_IMAGE = "PERMANENT_PHOTO_ID_IMAGE";


    private final String KEY_MOBILE_NUMBER = "USERNAME_MOBILE_NUMBER";
    private final String KEY_PASSWORD = "PASSWORD";
    private final String KEY_EDUCATION = "EDUCATION";
    private final String KEY_COMPUTER_KNOWLEDGE = "COMPUTER_KNOWLEDGE";
    private final String KEY_TWO_WHEELER = "TWO_WHEELER";
    private final String KEY_SMART_PHONE_OR_INTERNET = "SMART_PHONE_OR_INTERNET";
    private final String KEY_LAPTOP_OR_PC = "LAPTOP_OR_PC";
    private final String KEY_JOB_DETAILS = "JOB_DETAILS";
    private final String KEY_ANNUAL_INCOME = "ANNUAL_INCOME";
    private final String KEY_EXPERIENCE_IN_YEAR = "EXPERIENCE_IN_YEAR";


    private KisaanMitarRegistrationSharedPref() {

    }

    public static KisaanMitarRegistrationSharedPref getInstance() {
        if (_instance == null) {
            _instance = new KisaanMitarRegistrationSharedPref();
            _instance._initSharedPreferences();
        }
        return _instance;
    }

    /**
     * This method is used to initialized {@link SharedPreferences} and
     * {@link Editor}
     */
    public void _initSharedPreferences() {
        _sharedPreferences = _getSharedPref();
        _sharedPrefEditor = _getSharedPrefEditor();
    }

    /**
     * Method to get the SharedPreferences.
     *
     * @return the {@link SharedPreferences} object.
     */
    private SharedPreferences _getSharedPref() {
        if (_sharedPreferences == null) {
            _sharedPreferences = Application.appContext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        }
        return _sharedPreferences;
    }

    /**
     * Method to get the {@link Editor} for writing values to {@link SharedPreferences}.
     *
     * @return the {@link Editor} object.
     */
    private Editor _getSharedPrefEditor() {
        if (_sharedPrefEditor == null) {
            _sharedPrefEditor = _getSharedPref().edit();
        }
        return _sharedPrefEditor;
    }


    public void setID(int id) {
        _getSharedPrefEditor().putInt(KEY_ID, id).commit();
    }

    public int getID() {
        return _getSharedPref().getInt(KEY_ID, -1);
    }


    public void setProfileImage(String image) {
        _getSharedPrefEditor().putString(KEY_IMAGE, image).commit();
    }

    public String getProfileImage() {
        return _getSharedPref().getString(KEY_IMAGE, null);
    }

    public void setName(String name) {
        _getSharedPrefEditor().putString(KEY_NAME, name).commit();
    }

    public String getName() {
        return _getSharedPref().getString(KEY_NAME, null);
    }

    public void setMobile(String mobile) {
        _getSharedPrefEditor().putString(KEY_MOBILE, mobile).commit();
    }

    public String getMobile() {
        return _getSharedPref().getString(KEY_MOBILE, null);
    }


    public void setWhatsappNumber(String whatsappNumber) {
        _getSharedPrefEditor().putString(KEY_WHATSAPP, whatsappNumber).commit();
    }

    public String getWhatsappNumber() {
        return _getSharedPref().getString(KEY_WHATSAPP, null);
    }


    public void setEmail(String email) {
        _getSharedPrefEditor().putString(KEY_EMAIL, email).commit();
    }

    public String getEmail() {
        return _getSharedPref().getString(KEY_EMAIL, null);
    }

    public void setDOB(String dob) {
        _getSharedPrefEditor().putString(KEY_DOB, dob).commit();
    }

    public String getDOB() {
        return _getSharedPref().getString(KEY_DOB, null);
    }


    public void setGender(String gender) {
        _getSharedPrefEditor().putString(KEY_GENDER, gender).commit();
    }

    public String getGender() {
        return _getSharedPref().getString(KEY_GENDER, null);
    }


    public void setSaySomethingAbout(String somethingAbout) {
        _getSharedPrefEditor().putString(KEY_SOMETHING_ABOUT_YOURSELF, somethingAbout).commit();
    }

    public String getSaySomethingAbout() {
        return _getSharedPref().getString(KEY_SOMETHING_ABOUT_YOURSELF, null);
    }


    //KISAAN MITAR PAGE 2 DETAILS:

    public void setPincode(String pincode) {
        _getSharedPrefEditor().putString(KEY_PINCODE, pincode).commit();
    }

    public String getPincode() {
        return _getSharedPref().getString(KEY_PINCODE, null);
    }

    public void setState(String state) {
        _getSharedPrefEditor().putString(KEY_STATE, state).commit();
    }

    public String getState() {
        return _getSharedPref().getString(KEY_STATE, null);
    }

    public void setDistrict(String district) {
        _getSharedPrefEditor().putString(KEY_DISTRICT, district).commit();
    }

    public String getDistrict() {
        return _getSharedPref().getString(KEY_DISTRICT, null);
    }


    public void setTaluka(String taluka) {
        _getSharedPrefEditor().putString(KEY_TALUKA, taluka).commit();
    }

    public String getTaluka() {
        return _getSharedPref().getString(KEY_TALUKA, null);
    }


    public void setVillage(String village) {
        _getSharedPrefEditor().putString(KEY_VILLAGE, village).commit();
    }

    public String getVillage() {
        return _getSharedPref().getString(KEY_VILLAGE, null);
    }


    public void remove() {
        _sharedPrefEditor.clear();
        _sharedPrefEditor.commit();
    }


    public void clearData() {

        setID(-1);
        setName(null);
        setMobile(null);
        setWhatsappNumber(null);
        setEmail(null);
        setDOB(null);
        setGender(null);
        setProfileImage(null);
        setSaySomethingAbout(null);

        setPincode(null);
        setState(null);
        setDistrict(null);
        setTaluka(null);
        setVillage(null);

    }


}
