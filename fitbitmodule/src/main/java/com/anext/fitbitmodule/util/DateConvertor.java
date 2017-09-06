package com.anext.fitbitmodule.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Jiri on 31/07/17.
 */

public class DateConvertor {
    private static DateFormat formater = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public static Date convertStringToDate(String date){
        Date result = null;
        try {
            result = formater.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String convertDateToString(Date date){
        if(date == null) return  null;
        return formater.format(date);
    }
}
