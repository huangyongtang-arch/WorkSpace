package com.example.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicUtils {

	public static Integer obj2Int(Object object){
		if (object==null) {
			return null;
		}
		return (Integer)object;
	}
	
	public static String obj2Str(Object object){
		if (object==null) {
			return null;
		}
		return (String)object;
	}

	/**
	 * 字符串转数值型，如果为空，返回0；
	 * @param str
	 * @return 
	 */
	public static Integer str2Int(String str){
		if (str!=null && !str.equals("")) {
			return Integer.parseInt(str);
		}
		return 0;
	}
	
	/**
	 * 字符串转Long型，如果为空，返回0；
	 * @param str
	 * @return 
	 */
	public static Long str2Long(String str){
		if (str!=null && !str.equals("")) {
			return Long.parseLong(str);
		}
		return 0L;
	}
	
	/**字符串转Long型，如果为空，返回def；**/
	public static Long str2Long(String str,Long def){
		if (str!=null && !str.equals("")) {
			return Long.parseLong(str);
		}else {
			return def;
		}
	}
	
	public static String DATE_FORMAT_DAY = "yyyy-MM-dd";
	public static String DATE_FORMAT_MINUTE = "yyyy-MM-dd HH:mm";
	public static String DATE_FORMAT_SECOND = "yyyy-MM-dd HH:mm:ss";
	
	public static String date2Str(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
