package com.android.kisaanyard.Utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeComparison {

    public static String TAG = "TimeComparison";

    public static boolean compareTimings(String current_time, String release) {

        boolean timecompare = false;
        try {
            // If you already have date objects then skip 1
            //1
            // Create 2 dates starts
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
            Date date1 = sdf.parse(current_time);
            Date date2 = sdf.parse(release);

            Log.d(TAG, "compareTimings: current time : " + sdf.format(date1));
            Log.d(TAG, "compareTimings: release time : " + sdf.format(date2));

            // Create 2 dates ends
            // 1

            // Date object is having 3 methods namely after,before and equals for comparing
            // after() will return true if and only if date1 is after date 2
            if (date1.after(date2)) {
                Log.d(TAG, "compareTimings: current time is after release date");
                timecompare = true;
            }
            // before() will return true if and only if date1 is before date2
            if (date1.before(date2)) {
                Log.d(TAG, "compareTimings: current time is before release date");
                timecompare = false;
            }
            //equals() returns true if both the dates are equal
            if (date1.equals(date2)) {
                Log.d(TAG, "compareTimings: current time is equal release date");
                timecompare = true;
            }

            System.out.println();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return timecompare;
    }

    public static void compareTimings(Date date1, Date date2) {
        // if you already have date objects then skip 1
        //1

        //1

        //date object is having 3 methods namely after,before and equals for comparing
        //after() will return true if and only if date1 is after date 2
        if (date1.after(date2)) {
            Log.d(TAG, "compareTimings: current time is after release date");
        }

        //before() will return true if and only if date1 is before date2
        if (date1.before(date2)) {
            Log.d(TAG, "compareTimings: current time is before release date");
        }

        //equals() returns true if both the dates are equal
        if (date1.equals(date2)) {
            Log.d(TAG, "compareTimings: current time is equal release date");
        }

    }
}
