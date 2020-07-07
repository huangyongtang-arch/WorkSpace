package com.example.common.util;

public class Unicode {

    /**
     * unicode 转字符串
     */
    public static String decode(String unicode) {
     
    	if (unicode==null) {
			return null;
		}
    	
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
     
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }
    
    /**
     * 字符串转换unicode
     */
    public static String encode(String string) {

    	if (string==null) {
			return null;
		}
        StringBuffer unicode = new StringBuffer();
     
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }
}
