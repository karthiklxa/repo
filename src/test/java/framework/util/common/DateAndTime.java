package framework.util.common;

import com.aventstack.extentreports.ExtentTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by karthik.m on 8/24/2018.
 */
public class DateAndTime {
    private static ExtentTest pNode;

    public static DateAndTime init(ExtentTest t1) {
        pNode = t1;
        return new DateAndTime();
    }

    /**
     *
     * @param value
     * @return
     * @throws Exception
     */
    public String getDate(int value)  {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, value);
        Date date = cal.getTime();
        String newDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return newDate;
    }


    /**
     *
     * @param value - value to subtract or add
     * @return new Date
     * @throws Exception
     */
    public String getYear(int value){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, value);
        Date date = cal.getTime();
        String newDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return newDate;
    }

    /**
     *
     * @param format -DateFormat as String
     * @param value - no of days
     * @return
     * @throws Exception
     */
    public String getDate(String format, int value) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, value);
        Date date = cal.getTime();
        String newDate = new SimpleDateFormat(format).format(date);
        return newDate;
    }


    /**
     *
     * @return Current Time without any symbols
     */
    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }


    /**
     *
     * @return
     */
    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    /**
     *
     * @return
     */
    public static String getCurrentDateTimeExcel() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy-HH-mm-SS");
        LocalDateTime localDateTime = LocalDateTime.now();
        String curr = dtf.format(localDateTime);
        return curr;
    }

    /**
     *
     * @return
     */
    public static String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
        LocalDateTime localDateTime = LocalDateTime.now();
        String curr = dtf.format(localDateTime);
        return curr;
    }


    /**
     *
     * @return
     */
    public static String getCurrentDateSlash() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    /**
     *
     * @param Days
     * @return
     */
    public static String getNextDate(int Days) {
        DateFormat sdf = null;
        Date time1 = null;
        String output = null;
        String date = getCurrentDateSlash();
        try {
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            time1 = sdf.parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(time1);
            c.add(Calendar.DATE, Days);
            output = sdf.format(c.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String convertOracleDateToGUIDateFormat(String DateOfCreation) throws Exception {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = originalFormat.parse(DateOfCreation);
        String formattedDate = targetFormat.format(date);
        //System.out.println("formattedDate= "+formattedDate);
        return  formattedDate;
    }

    public static String convertDateFormatToDBFormat(String DateOfCreation) throws Exception {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = originalFormat.parse(DateOfCreation);
        String formattedDate = targetFormat.format(date);
        //System.out.println("formattedDate= "+formattedDate);
        return  formattedDate;
    }



}
