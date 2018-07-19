package com.forevc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String today(int shift) {

        Date date = new Date(System.currentTimeMillis() + 86400 * shift * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("M.d");
        return format.format(date);
    }
}
