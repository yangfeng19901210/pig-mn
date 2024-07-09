package com.yf.util;

import com.yf.enums.DateTimeTypeEnum;
import io.gitee.loulan_yxq.owner.core.collection.ArrayTool;
import io.gitee.loulan_yxq.owner.core.collection.CollTool;
import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/*********************************************************
 **
 ** <br><br>
 ** @author: yangfeng
 ** @date: 2023/10/30 11:40
 ** @version: 1.0.0
 *********************************************************/
@Slf4j
public class DateTimeUtils {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
//        String type = DateTimeTypeEnum.BEFORETHIRTY.getName();
//        LocalDateTime[] dateTimes = getDateTimes(type);
//        log.info("类型为{} 开始时间{} 结束时间{}",type,dateTimes[0],dateTimes[1]);
        String name = "yesterday";
        DateTimeTypeEnum dateTimeTypeEnum = DateTimeTypeEnum.getByName(name);
        System.out.println(dateTimeTypeEnum);

    }

    public static String getStartOrEndDayOfQuarter(LocalDate today, Boolean isFirst){
        LocalDate resDate = LocalDate.now();
        if (today == null) {
            today = resDate;
        }
        Month month = today.getMonth();
        Month firstMonthOfQuarter = month.firstMonthOfQuarter();
        Month endMonthOfQuarter = Month.of(firstMonthOfQuarter.getValue() + 2);
        if (isFirst) {
            resDate = LocalDate.of(today.getYear(), firstMonthOfQuarter, 1);
        } else {
            resDate = LocalDate.of(today.getYear(), endMonthOfQuarter, endMonthOfQuarter.length(today.isLeapYear()));
        }
        return resDate.toString();
    }
    /**
     * 获取当天开始时间
     * @Param []
     * @return java.time.LocalDateTime
     * @Date 20:49 2023/12/9
     * @Author yangfeng
     **/
    public static LocalDateTime getCurrentStartTime(){
        LocalDate now = LocalDate.now();
        // 当天开始时间
        LocalDateTime todayStart = now.atStartOfDay();
        return  todayStart;
    }
    /**
     * 获取当天结束时间
     * @Param []
     * @return java.time.LocalDateTime
     * @Date 20:51 2023/12/9
     * @Author yangfeng
     **/
    public static LocalDateTime getCurrentEndTime(){
        LocalDate now = LocalDate.now();
        // 当天结束时间
        LocalDateTime todayEnd = LocalDateTime.of(now, LocalTime.MAX);
        return  todayEnd;
    }
    /**
     * 获取本周开始时间
     * @Param []
     * @return java.time.LocalDateTime
     * @Date 20:55 2023/12/9
     * @Author yangfeng
     **/
    public static LocalDateTime getWeekStartTime(){
        LocalDate now = LocalDate.now();
        // 周一
        LocalDate monday = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        // 本周开始时间
        LocalDateTime weekStart = monday.atStartOfDay();
        return weekStart;
    }
    /**
     * 获取本周结束时间
     * @Param []
     * @return java.time.LocalDateTime
     * @Date 20:57 2023/12/9
     * @Author yangfeng
     **/
    public static LocalDateTime getWeekEndTime(){
        LocalDate now = LocalDate.now();
        // 周日
        LocalDate sunday = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        // 本周结束时间
        LocalDateTime weekEnd = LocalDateTime.of(sunday, LocalTime.MAX);
        return weekEnd;
    }
    /**
     * 获取本月开始时间
     * @Param []
     * @return java.time.LocalDateTime
     * @Date 21:00 2023/12/9
     * @Author yangfeng
     **/
    public static LocalDateTime getMonthStartTime(){
        LocalDate now = LocalDate.now();
        // 本月1号
        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());

        // 本月1号的开始时间
        LocalDateTime firstDayOfMonthStart = firstDayOfMonth.atStartOfDay();
        return firstDayOfMonthStart;
    }
    /**
     * 获取本月最后一天
     * @Param []
     * @return java.time.LocalDateTime
     * @Date 21:02 2023/12/9
     * @Author yangfeng
     **/
    public static LocalDateTime getMonthEndTime(){
        LocalDate now = LocalDate.now();
        // 本月最后一天
        LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());

        // 本月最后一天的最后时间
        LocalDateTime firstDayOfMonthEnd = LocalDateTime.of(lastDayOfMonth, LocalTime.MAX);
        return firstDayOfMonthEnd;
    }
    /**
     * 获取本季度开始时间
     * @Param []
     * @return java.time.LocalDateTime
     * @Date 21:11 2023/12/9
     * @Author yangfeng
     **/
    public static LocalDateTime getQuarterStartTime(){
        // 获取当天日期
        LocalDate now = LocalDate.now();
        Month month = now.getMonth();
        Month firstMonthOfQuarter = month.firstMonthOfQuarter();
        LocalDateTime quarterStartTime = LocalDateTime.of(now.getYear(), firstMonthOfQuarter, 1, 0, 0, 0);
        return quarterStartTime;
    }
    /**
     * 获取本季度结束时间
     * @Param []
     * @return java.time.LocalDateTime
     * @Date 21:15 2023/12/9
     * @Author yangfeng
     **/
    public static LocalDateTime getQuarterEndTime(){
        // 获取当天日期
        LocalDate now = LocalDate.now();
        Month month = now.getMonth();
        Month firstMonthOfQuarter = month.firstMonthOfQuarter();
        Month endMonthOfQuarter = Month.of(firstMonthOfQuarter.getValue() + 2);
        LocalDateTime quarterEndTime = LocalDateTime.of(now.getYear(), endMonthOfQuarter, endMonthOfQuarter.length(now.isLeapYear()), 23, 59, 59);
        return quarterEndTime;
    }
    /**
     * 获取本年度开始时间
     * @Param []
     * @return java.time.LocalDateTime
     * @Date 21:16 2023/12/9
     * @Author yangfeng
     **/
    public static LocalDateTime getYearStartTime(){
        // 今年第一天
        LocalDate firstDayOfYear = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());

        // 本年度1号的开始时间
        LocalDateTime firstDayOfYearStart = firstDayOfYear.atStartOfDay();
        return firstDayOfYearStart;
    }
    /**
     * 获取本年度最后一天
     * @Param []
     * @return java.time.LocalDateTime
     * @Date 21:19 2023/12/9
     * @Author yangfeng
     **/
    public static LocalDateTime getYearEndTime(){
        // 今年最后一天
        LocalDate lastDayOfYear = LocalDate.now().with(TemporalAdjusters.lastDayOfYear());
        // 本年度最后时间
        LocalDateTime firstDayOfYearEnd = LocalDateTime.of(lastDayOfYear, LocalTime.MAX);
        return firstDayOfYearEnd;

    }
    /**
     * 获取两个时间节点相差的毫秒数
     * @Param [start, end]
     * @return long
     * @Date 21:32 2023/12/9
     * @Author yangfeng
     **/
    public static long getTwoTimeDifferMillis(LocalDateTime start,LocalDateTime end){
        return Duration.between(start, end).toMillis();
    }

    public static LocalDateTime[] getDateTimes(String type){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime[] dtArr = new LocalDateTime[2];
        if(type.equals(DateTimeTypeEnum.TODAY.getName())){
            dtArr[0] = getCurrentStartTime();
            dtArr[1] = getCurrentEndTime();

        }else if(type.equals(DateTimeTypeEnum.YESTERDAY.getName())){
            dtArr[0] = getCurrentStartTime().minusDays(1);
            dtArr[1] = getCurrentEndTime().minusDays(1);
        }else if(type.equals(DateTimeTypeEnum.BEFORESEVEN.getName())){
            dtArr[0] = now.minusDays(7);
            dtArr[1] = now;
        }else if(type.equals(DateTimeTypeEnum.CURRENTMONTH.getName())){
            dtArr[0] = getMonthStartTime();
            dtArr[1] = getMonthEndTime();
        }else if(type.equals(DateTimeTypeEnum.BEFORETHIRTY.getName())){
            dtArr[0] = now.minusDays(30);
            dtArr[1] = now;
        }
        return dtArr;
    }
    public static String[] getStrDateTimes(String type){
        String[] strArr = new String[2];
        LocalDateTime[] dateTimes = getDateTimes(type);
        if(ArrayTool.isNotEmpty(dateTimes) && dateTimes.length==2){
            strArr[0] = dateTimes[0].format(formatter);
            strArr[1] = dateTimes[1].format(formatter);
        }
        return strArr;
    }

    public static String getCurrentTime(){
        return LocalDateTime.now().format(formatter);
    }




}

