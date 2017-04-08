/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Achyut
 */
public class TimeDate {
    static TimeDate time = new TimeDate();
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private int MS;
    private long timestamp;
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    
    TimeDate(){
    
    }
    
    TimeDate(int _year,int _month,int _day,int _hour,int _min,int _sec , int _milli){
        year = _year;
        month = _month;
        day = _day;
        hour = _hour;
        minute = _min;
        second = _sec;
        MS = _milli;
        
    }
    String timestampToFullDate(long timeStamp){
        String temp;
        Date d1 = new Date(timeStamp);
        temp = dateFormat.format(d1);
        return temp;
    }
    
    String timestampToTime(long timeStamp){
        String temp;
        Date d1 = new Date(timeStamp);
        temp = timeFormat.format(d1);
        return temp;
    }
    
    long fulldateToTimeStamp(String fulldate){
        try {
            long temp;
            Date d1 = dateFormat.parse(fulldate);
            temp = d1.getTime();
            return temp;
        } catch (ParseException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "TimeDate", "fulldateToTimestamp");
            return 0;
        }
    }
    long hourToTimeStamp(String fulltime){
        try {
            long temp;
            Date d1 = timeFormat.parse(fulltime);
            temp = d1.getTime();
            temp = temp * -1;
            return temp;
        } catch (ParseException ex) {
            Log.log.writeErrorLog(ex.getMessage(), "TimeDate", "hourToTimestamp");
            return 0;
        }
    }
    
    TimeDate getDifferenceFromCurrent(long timeStamp){
        TimeDate temp;
        long current = System.currentTimeMillis();
        temp = getTimeDifference(current,timestamp);
        return temp;
    }
    
    
    TimeDate getTimeDifference(long timeStamp1,long timeStamp2){
        TimeDate temp = new TimeDate();
        long diff;
        if(timeStamp2 > timeStamp1){
            diff = timeStamp2 - timeStamp1;
        }
        else {
            diff = timeStamp1 - timeStamp2;
        }
            int timeInSeconds = (int) (diff / 1000);
            int years,months,days,hours, minutes, seconds;
            years = timeInSeconds / (86400*29*12);
            timeInSeconds = timeInSeconds - (years * 86400*29*12);
            months = timeInSeconds / (86400*29);
            timeInSeconds = timeInSeconds - (months * 86400*29);
            days = timeInSeconds / (86400);
            timeInSeconds = timeInSeconds - (days * 86400);
            hours = timeInSeconds / 3600;
            timeInSeconds = timeInSeconds - (hours * 3600);
            minutes = timeInSeconds / 60;
            timeInSeconds = timeInSeconds - (minutes * 60);
            seconds = timeInSeconds;
            temp.year = year;
            temp.month = months;
            temp.day = days;
            temp.hour = hours;
            temp.minute = minutes;
            temp.second = seconds;
            temp.MS = (int)diff % 1000;
            temp.timestamp = diff;
        return temp;
    }
    
    long BlackListingTimeCalculation(String months,String weeks,String days,String hours){
        long milli = 0;
         if(months != null){
                milli = Integer.parseInt(months) * 30*24*60*60*1000;
            }
         else if(weeks != null){
             milli =  Integer.parseInt(weeks) * 7 * 24 * 60 * 60 * 1000;
         }
         else if(days!= null){
             milli = Integer.parseInt(days) * 24 * 60 * 60 *1000;
         }
         else if(hours !=null)
         {
             milli = Integer.parseInt(hours) * 60 * 60 *1000;
         }
        
        return milli;
    }
    
    TimeDate milliSecondsToTime(long milliSeconds){
            TimeDate temp = new TimeDate();
            int timeInSeconds = (int) (milliSeconds / 1000);
            int years,months,days,hours, minutes, seconds;
            years = timeInSeconds / (86400*29*12);
            timeInSeconds = timeInSeconds - (years * 86400*29*12);
            months = timeInSeconds / (86400*29);
            timeInSeconds = timeInSeconds - (months * 86400*29);
            days = timeInSeconds / (86400);
            timeInSeconds = timeInSeconds - (days * 86400);
            hours = timeInSeconds / 3600;
            timeInSeconds = timeInSeconds - (hours * 3600);
            minutes = timeInSeconds / 60;
            timeInSeconds = timeInSeconds - (minutes * 60);
            seconds = timeInSeconds;
            temp.year = year;
            temp.month = months;
            temp.day = days;
            temp.hour = hours;
            temp.minute = minutes;
            temp.second = seconds;
            temp.MS = (int)milliSeconds % 1000;
            temp.timestamp = milliSeconds;
        return temp;
        
    }
    String longToTime(long milli){
    TimeDate td = milliSecondsToTime(milli);
    String time = td.hour + ":" +td.minute + ":" +td.second;
    return time;
    }
    long currentTimeStamp(){
        return System.currentTimeMillis();
    }
    
    TimeDate getCurrentTimeDate(){
        
        return this.milliSecondsToTime(currentTimeStamp());
        
    }
    
    String timeStampToTime1(long timeStamp){
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    try {
            Date parsed = format.parse(Long.toString(timeStamp));
            return parsed.toString();
        }
        catch(ParseException pe) {
            DialogBox.dialog.errorDialog("ERROR: Cannot parse \"" + timeStamp + "\"");
            return null;
        }
    }
    
    String timeStampToDateTime(long timeStamp) {

        /*
         * // Make a new Date object. It will be initialized to the current
         * time. Date now = new Date();
         *
         * // See what toString() returns System.out.println(" 1. " +
         * now.toString());
         *
         * // Next, try the default DateFormat System.out.println(" 2. " +
         * DateFormat.getInstance().format(now));
         *
         * // And the default time and date-time DateFormats
         * System.out.println(" 3. " +
         * DateFormat.getTimeInstance().format(now)); System.out.println(" 4. "
         * + DateFormat.getDateTimeInstance().format(now));
         *
         * // Next, try the short, medium and long variants of the // default
         * time format System.out.println(" 5. " +
         * DateFormat.getTimeInstance(DateFormat.SHORT).format(now));
         * System.out.println(" 6. " +
         * DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now));
         * System.out.println(" 7. " +
         * DateFormat.getTimeInstance(DateFormat.LONG).format(now));
         *
         * // For the default date-time format, the length of both the // date
         * and time elements can be specified. Here are some examples:
         * System.out.println(" 8. " + DateFormat.getDateTimeInstance(
         * DateFormat.SHORT, DateFormat.SHORT).format(now));
         * System.out.println(" 9. " + DateFormat.getDateTimeInstance(
         * DateFormat.MEDIUM, DateFormat.SHORT).format(now));
         * System.out.println("10. " + DateFormat.getDateTimeInstance(
         * DateFormat.LONG, DateFormat.LONG).format(now)); // Make a new Date
         * object. It will be initialized to the // current time.
         *
         * // Print the result of toString() String dateString = now.toString();
         * System.out.println(" 1. " + dateString);
         *
         * // Make a SimpleDateFormat for toString()'s output. This // has short
         * (text) date, a space, short (text) month, a space, // 2-digit date, a
         * space, hour (0-23), minute, second, a space, // short timezone, a
         * final space, and a long year. SimpleDateFormat format = new
         * SimpleDateFormat("EEEE MMM dd HH:mm:ss zzz yyyy");
         *
         * // See if we can parse the output of Date.toString() try { Date
         * parsed = format.parse(dateString); System.out.println(" 2. " +
         * parsed.toString()); } catch(ParseException pe) {
         * System.out.println("ERROR: Cannot parse \"" + dateString + "\""); }
         *
         * // Print the result of formatting the now Date to see if the result
         * // is the same as the output of toString() System.out.println(" 3. "
         * + format.format(now));
         */
        return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(timeStamp);
    }
}


