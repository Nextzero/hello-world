package nextzero.web.server.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static final String HL_MMDD = "MM-dd";
    public static final String HL_YYYYMM = "yyyy-MM";
    public static final String HL_YYYY = "yyyy";
    public static final String HL_YYYYMMDD = "yyyy-MM-dd";
    public static final String HL_YYYYMMDDHHMMSS = "yyyy-MM-dd　HH:mm:ss";

    public static final String MMDD = "MMdd";
    public static final String YYYYMM = "yyyyMM";
    public static final String YYYYMMDD = "yyyyMMdd";

    protected Date date;

    public DateUtils(){
        date = new Date();
    }

    public DateUtils(Date date) {
        this.date = date;
    }

    public DateUtils(Long currentTimeMillis){
        date = new Date(currentTimeMillis);
    }

    public Date getDate(){
        return date;
    }

    public String dateToString(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public DateUtils stringToDate(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return new DateUtils(sdf.parse(date));
    }

    public DateUtils dayBefore(int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-days);
        return new DateUtils(calendar.getTime());
    }

    public DateUtils dayAfter(int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,days);
        return new DateUtils(calendar.getTime());
    }

    public DateUtils monthBefore(int months){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -months);
        return new DateUtils(calendar.getTime());
    }

    public DateUtils monthAfter(int months){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, months);
        return new DateUtils(calendar.getTime());
    }

    public DateUtils curMonthFirstDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return new DateUtils(calendar.getTime());
    }

    public DateUtils curMonthLastDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,1);
        calendar.add(Calendar.DATE,-1);
        return new DateUtils(calendar.getTime());
    }
}
