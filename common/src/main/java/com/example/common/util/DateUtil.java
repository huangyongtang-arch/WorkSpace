package com.example.common.util;

import org.apache.commons.lang3.time.DateUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtil {

	public static final String DATE_DIFF_H = "h";

	public static final int GMT_CHINA_TIME_OFFSET = 8;

	public static DateFormat yyyymmddFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static DateFormat yyyymmddhhmmssFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static DateFormat yyyymmddhhmmFormat = new SimpleDateFormat(
			"yyyyMMddHHmm");

	public static String DEFAULT_DATEPATTERN = "yyyy-MM-dd";

	public static String DEFAULT_TIMEPARTERN = "yyyy-MM-dd HH:mm:ss";

	public static String yyyyMMddHHmm = "yyyyMMddHHmm";

	public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";

	public static String yyyyMMdd = "yyyyMMdd";

	private static DateFormat yyyyMMddFormat = new SimpleDateFormat(yyyyMMdd);

	// 支持转换的日期格式
	public static final DateFormat[] ACCEPT_DATE_FORMATS = { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
			new SimpleDateFormat("yyyy-MM-dd"), new SimpleDateFormat("dd-MM-yyyy"),
			new SimpleDateFormat("MM-dd-yyyy"), new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"),
			new SimpleDateFormat("yyyy/MM/dd") };

	/**
	 * 获得当前日期
	 *
	 * @return
	 */
	public static Date createCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 获得当前日期
	 *
	 * @return
	 */
	public static java.sql.Date createCurrentSQLDate() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	/**
	 * 获得当前钟点时间
	 *
	 * @return
	 */
	public static Time createCurrentTime() {
		return new Time(System.currentTimeMillis());
	}

	/**
	 * 把Date转换成format格式的字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2String(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String s = null;
		if (date != null)
			s = df.format(date);
		else
			s = "";
		return s;
	}

	/**
	 * 获得当前的日期和钟点时间
	 *
	 * @return
	 */
	public static Timestamp createCurrentDateTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 以中国时区为准,获得当前的格林威治时间
	 *
	 * @return
	 */
	public static Timestamp createCurrentGMTTimestamp() {
		return createCurrentGMTTimestamp(GMT_CHINA_TIME_OFFSET);
	}

	/**
	 * 指定小时差来获得当前的格林威治时间
	 *
	 * @param hourOffset
	 * @return
	 */
	public static Timestamp createCurrentGMTTimestamp(int hourOffset) {
		return new Timestamp(System.currentTimeMillis() - DateUtils.MILLIS_PER_HOUR
				* hourOffset);
	}

	/**
	 * 以指定的时把当地时间转换为格林威治时间
	 *
	 * @param gmtTimestamp
	 * @param hourOffset
	 * @return
	 */
	public static Timestamp convertGMTTimestamp(Timestamp gmtTimestamp,
												int hourOffset) {
		return new Timestamp(gmtTimestamp.getTime() + hourOffset
				* DateUtils.MILLIS_PER_HOUR);
	}

	/**
	 * 获得指定的日期
	 *
	 * @param ms
	 *            毫秒
	 * @return
	 */
	public static Date createDate(long ms) {
		return new Date(ms);
	}

	/**
	 * 获得指定的日期
	 *
	 * @param ms
	 *            毫秒
	 * @return
	 */
	public static java.sql.Date createSQLDate(long ms) {
		return new java.sql.Date(ms);
	}

	/**
	 * 获得指定的钟点时间
	 *
	 * @param ms
	 *            毫秒
	 * @return
	 */
	public static Time createTime(long ms) {
		return new Time(ms);
	}

	/**
	 * 获得指定的日期和钟点时间
	 *
	 * @param ms
	 *            毫秒
	 * @return
	 */
	public static Timestamp createDateTime(long ms) {
		return new Timestamp(ms);
	}

	/**
	 * 返回格式: YYYY-MM-DD
	 *
	 * @param date
	 * @return
	 */
	public static synchronized String getDateyyyymmddFormat(Date date) {
		return yyyymmddFormat.format(date);
	}

	/**
	 * 返回格式:YYYY-MM-DD hh:mm:ss
	 *
	 * @param date
	 * @return
	 */
	public static synchronized String getDateyyyymmddhhmmssFormat(Date date) {
		return yyyymmddhhmmssFormat.format(date);
	}

	/**
	 * 返回格式: yyyyMMddHHmm
	 * @return
	 */
	public static synchronized String getDateyyyymmddhhmmFormat() {
		return yyyymmddhhmmFormat.format(new Date());
	}

	/**
	 * 根据传入的时间返回以yyyyMMddHHmm为格式的字符串
	 * @param date
	 * 		需要转换的日期
	 * @return
	 */
	public static String getString_yyyyMMddHHmmByDate(Date date) {
		return yyyymmddhhmmFormat.format(date);
	}

	/**
	 * 返回格式：yyyyMMdd
	 * @param date
	 * @return
	 */
	public static String getString_yyyyMMddByDate(Date date) {
		return yyyyMMddFormat.format(date);
	}

	public static String getStringByDateAndFormat(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * Description: 得到返回日期 getReturnDate("20030130" ,31)得到"20030302"
	 * getReturnDate("20021230",60)得到 "20030228"
	 *
	 * @param: dateStr 字符串日期 如"20030301"
	 * @param: keep_day 保存天数
	 * @return: String
	 */
	public static String getReturnDate(String dateStr, int keep_day) {
		int iYear = Integer.parseInt(dateStr.substring(0, 4));
		int iMonth = Integer.parseInt(dateStr.substring(4, 6));
		int iDay = Integer.parseInt(dateStr.substring(6));
		iDay = iDay + keep_day;
		while (true) {
			if ((iMonth == 1 || iMonth == 3 || iMonth == 7 || iMonth == 8
					|| iMonth == 10 || iMonth == 12)) {
				if (iDay > 31) {
					iDay = iDay - 31;
					if (iMonth == 12) {
						iYear = iYear + 1;
						iMonth = 1;
					} else {
						iMonth++;
					}
				} else
					break;
			} else if ((iMonth == 4 || iMonth == 6 || iMonth == 9 || iMonth == 11)) {
				if (iDay > 30) {
					iDay = iDay - 30;
					iMonth++;
				} else
					break;
			} else {
				if (iYear % 4 == 0)
					if (iDay > 29)
						iDay = iDay - 29;
					else
						break;
				else if (iYear % 4 != 0) {
					if (iDay > 28)
						iDay = iDay - 28;
					else
						break;
				}
				iMonth++;
			}
		}
		String str = String.valueOf(iYear);
		if (iMonth < 10)
			str = str + "0" + String.valueOf(iMonth);
		else
			str = str + String.valueOf(iMonth);
		if (iDay < 10)
			str = str + "0" + String.valueOf(iDay);
		else
			str = str + String.valueOf(iDay);
		return str;
	}

	/**
	 * Description 字符串日期比较函数,例如 compareDate("20030228","20030301")得到1
	 * compareDate("20000301","20000228")得到-2
	 *
	 * @param: startDate 起始日
	 * @param: endDate 中止日
	 * @return: int
	 */
	public static int compareDate(String startDate, String endDate) {
		int startYear = Integer.parseInt(startDate.substring(0, 4));
		int startMonth = Integer.parseInt(startDate.substring(4, 6));
		int startDay = Integer.parseInt(startDate.substring(6));
		int endYear = Integer.parseInt(endDate.substring(0, 4));
		int endMonth = Integer.parseInt(endDate.substring(4, 6));
		int endDay = Integer.parseInt(endDate.substring(6));
		int sYear, sMonth, sDay;
		if (startDate.compareTo(endDate) > 0) { // 如果起始日期大于终止日期，换位置
			sYear = startYear;
			sMonth = startMonth;
			sDay = startDay;
			startYear = endYear;
			startMonth = endMonth;
			startDay = endDay;
			endYear = sYear;
			endMonth = sMonth;
			endDay = sDay;
		}
		int diff = 0;
		for (int i = startMonth, j = startYear; (j < endYear) || (i < endMonth)
				&& (j == endYear); i++)
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10
					|| i == 12) {
				diff = diff + 31;
				if (i == 12) {
					i = 0;
					j = j + 1;
				}
			} else if (i != 2) {
				diff = diff + 30;
			} else {
				if (j % 4 == 0)
					diff = diff + 29; // 润年加29
				else
					diff = diff + 28; // 平年加28
			}
		diff = diff + (endDay - startDay);
		if (startDate.compareTo(endDate) < 0)
			return diff;
		else
			return -diff;
	}

	/**
	 * 日期比较
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int compareTime(String startDate, String endDate) {
		int i_len = 0;
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date beginDay = formatter.parse(startDate);
			Date endDay = formatter.parse(endDate);
			i_len = beginDay.compareTo(endDay);
		} catch (Exception e) {
			System.out.println(e);
		}
		return i_len;
	}

	/**
	 * 获取制定当前日期前、后第几天的日期
	 *
	 * @param strDate
	 *            当前日期
	 * @param changeValue
	 *            前后几天
	 * @return
	 */
	public static String getLimitDate(String strDate, int changeValue) {
		String str_temp = "";
		try {
			Calendar cal = Calendar.getInstance();
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date curDay = formatter.parse(strDate);
			cal.setTime(curDay);
			cal.add(Calendar.DATE, changeValue);
			curDay = cal.getTime();
			str_temp = formatter.format(curDay);
		} catch (Exception e) {
			str_temp = "";
		}
		return str_temp;
	}

	/**
	 * 为某个date添加n天。
	 * @param curDay
	 * @param changeValue
	 * @return
	 */
	public static Date getLimitDate(Date curDay, int changeValue) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(curDay);
			cal.add(Calendar.DATE, changeValue);
			curDay = cal.getTime();
		} catch (Exception e) {
			return null;
		}
		return curDay;
	}

	/**
	 * 为某个date添加n小时。
	 * @param curDay
	 * @return
	 */
	public static Date getLimitDateAddHour(Date curDay, int hour) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(curDay);
			calendar.add(Calendar.HOUR_OF_DAY,hour);
			curDay = calendar.getTime();
		} catch (Exception e) {
			return null;
		}
		return curDay;
	}

	/**
	 * 获取当前年分
	 *
	 * @return 当前年份
	 */
	public static int getCurYear() {
		int curYear;
		Calendar cal = Calendar.getInstance();
		curYear = cal.get(Calendar.YEAR);
		return (curYear);
	}

	/**
	 * 获取当前月份
	 *
	 * @return 当前月份
	 */
	public static int getCurMonth() {
		int curMonth;
		Calendar cal = Calendar.getInstance();
		curMonth = cal.get(Calendar.MONTH) + 1;
		return (curMonth);
	}

	/**
	 * 获取当前日
	 *
	 * @return 当前日
	 */
	public static int getCurDay() {
		int curDay;
		Calendar cal = Calendar.getInstance();
		curDay = cal.get(Calendar.DAY_OF_MONTH);
		return (curDay);

	}

	/**
	 *
	 * @param curDay
	 * @param changeValue
	 * @return
	 */
	public static Date getLastMouth(Date curDay, int changeValue) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(curDay);
			cal.add(Calendar.MONTH, changeValue);
			curDay = cal.getTime();
		} catch (Exception e) {
			return null;
		}
		return curDay;
	}

	/*
	 * parmater time:20040830 return 2004年8月30日X时X分X秒
	 */

	public static String FormatToDetailDate(String time) {
		if ("".equals(time)) {
			return "";
		}
		String dYear = time.substring(0, 4) + "年";
		String dMon = time.substring(4, 6) + "月";
		String dDay = time.substring(6, 8) + "日";
		String dHour = time.substring(8, 10) + "时";
		String dMin = time.substring(10, 12) + "分";
		String dSec = time.substring(12, 14) + "秒";
		String da = dYear + dMon + dDay + dHour + dMin + dSec;
		return da;
	}

	/*
	 * parmater time:2004-12-15 parmater i_short: 0,1,2 return 2004年12月15日
	 * 星期三(i_short==0),2004年12月15日(i_short==1),星期三(i_short==2)
	 */

	public static String FormatToDates(String time, int i_short) {

		if ("".equals(time)) {
			return "";
		}
		String dYear = time.substring(0, 4) + "年";
		String dMon = time.substring(5, 7) + "月";
		String dDay = time.substring(8, time.length()) + "日";
		java.sql.Date it = java.sql.Date.valueOf(time);
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(it.getTime());
		int weekday = cal.get(Calendar.DAY_OF_WEEK);

		String strReturn = "";
		switch (weekday) {
			case 1:
				strReturn = "星期日";
				break;
			case 2:
				strReturn = "星期一";
				break;
			case 3:
				strReturn = "星期二";
				break;
			case 4:
				strReturn = "星期三";
				break;
			case 5:
				strReturn = "星期四";
				break;
			case 6:
				strReturn = "星期五";
				break;
			case 7:
				strReturn = "星期六";
				break;
		}

		String da = "";
		if (i_short == 0) {
			da = dYear + dMon + dDay + " " + strReturn;
		}
		if (i_short == 1) {
			da = dYear + dMon + dDay;
		}
		if (i_short == 2) {
			da = strReturn;
		}
		return da;
	}

	// ************* lxy add ***********//
	/**
	 * //1星期日 2星期一 3星期二 4星期三 5星期四 6星期五 0星期六 根据当天日期得到星期几
	 *
	 * @return int
	 */
	public static int getWeekByDate() {
		// 根据当天得到星期几
		GregorianCalendar now = new GregorianCalendar();
		int iWeek = now.get(7);
		return iWeek;
	}

	/**
	 *得到指定日期 依次类推...,如-1得到昨天的日期
	 * @param i int
	 * @return String
	 */
	public static String getDateByNowDate(int i) {
		//-1得到昨天日期 依次类推...
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, i);
		String rtDay = new SimpleDateFormat(DEFAULT_DATEPATTERN).format(cal.getTime());
		return rtDay;
	}

	/**
	 *得到指定日期 依次类推...,如-1得到昨天的日期
	 * @param i int
	 * @return String
	 */
	public static String getDateByNowDate2(int i) {
		//-1得到昨天日期 依次类推...
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, i);
		String rtDay = new SimpleDateFormat(DEFAULT_TIMEPARTERN).format(cal.getTime());
		return rtDay;
	}

	/**
	 * 得到今天日期
	 *
	 * @return
	 */
	public static String getNowDate() {
		Calendar todayCal = Calendar.getInstance();
		String today = new SimpleDateFormat(DEFAULT_DATEPATTERN)
				.format(todayCal.getTime());
		return today;
	}

	/**
	 * 得到今天日期
	 *
	 * @return
	 */
	public static String getNowDate3() {
		Calendar todayCal = Calendar.getInstance();
		String today = new SimpleDateFormat("yyyy/MM/dd")
				.format(todayCal.getTime());
		return today;
	}

	/**
	 * 得到今天日期
	 *
	 * @return
	 */
	public static String getNowHourMinitesSecords() {
		Calendar todayCal = Calendar.getInstance();
		String today = new SimpleDateFormat("HH:mm:ss")
				.format(todayCal.getTime());
		return today;
	}

	/**
	 * 得到今天日期
	 *
	 * @return
	 */
	public static String getNowDate2() {
		Calendar todayCal = Calendar.getInstance();
		String today = new SimpleDateFormat(DEFAULT_TIMEPARTERN)
				.format(todayCal.getTime());
		return today;
	}

	/**
	 * //1星期日 2星期一 3星期二 4星期三 5星期四 6星期五 0星期六 根据给定的日期得到星期几
	 *
	 * @param date
	 *            String
	 * @return int
	 */
	public static int getDayOfWeek(String date, String separator) {
		GregorianCalendar now = null;
		if (date != null && !date.equals("")) {
			now = getDateObj(date, separator);
		} else {
			now = new GregorianCalendar();
		}
		int day = now.get(7);
		return day;
	}

	public static String monthAfter(String date, int month, String separator) {
		GregorianCalendar now = null;
		if (date == null || date.length() < 10) {
			now = getDateObj(null, separator);
		} else {
			now = getDateObj(date, separator);
		}
		now.add(2, month);
		return getNowD(now);
	}

	public static String getNowD(GregorianCalendar now) {
		if (now != null) {
			String res = new SimpleDateFormat(DEFAULT_DATEPATTERN).format(now
					.getTime());
			return res;
		} else {
			String res = new SimpleDateFormat(DEFAULT_DATEPATTERN)
					.format(Calendar.getInstance().getTime());
			return res;
		}
	}

	/**
	 * 根据传入时间，与分隔符，返回GregorianCalendar
	 *
	 * @param date
	 *            String
	 * @param separator
	 *            String
	 * @return GregorianCalendar
	 */
	public static GregorianCalendar getDateObj(String date, String separator) {
		GregorianCalendar now = new GregorianCalendar();
		if (isValidDate(date, separator)) {
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(5, 7));
			int day = Integer.parseInt(date.substring(8, 10));
			now.set(1, year);
			now.set(2, month - 1);
			now.set(5, day);
		}
		return now;
	}

	/**
	 * 检验日期合法性
	 *
	 * @param date
	 *            String
	 * @param separator
	 *            String
	 * @return boolean
	 */
	public static boolean isValidDate(String date, String separator) {
		if (date == null) {
			return false;
		}
		int sizes = date.length();
		if (sizes != 10) {
			return false;
		}
		char sep = separator.charAt(0);
		for (int i = 0; i < sizes; i++) {
			char ch = date.charAt(i);
			switch (i) {
				default:
					break;

				case 0: // '\0'
				case 1: // '\001'
				case 2: // '\002'
				case 3: // '\003'
				case 5: // '\005'
				case 6: // '\006'
				case 8: // '\b'
				case 9: // '\t'
					if (ch < '0' || ch > '9') {
						return false;
					}
					break;

				case 4: // '\004'
				case 7: // '\007'
					if (ch != sep) {
						return false;
					}
					break;
			}
		}

		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));
		return isValidDate(year, month, day);
	}

	/**
	 * 根据年月日，检验其合法性
	 *
	 * @param year
	 *            int
	 * @param month
	 *            int
	 * @param day
	 *            int
	 * @return boolean
	 */
	public static boolean isValidDate(int year, int month, int day) {
		if (year < 1900 || year > 9999) {
			return false;
		}
		if (month < 1 || month > 12) {
			return false;
		}
		GregorianCalendar now = new GregorianCalendar();
		boolean leapyear = now.isLeapYear(year);
		if (day < 1 || day > 31) {
			return false;
		}
		if (month == 2) {
			if (leapyear && day > 29) {
				return false;
			}
			if (!leapyear && day > 28) {
				return false;
			}
		}
		return month != 4 && month != 6 && month != 9 && month != 11
				|| day != 31;
	}

	public static String[] getAmongDates(Date date) throws Exception{
		int count = new Date().compareTo(date);
		String[] dates = null;
		if(count > 0){
			dates = new String[count - 1];
		}
		return dates;
	}

	public static Date stringToDate(String strDate,String format){
		Date date = null;
		strDate = split(strDate);
		SimpleDateFormat sim = new SimpleDateFormat(format);
		try {
			date = sim.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	private static String split(String str){
		String[] str_list = str.split(" ");
		String s = str_list[0];
		int length = s.length();
		if(length == 8){
			String year = s.substring(0, 4);
			String month = s.substring(4, 6);
			String date = s.substring(6, 8);
			return  year+"-"+month+"-"+date+" "+str_list[1];
		}
		return str;
	}

	/**
	 * 计算两个日期中间相隔的多少个小时或者分钟
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param format 日期格式
	 * @param str  代表返回的是小时还是分钟。小时用'h'表示，其他数值都代表分钟s
	 * @return
	 */
	public static   Long dateDiff(String startTime, String endTime,  String format, String str) {
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数
		long diff;
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		// 获得两个时间的毫秒时间差异
		try {
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			day = diff / nd;// 计算差多少天
			hour = diff % nd / nh + day * 24;// 计算差多少小时
			min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
			sec = diff % nd % nh % nm / ns;// 计算差多少秒
			// 输出结果
           /* System.out.println("时间相差：" + day + "天" + (hour - day * 24) + "小时"
                    + (min - day * 24 * 60) + "分钟" + sec + "秒。");
            System.out.println("hour=" + hour + ",min=" + min);*/
			if (str.equalsIgnoreCase("h")) {
				return hour;
			} else {
				return min;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (str.equalsIgnoreCase("h")) {
			return hour;
		} else {
			return min;
		}
	}

	public static boolean isContinuous(long intervalMills, Date... dates) {
		if (dates != null && dates.length >= 2) {
			for(int i = 0; i < dates.length - 1; ++i) {
				if (dates[i] == null) {
					return false;
				}

				Date adate = dates[i];
				Date bdate = dates[i + 1];
				long atime = adate.getTime();
				long btime = bdate.getTime();
				if (btime - atime > intervalMills) {
					return false;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 * @param startTimeStr   当前时间
	 * @param endTimeStr	开始时间
	 * @return
	 * @author sunran   判断当前时间在时间区间内
	 */
	public static boolean isEffectiveDate(String startTimeStr, String endTimeStr) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat(DEFAULT_TIMEPARTERN);
			Date startTime = ft.parse(startTimeStr);
			Date endTime = ft.parse(endTimeStr);
			Date nowTime = new Date();

			if (nowTime.getTime() == startTime.getTime()
					|| nowTime.getTime() == endTime.getTime()) {
				return true;
			}

			Calendar date = Calendar.getInstance();
			date.setTime(nowTime);

			Calendar begin = Calendar.getInstance();
			begin.setTime(startTime);

			Calendar end = Calendar.getInstance();
			end.setTime(endTime);

			if (date.after(begin) && date.before(end)) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 *
	 * @param startTimeStr   当前时间
	 * @return
	 * @author sunran   判断当前时间在时间区间内
	 */
	public static boolean isBeginDate(String startTimeStr) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
			Date startTime = ft.parse(startTimeStr);
			Date nowTime = new Date();

			if (nowTime.getTime() == startTime.getTime()) {
				return true;
			}

			Calendar date = Calendar.getInstance();
			date.setTime(nowTime);

			Calendar begin = Calendar.getInstance();
			begin.setTime(startTime);

			if (date.after(begin)) {
				return true;
			} else {
				return false;
			}
		}catch (ParseException e){
			return false;
		}
	}

	/**
	 *
	 * @param endTimeStr   当前时间
	 * @return
	 * @author sunran   判断当前时间在时间区间内
	 */
	public static boolean isAfterDate(String endTimeStr) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
			Date endTime = ft.parse(endTimeStr);
			Date nowTime = new Date();

			Calendar date = Calendar.getInstance();
			date.setTime(nowTime);

			Calendar end = Calendar.getInstance();
			end.setTime(endTime);

			if (date.before(end)) {
				return true;
			} else {
				return false;
			}
		}catch (ParseException e){
			return false;
		}
	}

}
