/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       JKHH120 LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@gmail.com
 *   @Version    V1.0
 *   @Date:   2019年05月24日 22时03分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Discription
 *   -----------------------------------------------------------------------------------
 *  2019-05-24 22:03:37    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.ch.cb_common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 * @author lch
 * @date 2020/4/12
 */
public class DateUtil {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DATE_PATTERN_YTD = "yyyy年MM月dd日";
    public static final String DATE_PATTERN_MD = "MM月dd日";
    public static final String DATE_PATTERN_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    /**
     * 获得当月最大时间 2019-04-30T23:59:59.999999999
     *
     * @author : fengzijk
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getMounthEndTime() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MAX);
        return startOfDay.with(TemporalAdjusters.lastDayOfMonth());
    }

    public static LocalDateTime getMounthEndTime(LocalDateTime localDateTime) {
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MAX);
        return startOfDay.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获得当月最小时间 2019-04-30 00:00:00
     *
     * @author : fengzijk
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getMounthStartTime() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return startOfDay.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获得当月最小时间 2019-04-30 00:00:00
     *
     * @author : fengzijk
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getMounthStartTime(LocalDateTime localDateTime) {
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return startOfDay.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获得当天最小时间 2019-04-30 00:00:00
     *
     * @author : liyu
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getDayStartTime(LocalDateTime localDateTime) {
        return localDateTime.with(LocalTime.MIN);
    }

    /**
     * 获得当月最小时间 2019-04-30 00:00:00
     *
     * @author : liyu
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getDayEndTime(LocalDateTime localDateTime) {
        return localDateTime.with(LocalTime.MAX);
    }

    /**
     * 获得当天最小时间 2019-04-30 00:00:00
     *
     * @author : liyu
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getDayStartTime(LocalDate localDate) {
        return localDate.atStartOfDay();
    }

    /**
     * 获得当天最小时间 2019-04-30 00:00:00
     *
     * @author : liyu
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getDayEndTime(LocalDate localDate) {
        return localDate.atTime(LocalTime.MAX);
    }

    /**
     * 将Date转换为LocalDateTime
     *
     * @param date java.util.Date类型的参数
     * @return java.time.LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @Date: 2019/5/24 22:12
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 时间戳 转 LocalDateTime
     *
     * @param timestamp 时间戳
     * @return 返回LocalDateTime
     */
    public static LocalDateTime timestamp2LocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * <pre> 毫秒数转LocalDateTime</pre>
     *
     * @param str str 毫秒数字符串
     * @return java.time.LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @date: 2019/7/23 19:46
     */
    public static LocalDateTime timeMillis2LocalDateTime(String str) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(str));
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * LocalDateTime 转 时间戳
     *
     * @param localDateTime LocalDateTime 类型参数
     * @return 返回时间戳
     */
    public static long localDateTime2Timestamp(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 时间转为指定格式的字符串
     *
     * @param time    LocalDateTime 类型的参数
     * @param pattern 需要转换的格式类型
     * @return 返回String类型
     */
    public static String time2FormatString(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 指定格式的字符串转为时间
     *
     * @param formatString 字符串
     * @param pattern      需要转换的格式类型
     * @return 返回  LocalDateTime 类型
     */
    public static LocalDateTime formatString2Time(String formatString, String pattern) {
        return LocalDateTime.parse(formatString, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间加另一个时间后的时间
     *
     * @param number 要加的数字
     * @param unit   单位 eg:ChronoUnit.SECONDS
     * @return LocalDateTime LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @Date: 2019/5/24 22:39
     */
    @SuppressWarnings("WeakerAccess")
    public static LocalDateTime getNowAddition(long number, TemporalUnit unit) {
        return LocalDateTime.now().plus(number, unit);
    }

    /**
     * 获取指定时间加另一个时间后的时间
     *
     * @param number 要加的数字
     * @param unit   单位 eg:ChronoUnit.SECONDS
     * @return LocalDateTime LocalDateTime
     * @author lch
     * @date 2019-06-11
     */
    public static LocalDateTime getTimeAddition(LocalDateTime time, long number, TemporalUnit unit) {
        return time.plus(number, unit);
    }

    /**
     * 获取当前时间减去另一个时间后的时间
     *
     * @param number 要加的数字
     * @param unit   单位 eg:ChronoUnit.SECONDS
     * @return LocalDateTime LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @Date: 2019/5/24 22:39
     */
    public static LocalDateTime getNowMinus(long number, TemporalUnit unit) {
        return LocalDateTime.now().minus(number, unit);
    }

    /**
     * 获取指定时间减去另一个时间后的时间
     *
     * @param number 要加的数字
     * @param unit   单位 eg:ChronoUnit.SECONDS
     * @return LocalDateTime LocalDateTime
     * @author lch
     * @date 2019-06-11
     */
    public static LocalDateTime getTimeMinus(LocalDateTime time, long number, TemporalUnit unit) {
        return time.minus(number, unit);
    }


    /**
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @title: 两个日期之前相差的天数
     * @author lcc
     * @date 2019/5/25 15:08
     */
    public static Long getBetweenDays(LocalDateTime startTime, LocalDateTime endTime) {
        long start = startTime.toLocalDate().toEpochDay();
        long end = endTime.toLocalDate().toEpochDay();
        return end - start;
    }

    /**
     * @param startDay 开始日期
     * @param endDay   结束日期
     * @title: 两个日期之前相差的天数
     * @author lch
     */
    public static Long getBetweenDays(LocalDate startDay, LocalDate endDay) {
        return endDay.toEpochDay() - startDay.toEpochDay();
    }


    /**
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @title: 两个日期之前相差的年数
     * @description: TODO
     * @author liyu
     * @date 2019/5/25 15:08
     */
    public static Long getBetweenYears(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime == null || endTime == null) {
            return null;
        }
        long start = startTime.toLocalDate().getYear();
        long end = endTime.toLocalDate().getYear();
        return end - start;
    }

    /**
     * 两个时间之前相差的毫秒数
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @author lcc
     * @date 2019/5/25 15:08
     */
    public static Long getBetweenMillis(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        //相差毫秒数
        long millis = duration.toMillis();
        return millis;
    }

    /**
     * <pre>计算两个时间相差分钟数/pre>
     * @param startTime start time
     * @param endTime endTime
     * @return java.lang.Long
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @date: 2019/6/6 8:44
     */
    public static Long getBetweenMinutes(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        //相差毫秒数
        long minutes = duration.toMinutes();
        return minutes;
    }


    /**
     * <pre>计算两个时间相差秒数/pre>
     * @param startTime start time
     * @param endTime endTime
     * @return java.lang.Long
     * @author: liyu
     * @email :guozhifengvip@gmail.com
     * @date: 2019/6/6 8:44
     */
    public static Long getBetweenSeconds(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        //相差毫秒数
        long minutes = duration.getSeconds();
        return minutes;
    }
//



    /**
     * 计算时间是否是在时间段内
     *
     * @author lch
     * @date 2019-06-04
     */
    public static boolean checkTimeBetweenStartAndEnd(LocalDateTime time, LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, time);
        //相差毫秒数
        long millis1 = duration.toMillis();
        if (millis1 < 0 || millis1 == 0) {
            return false;
        }

        duration = Duration.between(time, endTime);
        //相差毫秒数
        long millis2 = duration.toMillis();
        if (millis2 < 0 || millis2 == 0) {
            return false;
        }

        return true;
    }


    /**
     * @param localDateTime
     * @param formatter     格式化 "23:59:59"
     * @title: 格式化时分秒
     * @author lcc
     * @date 2019/5/25 15:14
     */
    public static LocalDateTime getFormatLocalDateTime(LocalDateTime localDateTime, String formatter) {

        String format = localDateTime.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
        localDateTime = LocalDateTime.parse(format + " " + formatter, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        return localDateTime;
    }

    public static String formatLocalDateTimeString1(LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(dtf);
    }

    /**
     * 获取当天开始时间
     *
     * @author lch
     * @date 2019-06-12
     */
    public static LocalDateTime getTodayStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Instant instant = cal.getTime().toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * 获取指定时间的当天开始时间
     *
     * @author lch
     * @date 2019-06-12
     */
    public static LocalDateTime getStartTimeByTime(LocalDateTime time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Instant instant = cal.getTime().toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * 获取昨天开始时间
     *
     * @author lch
     * @date 2019-06-12
     */
    public static LocalDateTime getStartTimeByYestaday() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Instant instant = cal.getTime().toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * 获取当天结束时间
     *
     * @author lch
     * @date 2019-06-12
     */
    public static LocalDateTime getTodayEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        Instant instant = cal.getTime().toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * 获取指定时间的当天结束时间
     *
     * @author lch
     * @date 2019-06-12
     */
    public static LocalDateTime getEndTimeByTime(LocalDateTime time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        Instant instant = cal.getTime().toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * 获取昨天结束时间
     *
     * @author lch
     * @date 2019-06-12
     */
    public static LocalDateTime getEndTimeByYestaday() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        Instant instant = cal.getTime().toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * <pre> Date类型格式化LocalDateTime  </pre>
     *
     * @param date data 类型参数
     * @return java.time.LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @date: 2019/6/12 13:39
     */
    public static LocalDateTime formartDateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }


    /**
     * @MethodName:
     * @description: TODO
     * @author lvqidong
     * @date 2019/7/4 16:04
     */
    public static String parse(Duration d) {
        StringBuilder stringBuilder = new StringBuilder();
        if (d.toDays() > 0) {
            long day = d.toDays();
            stringBuilder.append(d.toDays() + "天");
            d = d.minusDays(day);
        }
        if (d.toHours() > 0) {
            long h = d.toHours();
            String sh = h < 10 ? "" + h : "" + h;
            stringBuilder.append(sh + "小时");
            d = d.minusHours(h);
        }
        if (d.toMinutes() > 0) {
            long min = d.toMinutes();
            String smin = min < 10 ? "" + min : "" + min;
            stringBuilder.append(smin + "分钟");
        }
        return stringBuilder.toString();
    }


    /**
     * @MethodName:
     * @description: TODO
     * @author lvqidong
     * @date 2019/7/4 16:04
     */
    public static String parseDuration(Duration d) {
        StringBuilder stringBuilder = new StringBuilder();
        if (d.toDays() > 0) {
            long day = d.toDays();
            stringBuilder.append(d.toDays() + "天");
            d = d.minusDays(day);
        }
        if (d.toHours() > 0) {
            long h = d.toHours();
            stringBuilder.append(h + "小时");
            d = d.minusHours(h);
        }
        if (d.toMinutes() > 0) {
            long min = d.toMinutes();
            stringBuilder.append(min + "分钟");
        }
        if (StringUtils.isBlank(stringBuilder.toString())) {
            stringBuilder.append("少于1分钟");
        }
        return stringBuilder.toString();
    }


    
    /**
     * 秒转为天时分秒
     * @author   lvqidong
     * @date  2019/12/11 20:02
     * @params second 秒
     * @return str 时间格式
     */
    public static String secToTime(Long second) {
        //转换天数
        long days = second / 86400;
        //剩余秒数
        second = second % 86400;
        //转换小时数
        long hours = second / 3600;
        //剩余秒数
        second = second % 3600;
        //转换分钟
        long minutes = second / 60;
        //剩余秒数
        second = second % 60;
        if (0 < days){
            return days + "天"+hours+"小时"+minutes+"分"+second+"秒";
        }else {
            StringBuilder sb = new StringBuilder();
           if(hours >0){
               sb.append(hours+"小时");
           }
            if(minutes >0){
                sb.append(minutes+"分");
            }if(second>0){
                sb.append(second+"秒");
            }
            return sb.toString();
        }
    }


    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr =  Integer.toString(i);
        }
        else {
            retStr = "" + i;
        }
        return retStr;
    }


//    public static void main(String[] args) throws InterruptedException {
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime endTime1 =  LocalDateTime.parse("2019-12-12 19:56:01",df);
//        LocalDateTime endTime2 =  LocalDateTime.parse("2019-12-11 19:48:19",df);
//        System.out.println(DateUtil.secToTime(DateUtil.getBetweenSeconds(endTime2,endTime1)));
//        System.out.println(DateUtil.getCurrentDateTimeMisStr());
//    }

    /**
     * <pre> 获取今天的日期  </pre>
     *
     * @return java.time.LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @date: 2019/6/12 13:39
     */
    public static String getTodayDateStr() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_PATTERN_YYYYMMDD);
        LocalDateTime time = LocalDateTime.now();
        return df.format(time);
    }

    public static String getLocalDateTimeStr(LocalDateTime dateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        return df.format(dateTime);
    }

    public static String getTodayDateTimeStr() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_PATTERN_YYYYMMDDHHMMSS);
        LocalDateTime time = LocalDateTime.now();
        return df.format(time);
    }

    /**
     * 获取当前时间戳-毫秒
     * @return
     */
    public static String getCurrentDateTimeMisStr(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_PATTERN_YYYYMMDDHHMMSSSSS);
        LocalDateTime time = LocalDateTime.now();
        return df.format(time);
    }

    /**
     * @title: 格式化字符日期格式（从一种字符格式日期转换为指定日期格式字符）
     * @author lcc
     * @date 2019/8/8 11:30
     */
    public static String getStringTime2StringTime(String strTime, String oldFormatter, String newFormatter) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormatter);
        Date d1 = dateFormat.parse(strTime);
        dateFormat = new SimpleDateFormat(newFormatter);
        String time = dateFormat.format(d1);
        return time;
    }

    /**
     * 获取给定时间段数组
     * @param startTime
     * @param endTime
     * @return [2019-08-01,2019-08-02,2019-08-03...]
     */
    public static List<String> getDateStrList(LocalDateTime startTime, LocalDateTime endTime){
        Boolean flag = true;
        List<String> result = new ArrayList<>();
        LocalDateTime tmp = startTime;
        if(startTime.compareTo(endTime)>-1){
            result.add(DateUtil.time2FormatString(endTime,DateUtil.DATE_PATTERN));
            return result;
        }
        while(flag){
            if(DateUtil.time2FormatString(tmp,DateUtil.DATE_PATTERN).equals(DateUtil.time2FormatString(endTime,DateUtil.DATE_PATTERN))){
                flag=false;
                result.add(DateUtil.time2FormatString(tmp,DateUtil.DATE_PATTERN));
            }else{
                result.add(DateUtil.time2FormatString(tmp,DateUtil.DATE_PATTERN));
                tmp=DateUtil.getTimeAddition(tmp,1, ChronoUnit.DAYS);
            }
        }
        return result;
    }
}
