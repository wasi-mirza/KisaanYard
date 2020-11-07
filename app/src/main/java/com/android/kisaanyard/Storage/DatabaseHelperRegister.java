package com.android.kisaanyard.Storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static com.android.kisaanyard.Storage.BeneficiaryContract.BeneficiaryEntry.TABLE_NAME;


public class DatabaseHelperRegister extends SQLiteOpenHelper {

    private DatabaseHelperRegister databaseHelperRegister;
    private SQLiteDatabase db;

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "BeneficiaryManager.db";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_FAVORITE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                BeneficiaryContract.BeneficiaryEntry.registrationProfileImageName + " TEXT NOT NULL, " +
//                BeneficiaryContract.BeneficiaryEntry.registrationAadharImageName + " TEXT NOT NULL, " +
                BeneficiaryContract.BeneficiaryEntry.registrationProfileImage + " BLOB " +
//                BeneficiaryContract.BeneficiaryEntry.registrationAadharImage + " BLOB " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_FAVORITE_TABLE);
    }

    //drop beneficiary table
    private String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DatabaseHelperRegister(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //---opens the database---
    public DatabaseHelperRegister open() throws SQLException {
        db = this.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close() {
        databaseHelperRegister.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db1.execSQL(DROP_TABLE);
        // Create tables again
        onCreate(db1);

    }


    //Method to create beneficiary records
    public void addProfileImage(String imageName, byte[] profileImage) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BeneficiaryContract.BeneficiaryEntry.registrationProfileImageName, imageName);
        values.put(BeneficiaryContract.BeneficiaryEntry.registrationProfileImage, profileImage);

        Log.d("TAG", "addProfileImage: " + profileImage+" name: "+imageName);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
/*

    public void addAadharImage(String imageName, byte[] aadharImage) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BeneficiaryContract.BeneficiaryEntry.registrationAadharImageName, imageName);
        values.put(BeneficiaryContract.BeneficiaryEntry.registrationAadharImage, aadharImage);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
*/


    public Cursor getProfileImageDataCursor() {
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( selectQuery, null );
        return res;
    }


    /*
    public String[] getProfileImageData() {

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String[] data = {
                BeneficiaryContract.BeneficiaryEntry.registrationProfileImageName,
                BeneficiaryContract.BeneficiaryEntry.registrationProfileImage
        };

        if (cursor.moveToFirst()) {
            do {
                // get the data into array, or class variable
                cursor.getString(cursor.getColumnIndex(BeneficiaryContract.BeneficiaryEntry.registrationAadharImageName));
                cursor.getString(cursor.getColumnIndex(BeneficiaryContract.BeneficiaryEntry.registrationProfileImage));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }*/

    public void deleteAllEntries() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_NAME);
        db.delete(TABLE_NAME, null, null);

        db.close();
    }


}
