package com.whj.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
    /**
     * 生成随机日期格式
     * @param startTime 结束时间 yyyy-MM-dd hh:mm:ss
     * @param endTime  开始时间 yyyy-MM-dd hh:mm:ss
     * @return String  随机日期格式
     * @throws Exception
     */
    public static String randomTime(String startTime, String endTime) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Long min = df.parse(startTime).getTime();
        Long max = df.parse(endTime).getTime();
        Long random = (long)(Math.random()*(min - (max+1)) + (max+1));
        Date date = new Date(random);
        return String.format("%tF",date)+" "+String.format("%tT",date);
    }

    /**
     * 生成min - max的随机整数
     * @param min
     * @param max
     * @return
     */
    public static int randomUserId(int min,int max){
        return (int)(Math.random()*(min - (max+1)) + (max+1));
    }

    /**
     * 生成min - max的随机小数(最后保留两位小数)
     * @param min
     * @param max
     * @return
     */
    public static double randomTotal(double min,double max){
        double result = (Math.random()*(min - (max+1)) + (max+1));
        BigDecimal a = new BigDecimal(result);
        return a.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
