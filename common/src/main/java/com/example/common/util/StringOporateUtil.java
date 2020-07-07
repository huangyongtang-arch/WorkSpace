
package com.example.common.util;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ocean 2015年11月30日
 */
public class StringOporateUtil {

    /**
     * 如果字符串为空或者等于 "null" ，那么返回给定的 ${defaultValue}，
     * 否则返回字符串本身
     *
     * @param value        String
     * @param defaultValue String
     * @return String
     */
    public static String getValidValue(String value, String defaultValue) {
        if (value == null || value.equals("null")) {
            return defaultValue;
        } else {
            return value;
        }
    }

    public static boolean isEmpty(String value) {
        return value == null || value.length() < 1;
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    /**
     * 判断字符串是否为空，且内容是否为 "null"
     *
     * @param value String
     * @return true:${value} 不为空且不为 "null"，否则返回 false
     */
    public static boolean isValid(String value) {
        return isNotEmpty(value) && !"null".equals(value);
    }

    /**
     * 16进制数取反
     *
     * @param Str
     * @return
     */
    public static String invertHex(String Str) {
        String tmpStr = Str.toUpperCase().replace("0X", "");
        StringBuilder outStr = new StringBuilder();

        for (int i = 0; i < tmpStr.length(); i++) {
            char c = tmpStr.charAt(i);
            int tmpInt = 0;
            tmpInt = c - 48;
            tmpInt = tmpInt > 9 ? tmpInt - 7 : tmpInt;

            tmpInt = 15 - tmpInt;

            tmpInt += '0';
            tmpInt = tmpInt > '9' ? tmpInt + 7 : tmpInt;
            outStr.append((char) (tmpInt));
        }

        return "0x" + outStr.toString();
    }

    // 转化字符串为十六进制编码
    public static String toHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

    // 转化字符串为十六进制编码
    public static String chinese2HexString(String s) {
        String ss = s;

        byte[] bt = ss.getBytes();

        String s1 = "";

        for (byte aBt : bt) {
            String tempStr = Integer.toHexString(aBt);
            if (tempStr.length() > 2)
                tempStr = tempStr.substring(tempStr.length() - 2);
            s1 = s1 + tempStr;
        }

        return s1.toUpperCase();
    }

    // 转化十六进制编码为字符串
    public static String toStringHex1(String s) {
        return toStringHex1(s, "utf-8");
    }

    // 转化十六进制编码为字符串
    public static String toStringHex1(String s, String charset) {
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(
                        s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, charset);// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    // 转化十六进制编码为字符串
    public static String toStringHex2(String s) {
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(
                        s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "utf-8");// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    /*
     * 16进制数字字符集
     */
    private static String hexString = "0123456789ABCDEF";

    /*
     * 将字符串编码成16进制数字,适用于所有字符（包括中文）
     */
    public static String encode(String str) {
        // 根据默认编码获取字节数组
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        // 将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
        }
        return sb.toString();
    }

    /*
     * 将16进制数字解码成字符串,适用于所有字符（包括中文）
     */
    public static String decode(String bytes) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(
                bytes.length() / 2);
        // 将每2位16进制整数组装成一个字节
        for (int i = 0; i < bytes.length(); i += 2)
            baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString
                    .indexOf(bytes.charAt(i + 1))));
        return new String(baos.toByteArray());
    }

    /**
     * 16进制转换成为string类型字符串
     * @param s
     * @return
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    /**
     * 将指定byte数组以16进制的形式打印到控制台
     *
     * @param hint String
     * @param b    byte[]
     * @return void
     */
    public static void printHexString(String hint, byte[] b) {
        System.out.print(hint);
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase() + " ");
        }
        System.out.println("");
    }

    /**
     * @param b byte[]
     * @return String
     */
    public static String bytes2HexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    /**
     * 将一个整形化为十六进制，并以字符串的形式返回
     */
    public static String intToHexString(int n) {
        String hexString = Integer.toHexString(n);
        return hexString.length() % 2 == 1 ? "0" + hexString : hexString;
    }

    /**
     * 将两个ASCII字符合成一个字节； 如："EF"--> 0xEF
     *
     * @param src0 byte
     * @param src1 byte
     * @return byte
     */
    public static byte uniteBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[]{src0}))
                .byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[]{src1}))
                .byteValue();
        byte ret = (byte) (_b0 ^ _b1);
        return ret;
    }

    /**
     * 将指定字符串src，以每两个字符分割转换为16进制形式 如："2B44EFD9" --> byte[]{0x2B, 0x44, 0xEF,
     * 0xD9}
     *
     * @param src String
     * @return byte[]
     */
    public static byte[] hexString2Bytes(String src) {
        byte[] ret = new byte[8];
        byte[] tmp = src.getBytes();
        for (int i = 0; i < 8; i++) {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;
    }

    public static String obj2Str(Object object) {
        if (object != null) {
            return object.toString();
        }
        return null;
    }

    public static Integer obj2Int(Object object) {
        if (object != null) {
            return (Integer) object;
        }
        return null;
    }

    public static Boolean obj2Boolean(Object object) {
        if (object != null) {
            return (Boolean) object;
        }
        return null;
    }

    public static Double obj2Double(Object object) {
        if (object != null) {
            return (Double) object;
        }
        return null;
    }

    public static Double str2Double(String str) {
        if (str != null && !"".equals(str.trim())) {
            return Double.parseDouble(str.trim());
        } else {
            return 0d;
        }
    }

    public static Long str2Long(String str) {
        if (str != null && !"".equals(str.trim())) {
            return Long.parseLong(str.trim());
        } else {
            return 0L;
        }
    }

    public static Integer str2Int(String str) {
        if (str != null && !"".equals(str.trim())) {
            return Integer.parseInt(str.trim());
        } else {
            return 0;
        }
    }

    public static String Double2Str(Double val) {
        if (val != null) {
            return val.toString();
        } else {
            return "";
        }
    }

    public static String int2str(Integer integer) {
        if (integer != null) {
            return integer.toString();
        } else {
            return null;
        }
    }

    public static String null2Str(String str) {
        if (str == null || str.equals("null")) {
            return "";
        }
        return str.trim();
    }

    public static float str2Float(String str) {
        if (str == null) {
            return 0.00F;
        }
        return Float.parseFloat(str);
    }

    public static Boolean str2Boolean(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    public static String date2Str(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 将首字母转成小写
     *
     * @param org
     * @return
     */
    public static String lowerCaseFirstLetter(String org) {
        if (org != null && org.trim().length() > 0) {
            String first = org.substring(0, 1).toLowerCase();
            return first + org.substring(1);
        } else {
            return org;
        }
    }

    /****
     * 16进制ascii转字符串
     *
     * @param value
     * @return
     */
    public static String asciiHexToString(String value) {
        if (value == null || value.equals("") ||
                value.toUpperCase().equals("FF")) {
            return "";
        }
        value = Integer.parseInt(value, 16) + "";
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher match = pattern.matcher(str);
        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 是否为自然数
     *
     * @param str
     * @return
     */
    public static boolean isNaturalNumber(String str) {
        // --必须是1-9开头的。
        String rex = "^\\d*[1-9]\\d*$";
        Pattern p = Pattern.compile(rex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 是否为 16 进制
     *
     * @param str
     * @return
     */
    public static boolean isHex(String str) {
        String regex = "^[A-Fa-f0-9]+$";
        return str.matches(regex);
    }
    /**
     * hex字符串转byte数组
     * @param src 待转换的Hex字符串
     * @return  转换后的byte数组结果
     */
    public static byte[] hex2Bytes(String src){
        String inHex = src.replaceAll(" ", "");
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1){
            //奇数
            hexlen++;
            result = new byte[(hexlen/2)];
            inHex="0"+inHex;
        }else {
            //偶数
            result = new byte[(hexlen/2)];
        }
        int j=0;
        for (int i = 0; i < hexlen; i+=2){
            result[j]=hex2Byte(inHex.substring(i,i+2));
            j++;
        }
        return result;
    }

    /**
     * Hex字符串转byte
     * @param inHex 待转换的Hex字符串
     * @return  转换后的byte
     */
    public static byte hex2Byte(String inHex){
        return (byte)Integer.parseInt(inHex,16);
    }


    /**
     * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes（）配套使用
     *
     * @param src
     *            byte数组
     * @param offset
     *            从数组的第offset位开始
     * @return int数值
     */
    public static int bytesToInt(byte[] src, int offset) {
        int value;
        value = (int) ((src[offset] & 0xFF)
                | ((src[offset+1] & 0xFF)<<8)
                | ((src[offset+2] & 0xFF)<<16)
                | ((src[offset+3] & 0xFF)<<24));
        return value;
    }
}
