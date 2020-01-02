package com.example.token.test;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 */
public class TimeFormat {

    @Test
    public void format() throws ParseException {
        // datetime format
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date nDate1 = sdf1.parse("2019-12-31 23:59:59");
        System.out.println(nDate1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        Date nDate2 = sdf2.parse("2019-12-31 23:59:59");
        System.out.println(nDate2);

        SimpleDateFormat sdf3 = new SimpleDateFormat("YYYY-MM-DD");
        Date nDate3 = sdf3.parse("2020-01-01");
        System.out.println(nDate3);
    }
}
