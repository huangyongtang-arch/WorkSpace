package com.cute.codewars.editor.solution;

import java.util.List;

/**
 * @ClassName BinaryArrayToNumber
 * @Description
 * @Author tommy
 * @Date 7/7/2020 4:48 PM
 **/
public class BinaryArrayToNumber {
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        return binary.stream().reduce((x, y) -> x * 2 + y).get();
    }
/**
 * @Method ConvertBinaryArrayToInt1
 * @Description  向左移一位和bit进行与运算
 * @Date 5:14 PM 7/7/2020
 * @Param [binary]
 * @return int
 **/
    public static int ConvertBinaryArrayToInt1(List<Integer> binary) {

        int number = 0;
        for (int bit : binary) {
            number = number << 1 | bit;
        }
        return number;
    }
/**
 * @Method ConvertBinaryArrayToInt2
 * @Description  正向遍历
 * @Date 5:05 PM 7/7/2020
 * @Param [binary]
 * @return int
 **/
    public static int ConvertBinaryArrayToInt2(List<Integer> binary) {
        int ans = 0;
        for (int i = 0; i < binary.size(); i++) {
            if (binary.get(i) == 1) {
                ans += Math.pow(2,binary.size() - i - 1);
            }
        }
        return ans;
    }
/**
 * @Method ConvertBinaryArrayToInt3
 * @Description  通過parseInt方法字符串轉二進制
 * @Date 4:55 PM 7/7/2020
 * @Param [binary]
 * @return int
 **/
    public static int ConvertBinaryArrayToInt3(List<Integer> binary) {

        String res = "";

        for (int i : binary) {
            res += i;
        }

        return Integer.parseInt(res, 2);
    }

    /**
     * @Method ConvertBinaryArrayToInt5
     * @Description  通过parseInt方法用StringBuilder转字符串"StringBuilder.toString()"再转成二进制
     * @Date 4:56 PM 7/7/2020
     * @Param [binary]
     * @return int
     **/
    public static int ConvertBinaryArrayToInt5(List<Integer> binary) {
        StringBuilder numS = new StringBuilder();

        for(int num : binary) {
            numS.append(num);
        }

        return Integer.parseInt((numS.toString()),2);
    }
    /**
     * @Method ConvertBinaryArrayToInt4
     * @Description  反向遍历
     * @Date 5:04 PM 7/7/2020
     * @Param [binary]
     * @return int
     **/
    public static int ConvertBinaryArrayToInt4(List<Integer> binary) {
        int factor = 1;
        int result = 0;
        for (int i = binary.size() - 1; i >= 0; i--) {
            result += factor * binary.get(i);
            factor *= 2;
        }
        return result;
    }
}
