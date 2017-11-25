package com.xiao.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期操作工具类
 *
 * @author 肖亭
 * @since 2017年11月25 17:51
 **/
public class DateUtil {

    /**
     * 得到几天前的时间
     *
     * @param time 日期
     * @param day  天数
     * @return
     */
    public static Date getDateBefore(Date time, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(time);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     *
     * @param time 时间
     * @param day  天数
     * @return
     */
    public static Date getDateAfter(Date time, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(time);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * 字符串格式化成date
     *
     * @param time    日期
     * @param pattern 格式
     * @return
     */
    public static Date getDateTimeSdf(String time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取一天开始时间
     *
     * @param time 时间
     * @return
     */
    public static Date getStartTime(Date time) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(time);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取一天结束时间
     *
     * @param time 时间
     * @return
     */
    public static Date getEndTime(Date time) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(time);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 计算t1与t2之间的天数  向下取整
     *
     * @param t1
     * @param t2
     * @return
     */
    public static int days(Date t1, Date t2) {
        return (int) ((t2.getTime() - t1.getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * 获取两个时间的天数差值
     *
     * @param t1 开始时间
     * @param t2 结束时间
     * @return
     */
    public static int chronoUnitDays(Date t1, Date t2) {
        Long days = ChronoUnit.DAYS.between(LocalDateTime.ofInstant(t1.toInstant(), ZoneId.systemDefault()),
                LocalDateTime.ofInstant(t2.toInstant(), ZoneId.systemDefault()));
        return days.intValue();
    }

    /**
     * 计算t1与t2之间的天数 (不分先后)
     *
     * @param t1 开始时间
     * @param t2 结束时间
     * @return
     */
    public static int absDays(Date t1, Date t2) {
        return Math.abs((int) ((t2.getTime() - t1.getTime()) / (1000 * 60 * 60 * 24)));
    }

    /**
     * 对日期进行格式化
     *
     * @param date    时间
     * @param pattern 格式
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null || pattern.trim().length() == 0) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
