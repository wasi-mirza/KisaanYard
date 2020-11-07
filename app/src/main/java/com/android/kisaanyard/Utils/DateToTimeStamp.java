package com.android.kisaanyard.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToTimeStamp {
    public static Date date;
    private static SimpleDateFormat simpleDateFormat;

    private static String date2="dd-M-yyyy";
    private static String date1="yyyy/M/dd";

    public static long getMillis(String eventdate) {
        try {
            simpleDateFormat = new SimpleDateFormat(date1);
            date = simpleDateFormat.parse(eventdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }


    public static Date convertStringToDate(String _date) {
        try {
            simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            date = simpleDateFormat.parse(_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
