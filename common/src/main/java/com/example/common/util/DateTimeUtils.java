package com.example.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期与时间的帮助类，提供静态方法，不可以实例化。
 * 
 * @author Owen Lin
 * 
 */
public class DateTimeUtils {
	/**
	 * 禁止实例化
	 */
	private DateTimeUtils() {
	}
	public static String YYYYMMDDHHMMSS="yyyy-MM-dd HH:mm:ss";

	public static String YYYYMMDD="yyyy-MM-dd";

	private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeUtils.class);

	public static Date switchDate(String startDate) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			dt = sdf.parse(startDate);
		} catch (Exception e) {
			LOGGER.debug("switchDate Exception:{}",e);
		}
		return dt;
	}

	/**
	 * 格式化日期为指定格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date formatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String currentsysdate = sdf.format(date);
		Date dt = new Date();
		try {
			dt = sdf.parse(currentsysdate);
		} catch (Exception e) {
			LOGGER.error("formatDate Exception:{}",e);
		}
		return dt;
	}

	/**
	 * 格式化日期为指定格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date formatDate(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dt = new Date();
		try {
			dt = sdf.parse(date);
		} catch (Exception e) {
			LOGGER.error("formatDate Exception:{}",e);
		}
		return dt;
	}

	/**
	 * 格式化日期为指定格式，并转换为字符串输出
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDateStr(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String currentsysdate = sdf.format(date);

		return currentsysdate;
	}

	/**
	 * 获取随机数字符串
	 * 
	 * @param seed
	 *            随机种子
	 * @return 随机数字符串
	 */
	private static String getRandomStr(Integer seed) {
		Random ran = new Random();
		if (seed == null) {
			seed = ran.nextInt(999999999);
		}
		String newSeed = System.currentTimeMillis() + "" + Math.abs(ran.nextInt(1999999999) + ran.nextInt(1999999999)) + seed.toString();
		if (newSeed.length() > 18) {
			newSeed = newSeed.substring(9, 17) + newSeed.substring(newSeed.length() - 10);
		}
		Random random = new Random(new Long(newSeed));
		return ("" + Math.abs(random.nextLong()));
	}

	/**
	 * 获取 length 位数的随机码（纯数字）
	 * 
	 * @param seed
	 *            随机种子
	 * @param length
	 *            随机数位数(max = 18)
	 * @return length 位数的随机码（纯数字）
	 */
	public static final String getRandomCode(Integer seed, Integer length) {
		length = length > 18 ? 18 : length;
		String code = getRandomStr(seed);
		if (code.length() > length) {
			return code.substring(code.length() - length);
		}
		return code;
	}

	/**
	 * 获取 length 位数的随机码（纯数字）
	 * 
	 * @param length
	 *            随机数位数(max = 18)
	 * @return length 位数的随机码（纯数字）
	 */
	public static final String getRandomCode(Integer length) {
		length = length > 18 ? 18 : length;
		String code = getRandomStr(null);
		if (code.length() > length) {
			return code.substring(code.length() - length);
		}
		return code;
	}

	/**
	 * 根据当前时间获取第i天（日期时间）
	 * 
	 * @param i
	 *            （i为0时则获取当天）
	 * @param format
	 *            日期格式
	 * 
	 * @return
	 */
	public static String getDate(int i, String format) {
		Date tomorrow = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * i);
		DateFormat df = new SimpleDateFormat(format);
		return df.format(tomorrow);
	}
	
	/**
	 * 根据指定时间获取第i天（日期时间）
	 * 
	 * @param i
	 *            （i为0时则获取当天）
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static String getDateByTime(int i, String format,Date dateTime) {
		Date tomorrow = new Date(dateTime.getTime() + 1000 * 60 * 60 * 24 * i);
		DateFormat df = new SimpleDateFormat(format);
		return df.format(tomorrow);
	}
	
	/**
	 * 生成时间字符串
	 * @return
	 */
	public synchronized static final String createSerialSecondTimeString() {
		StringBuffer sb = new StringBuffer();
		Random ran = new Random();
		sb.append(getDate(0, "MMddHHmmssSSS")).append(ran.nextInt(10));
		return sb.toString();
	}
	
	/**
	 * 生成时间字符串
	 * @return
	 */
	public synchronized static final String createSerialMiroSecondTimeString() {
		StringBuffer sb = new StringBuffer();
		Random ran = new Random();
		sb.append(getDate(0, "yyyyMMddHHmmssSSS")).append(ran.nextInt(100));
		return sb.toString();
	}

	/**
	 * 生成时间字符串
	 * @return
	 */
	public synchronized static final String createSerialString() {
		StringBuffer sb = new StringBuffer();
		String s = String.format("%04d", getOrder());

		sb.append(new SimpleDateFormat("yyyyMMdd").format(new Date()) + s);
		return sb.toString();
	}

	public static int order = 1;
	public synchronized static int getOrder(){
		if(order >= 9999){
			order = 1;
		}
		return order++;
	}


	/**
	 * 根据日期获取这一周的日期
	 * 从周日到周六为一周
	 * @return
	 */
	public static List<Date> dateToWeek() {
		Date date = new Date();
		int b = date.getDay();
		Date fdate;
		List<Date> list = new ArrayList<Date>();
		Long fTime = date.getTime() - b * 24 * 3600000;
		for (int a = 0; a <= 6; a++) {
			fdate = new Date();
			fdate.setTime(fTime + (a * 24 * 3600000));
			list.add(a, fdate);
		}
		return list;
	}

	/**
	 * 根据日期获取这一周的日期
	 * 从周一到周日为一周
	 * @return
	 */
	public static List<Date> getThisWeek() {
		Calendar c = Calendar.getInstance();
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week + 1);
		Calendar c1 = Calendar.getInstance();
		int day_of_week1 = c1.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week1 == 0)
			day_of_week1 = 7;
		c1.add(Calendar.DATE, -day_of_week1 + 7);
		List<Date> list = new ArrayList<Date>();
		list.add(c.getTime());
		list.add(c1.getTime());
		return list;
	}

	/**
	 * 根据日期获取这一月的日期
	 * 从1号到30号或者31号
	 * @return
	 */
	public static List<Date> dateToMonth() {
		List<Date> list = new ArrayList<Date>();
		list.add(DateTimeUtils.dateToOneDay());
		list.add(DateTimeUtils.dateToLastDay());
		return list;
	}

	/**
	 * 根据日期获取当月的第一天的日期
	 * 1号
	 * @return
	 */
	public static Date dateToOneDay(){
		Calendar   cal_1=Calendar.getInstance();//获取当前日期 
		cal_1.add(Calendar.MONTH, 0);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		cal_1.set(Calendar.HOUR_OF_DAY, 0);
		cal_1.set(Calendar.SECOND,0);
		cal_1.set(Calendar.MINUTE,0);
		return cal_1.getTime();
	}

	/**
	 * 根据日期获取当月的最后一天的日期
	 * 30号或者31号
	 * @return
	 */
	public static Date dateToLastDay(){
		Calendar c = Calendar.getInstance();    
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.SECOND,59);
		c.set(Calendar.MINUTE,59);
		return c.getTime();
	}
	
	
	
	/**
	 * 根据日期获取当月的最后一天的日期
	 * 30号或者31号
	 * @return
	 */
	public static Date dateToLastDay(int month){
		Calendar c = Calendar.getInstance(); 
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.SECOND,59);
		c.set(Calendar.MINUTE,59);
		return c.getTime();
	}
	
	/**
	 * 根据日期获取星期几
	 * @param date
	 * @return
	 */
	public static int getWeekOfDate(Date date){
		Calendar calendar = Calendar.getInstance();      
	    calendar.setTime(date);      
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;    
	}
	
	public static void main(String[] args) {
		
		System.out.println("ret="+ formatDateStr(dateToLastDay(4),YYYYMMDDHHMMSS));
	}
}
