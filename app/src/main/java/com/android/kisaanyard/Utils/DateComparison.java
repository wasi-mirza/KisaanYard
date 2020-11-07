package com.android.kisaanyard.Utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateComparison {

    public static String TAG = "DateComparison";

    public static boolean compareDates(String current_date, String release) {

        boolean datecompare = false;
        try {
            // If you already have date objects then skip 1
            //1
            // Create 2 dates starts
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(current_date);
            Date date2 = sdf.parse(release);

            Log.d(TAG, "compareDates: current date : " + sdf.format(date1));
            Log.d(TAG, "compareDates: release date : " + sdf.format(date2));

            // Create 2 dates ends
            // 1

            // Date object is having 3 methods namely after,before and equals for comparing
            // after() will return true if and only if date1 is after date 2
            if (date1.after(date2)) {
                Log.d(TAG, "compareDates: current date is after release date");
                datecompare = true;
            }
            // before() will return true if and only if date1 is before date2
            if (date1.before(date2)) {
                Log.d(TAG, "compareDates: current date is before release date");
                datecompare = false;
            }
            //equals() returns true if both the dates are equal
            if (date1.equals(date2)) {
                Log.d(TAG, "compareDates: current date is equal release date");
                datecompare = true;
            }

            System.out.println();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return datecompare;
    }

    public static void compareDates(Date date1, Date date2) {
        // if you already have date objects then skip 1
        //1

        //1

        //date object is having 3 methods namely after,before and equals for comparing
        //after() will return true if and only if date1 is after date 2
        if (date1.after(date2)) {
            Log.d(TAG, "compareDates: current date is after release date");
        }

        //before() will return true if and only if date1 is before date2
        if (date1.before(date2)) {
            Log.d(TAG, "compareDates: current date is before release date");
        }

        //equals() returns true if both the dates are equal
        if (date1.equals(date2)) {
            Log.d(TAG, "compareDates: current date is equal release date");
        }

    }
}
