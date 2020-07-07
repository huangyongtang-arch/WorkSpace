package com.example.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  Ocean
 * Date  :  19-2-27
 */
public class StringUtils {
    /**
     * 从字符串删除指定的子字符串
     * @param old 原字符串
     * @param sub 要删除的子字符串
     * @return 新的字符串
     */
    public static String removeSubString(String old, String sub) {
        String[] arr = old.split(",");
        List<String> m = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {//add进ArrayList数组
            m.add(arr[i].trim());
        }

        for (int i = 0; i < m.size(); i++) {//用ArrayList的remove功能，移除指定字符
            if ("d".equals(m.get(i))) {
                m.remove(i);
            }
        }

        String s1 = m.toString();
        String s2 = s1.substring(1, s1.length() - 1) + ",";//去除首尾[]符号，并加上”，“号
        return s2.replaceAll(" ", "");
    }

    /**
     * 判断字符串是否为空，且内容是否为 "null"
     *
     * @param value String
     * @return true:${value} 不为空且不为 "null"，否则返回 false
     */
    public static boolean isValid(String value) {
        return org.apache.commons.lang3.StringUtils.isNotEmpty(value) && !"null".equals(value);
    }
}
