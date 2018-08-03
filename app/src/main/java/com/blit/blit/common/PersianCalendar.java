package com.blit.blit.common;

/*
 * Created by des on 9/6/17.
 */

import java.util.Calendar;
import java.util.Date;

public class PersianCalendar {

    public static String getPersianDate (long sec)
    {
        PersianCalendar persianCalendar = new PersianCalendar(new Date(sec));
        int diff_sec = (int)Math.abs(new Date().getTime()/1000-sec);
        if(diff_sec < 60)
            return String.valueOf(diff_sec) + " ثانیه پیش";
        else if(diff_sec < 3600)
            return String.valueOf(diff_sec/60) + " دقیقه پیش";
        else if(diff_sec < 3600*24)
            return String.valueOf(diff_sec/3600) + " ساعت پیش";

        int diff_day = getDiffrentDayFromToday(persianCalendar.year, persianCalendar.month, persianCalendar.day);
        if(diff_day == 0)
            return "امروز";
        else if(diff_day == 1)
            return "دیروز";
        if( diff_day < 7)
            return String.valueOf(diff_day) + " روز پیش";
        else if(diff_day<30)
            return String.valueOf(diff_day/7) + " هفته پیش";
        else
            return String.valueOf(persianCalendar.day) + " "
                    + PersianCalendar.monthNames[persianCalendar.month - 1] + " "
                    + persianCalendar.year
                    ;
    }

    public static int getDiffrentDayFromToday(int year, int month, int day)
    {
        PersianCalendar persianCalendar = new PersianCalendar(new Date(0));
        int sum = 0;
        sum += Math.abs(persianCalendar.year-year)*365;
        sum += Math.abs(persianCalendar.month - month)*30;
        sum += Math.abs(persianCalendar.day - day);
        return sum;
    }
    public static String getPersianDate (String date)
    {
        if(date == null || date.equals("null") || date.length() < 8)
            return null;

        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(4,6));
        int day = Integer.valueOf(date.substring(6,8));
        int diff = getDiffrentDayFromToday(year, month, day);
        if(diff == 0)
            return "امروز";
        else if(diff == 1)
            return "دیروز";
        if( diff < 7)
            return String.valueOf(diff) + " روز پیش";
        else if(diff<30)
            return String.valueOf(diff/7) + " هفته پیش";
        else
            return String.valueOf(day) + " " + monthNames[month-1] + " " + String.valueOf(year);
    }

    private static String[] weekDayNames = {
            "شنبه","یکشنبه","دوشنبه",
            "سه شنبه", "چهارشنبه",
            "پنج شنبه", "جمعه"
    };
    private static String[] monthNames ={
            "فروردین","اردیبهشت","خرداد","تیر", "مرداد","شهریور",
            "مهر", "آبان", "آذر","دی", "بهمن","اسفند"
    };
    String strWeekDay = "";
    String strMonth = "";
    public int day;
    public int month;
    public int year;
    public int ld;
    Calendar calendar = Calendar.getInstance();
    int gregorianYear =calendar.get(Calendar.YEAR);
    int gregorianMonth = calendar.get(Calendar.MONTH)+1;
    int gregorianDate = calendar.get(Calendar.DATE);
    int WeekDay = calendar.get(Calendar.DAY_OF_WEEK);

    int[] buf1 = {0,31,59,90,120,151,181,212,243,273,304,334};
    int[] buf2 = {0,31,60, 91,121,152,182, 213, 244, 274,305,335};

    public PersianCalendar(){
        Date gregorianDate = new Date();
        calendar.setTime(gregorianDate);
        toPersian(gregorianDate);
    }

    public PersianCalendar(Date gregorianDate){
        calendar.setTime(gregorianDate);
        toPersian(gregorianDate);
    }

    private void toPersian(Date gregorianDate)
    {
        if ((gregorianYear % 4) != 0)
            func1();
        else
            func2();
//        strMonth = monthNames[month-1];
//        strWeekDay = weekDayNames[WeekDay];
    }

    private void func1()
    {
        day = buf1[gregorianMonth - 1] + gregorianDate;
        if (day > 79){
            day = day - 79;
            if (day <= 186) {
                int day2 = day;
                month = (day2 / 31) + 1;
                day = (day2 % 31);
                if(day2 % 31 == 0){
                    month--;
                    day = 31;
                }
                year = gregorianYear - 621;
            }
            else {
                int day2 = day - 186;
                month = (day2 / 30) + 7;
                day = (day2 % 30);
                if(day2 % 30 == 0){
                    month = (day2 / 30) + 6;
                    day = 30;
                }
                year = gregorianYear - 621;
            }
        }
        else{
            ld = gregorianYear > 1996 && gregorianYear % 4 == 1 ? 11 : 10 ;
            int day2 = day + ld;
            month = (day2 / 30) + 10;
            day = (day2 % 30);
            if(day2 % 30 == 0)            {
                month--;
                day = 30;
            }
            year = gregorianYear - 622;
        }
    }

    private void func2()
    {
        day = buf2[gregorianMonth - 1] + gregorianDate;
        ld = gregorianYear >= 1996 ? 79 : 80 ;
        if (day > ld) {
            day = day - ld;
            if (day <= 186) {
                int day2 = day;
                month = (day2 / 31) + 1;
                day = (day2 % 31);
                if(day2 % 31 == 0){
                    month--;
                    day = 31;
                }
                year = gregorianYear - 621;
            } else {
                int day2 = day - 186;
                month = (day2 / 30) + 7;
                day = (day2 % 30);
                if(day2 % 30 == 0 ){
                    month--;
                    day = 30;
                }
                year = gregorianYear - 621;
            }
        }
        else {
            int day2 = day + 10;
            month = (day2 / 30) + 10;
            day = (day2 % 30);
            if(day2 % 30==0){
                month--;
                day = 30;
            }
            year = gregorianYear - 622;
        }
    }
}
