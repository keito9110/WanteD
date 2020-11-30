package com.example.wanted;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class GetDate {
    public static Date truncate(Date datetime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(datetime);

        return new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE))
                .getTime();
    }
    private String getToday() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return sdf.format(date);
    }

        /*
        //Date型の持つ日時を表示
        System.out.println(date);

        //Date型の持つ日時の4年後を表示(日時の加算)
        calendar.add(Calendar.YEAR, 4);
        date = calendar.getTime();
        System.out.println(date);

        //Date型の持つ日時の3日前を表示(日時の減算)
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        date = calendar.getTime();
        System.out.println(date);

         */
}
