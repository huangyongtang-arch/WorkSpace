package com.example.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberUtil {
    public NumberUtil() {
    }

    public static String aAdd(Double value1, String value2) {
        BigDecimal v1 = new BigDecimal(value1);
        BigDecimal v2 = new BigDecimal(value2);
        BigDecimal vret = v1.add(v2).setScale(2, 4);
        return vret.toString();
    }

    public static String aSubtract(Double value1, String value2) {
        BigDecimal v1 = new BigDecimal(value1);
        BigDecimal v2 = new BigDecimal(value2);
        BigDecimal vret = v1.subtract(v2).setScale(2, 4);
        return vret.toString();
    }

    public static String aMultiply(Double value1, String value2) {
        BigDecimal v1 = new BigDecimal(value1);
        BigDecimal v2 = new BigDecimal(value2);
        BigDecimal vret = v1.multiply(v2).setScale(2, 4);
        return vret.toString();
    }

    public static String aDivide(Double value1, String value2) {
        BigDecimal v1 = new BigDecimal(value1);
        BigDecimal v2 = new BigDecimal(value2);
        BigDecimal vret = v1.divide(v2, 2, 4);
        return vret.toString();
    }

    public static double ToDouble(String value) {
        if (value == null) {
            return 0.0D;
        } else {
            String szTemp = "";

            for(int i = 0; i < value.length(); ++i) {
                if (value.charAt(i) != ',') {
                    szTemp = szTemp + value.charAt(i);
                }
            }

            try {
                return Double.parseDouble(szTemp);
            } catch (NumberFormatException var3) {
                return 0.0D;
            }
        }
    }

    public static float toFloat(long value) {
        return (float)value;
    }

    public static float toFloat(String value) {
        if (value == null) {
            return 0.0F;
        } else {
            String szTemp = "";

            for(int i = 0; i < value.length(); ++i) {
                if (value.charAt(i) != ',') {
                    szTemp = szTemp + value.charAt(i);
                }
            }

            try {
                return Float.parseFloat(szTemp);
            } catch (NumberFormatException var3) {
                return 0.0F;
            }
        }
    }

    public static float round(float v, int scale) {
        BigDecimal b = new BigDecimal(Float.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, 4).floatValue();
    }

    public static float ceiling(float v, int scale) {
        BigDecimal b = new BigDecimal(Float.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, 2).floatValue();
    }

    public static int toInt(float value) {
        return (int)value;
    }

    public static int toInt(double value) {
        return (int)value;
    }

    public static int toInt(String value) {
        if (value == null) {
            return 0;
        } else {
            value = value.trim();
            String szTemp = "";

            for(int i = 0; i < value.length(); ++i) {
                if (value.charAt(i) != ',') {
                    szTemp = szTemp + value.charAt(i);
                }
            }

            try {
                return Integer.parseInt(szTemp);
            } catch (NumberFormatException var3) {
                return 0;
            }
        }
    }

    public static long toLong(float value) {
        return (long)value;
    }

    public static long toLong(String value) {
        if (value == null) {
            return 0L;
        } else {
            value = value.trim();
            String szTemp = "";

            for(int i = 0; i < value.length(); ++i) {
                if (value.charAt(i) != ',') {
                    szTemp = szTemp + value.charAt(i);
                }
            }

            try {
                return Long.parseLong(szTemp);
            } catch (NumberFormatException var3) {
                return 0L;
            }
        }
    }

    public static String getPercent(int x, int total) {
        String result = "";
        double x_double = (double)x * 1.0D;
        double tempresult = x_double / (double)total;
        DecimalFormat df1 = new DecimalFormat("0.00%");
        result = df1.format(tempresult);
        return result;
    }
}