package wangfei.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static final String dateFormatYMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String dateFormatYMD = "yyyy-MM-dd";
    public static final String dateFormatYM = "yyyy-MM";
    public static final String dateFormatYMDHM = "yyyy-MM-dd HH:mm";
    public static final String dateFormatMD = "MM/dd";
    public static final String dateFormatHMS = "HH:mm:ss";
    public static final String dateFormatHM = "HH:mm";
    public static final String AM = "AM";
    public static final String PM = "PM";

    public DateUtils() {
    }

    public static Date getDateByFormat(String strDate, String format) {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = mSimpleDateFormat.parse(strDate);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return date;
    }

    public Date getDateByOffset(Date date, int calendarField, int offset) {
        GregorianCalendar c = new GregorianCalendar();

        try {
            c.setTime(date);
            c.add(calendarField, offset);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return c.getTime();
    }

    public static String getStringByOffset(String strDate, String format, int calendarField, int offset) {
        String mDateTime = null;

        try {
            GregorianCalendar e = new GregorianCalendar();
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
            e.setTime(mSimpleDateFormat.parse(strDate));
            e.add(calendarField, offset);
            mDateTime = mSimpleDateFormat.format(e.getTime());
        } catch (ParseException var7) {
            var7.printStackTrace();
        }

        return mDateTime;
    }

    public static String getStringByOffset(Date date, String format, int calendarField, int offset) {
        String strDate = null;

        try {
            GregorianCalendar e = new GregorianCalendar();
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
            e.setTime(date);
            e.add(calendarField, offset);
            strDate = mSimpleDateFormat.format(e.getTime());
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return strDate;
    }

    public static String getStringByFormat(Date date, String format) {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
        String strDate = null;

        try {
            strDate = mSimpleDateFormat.format(date);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return strDate;
    }

    public static String getStringByFormat(String strDate, String format) {
        String mDateTime = null;

        try {
            GregorianCalendar e = new GregorianCalendar();
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            e.setTime(mSimpleDateFormat.parse(strDate));
            SimpleDateFormat mSimpleDateFormat2 = new SimpleDateFormat(format);
            mDateTime = mSimpleDateFormat2.format(e.getTime());
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return mDateTime;
    }

    public static String getStringByFormat(long milliseconds, String format) {
        String thisDateTime = null;

        try {
            SimpleDateFormat e = new SimpleDateFormat(format);
            thisDateTime = e.format(Long.valueOf(milliseconds));
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return thisDateTime;
    }

    public static String getCurrentDate(String format) {
//        Log.d(AbDateUtil.class, "getCurrentDate:" + format);
        String curDateTime = null;

        try {
            SimpleDateFormat e = new SimpleDateFormat(format);
            GregorianCalendar c = new GregorianCalendar();
            curDateTime = e.format(c.getTime());
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return curDateTime;
    }

    public static String getCurrentDateByOffset(String format, int calendarField, int offset) {
        String mDateTime = null;

        try {
            SimpleDateFormat e = new SimpleDateFormat(format);
            GregorianCalendar c = new GregorianCalendar();
            c.add(calendarField, offset);
            mDateTime = e.format(c.getTime());
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return mDateTime;
    }

    public static int getOffectDay(long milliseconds1, long milliseconds2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(milliseconds1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(milliseconds2);
        int y1 = calendar1.get(Calendar.YEAR);
        int y2 = calendar2.get(Calendar.YEAR);
        int d1 = calendar1.get(Calendar.DAY_OF_YEAR);
        int d2 = calendar2.get(Calendar.DAY_OF_YEAR);
        boolean maxDays = false;
        boolean day = false;
        int maxDays1;
        int day1;
        if (y1 - y2 > 0) {
            maxDays1 = calendar2.getActualMaximum(Calendar.DAY_OF_YEAR);
            day1 = d1 - d2 + maxDays1;
        } else if (y1 - y2 < 0) {
            maxDays1 = calendar1.getActualMaximum(Calendar.DAY_OF_YEAR);
            day1 = d1 - d2 - maxDays1;
        } else {
            day1 = d1 - d2;
        }

        return day1;
    }

    public static int getOffectHour(long date1, long date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(date2);
        int h1 = calendar1.get(Calendar.HOUR_OF_DAY);
        int h2 = calendar2.get(Calendar.HOUR_OF_DAY);
        boolean h = false;
        int day = getOffectDay(date1, date2);
        h1 = h1 - h2 + day * 24;
        return h1;
    }

    public static int getOffectMinutes(long date1, long date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(date2);
        int m1 = calendar1.get(Calendar.MINUTE);
        int m2 = calendar2.get(Calendar.MINUTE);
        int h = getOffectHour(date1, date2);
        boolean m = false;
        m1 = m1 - m2 + h * 60;
        return m1;
    }

    public static String getFirstDayOfWeek(String format) {
        return getDayOfWeek(format, 2);
    }

    public static String getLastDayOfWeek(String format) {
        return getDayOfWeek(format, 1);
    }

    private static String getDayOfWeek(String format, int calendarField) {
        String strDate = null;

        try {
            GregorianCalendar e = new GregorianCalendar();
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
            int week = e.get(Calendar.DAY_OF_WEEK);
            if (week == calendarField) {
                strDate = mSimpleDateFormat.format(e.getTime());
            } else {
                int offectDay = calendarField - week;
                if (calendarField == 1) {
                    offectDay = 7 - Math.abs(offectDay);
                }

                e.add(Calendar.DAY_OF_MONTH, offectDay);
                strDate = mSimpleDateFormat.format(e.getTime());
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return strDate;
    }

    public static String getFirstDayOfMonth(String format) {
        String strDate = null;

        try {
            GregorianCalendar e = new GregorianCalendar();
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
            e.set(Calendar.DAY_OF_MONTH, 1);
            strDate = mSimpleDateFormat.format(e.getTime());
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return strDate;
    }

    public static String getLastDayOfMonth(String format) {
        String strDate = null;

        try {
            GregorianCalendar e = new GregorianCalendar();
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
            e.set(Calendar.DAY_OF_MONTH, 1);
            e.roll(Calendar.DAY_OF_MONTH, -1);
            strDate = mSimpleDateFormat.format(e.getTime());
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return strDate;
    }

    public static long getFirstTimeOfDay() {
        Date date = null;

        try {
            String e = getCurrentDate("yyyy-MM-dd");
            date = getDateByFormat(e + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
            return date.getTime();
        } catch (Exception var2) {
            return -1L;
        }
    }

    public static long getLastTimeOfDay() {
        Date date = null;

        try {
            String e = getCurrentDate("yyyy-MM-dd");
            date = getDateByFormat(e + " 24:00:00", "yyyy-MM-dd HH:mm:ss");
            return date.getTime();
        } catch (Exception var2) {
            return -1L;
        }
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 400 != 0 || year % 400 == 0;
    }

    public static String formatDateStr2Desc(String strDate, String outFormat) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {
            c2.setTime(df.parse(strDate));
            c1.setTime(new Date());
            int e = getOffectDay(c1.getTimeInMillis(), c2.getTimeInMillis());
            if (e == 0) {
                int out = getOffectHour(c1.getTimeInMillis(), c2.getTimeInMillis());
                if (out > 0) {
                    return "今天" + getStringByFormat(strDate, "HH:mm");
                }

                if (out >= 0 && out == 0) {
                    int m = getOffectMinutes(c1.getTimeInMillis(), c2.getTimeInMillis());
                    if (m > 0) {
                        return m + "分钟前";
                    }

                    if (m >= 0) {
                        return "刚刚";
                    }
                }
            } else if (e > 0) {
                if (e != 1 && e == 2) {
                    ;
                }
            } else if (e < 0 && e != -1 && e == -2) {
                ;
            }

            String out1 = getStringByFormat(strDate, outFormat);
            if (out1 == null || out1.length() == 0) {
                return out1;
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }
        return strDate;
    }

    public static String getWeek() {
        Date date = new Date();
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        return dateFm.format(date);
    }

    public static String getWeekNumber(String strDate, String inFormat) {
        String week = "星期日";
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat(inFormat);

        try {
            calendar.setTime(df.parse(strDate));
        } catch (Exception var6) {
            return "错误";
        }

        int intTemp = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        switch (intTemp) {
            case 0:
                week = "星期日";
                break;
            case 1:
                week = "星期一";
                break;
            case 2:
                week = "星期二";
                break;
            case 3:
                week = "星期三";
                break;
            case 4:
                week = "星期四";
                break;
            case 5:
                week = "星期五";
                break;
            case 6:
                week = "星期六";
        }

        return week;
    }

    public static String getTimeQuantum(String strDate, String format) {
        Date mDate = getDateByFormat(strDate, format);
        int hour = mDate.getHours();
        return hour >= 12 ? "PM" : "AM";
    }

    public static String getTimeDescription(long milliseconds) {
        if (milliseconds > 1000L) {
            if (milliseconds / 1000L / 60L > 1L) {
                long minute = milliseconds / 1000L / 60L;
                long second = milliseconds / 1000L % 60L;
                return minute + "分" + second + "秒";
            } else {
                return milliseconds / 1000L + "秒";
            }
        } else {
            return milliseconds + "毫秒";
        }
    }

    public static void main(String[] args) {
        System.out.println(formatDateStr2Desc("2012-3-2 12:2:20", "MM月dd日  HH:mm"));
    }
}
