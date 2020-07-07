//Return the number (count) of vowels in the given string.
//
//        We will consider a, e, i, o, u as vowels for this Kata (but not y).
//
//        The input string will only consist of lower case letters and/or spaces.
//
//        FUNDAMENTALS STRINGS UTILITIES


package com.cute.codewars.editor.solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @ClassName VowelCount
 * @Description TODO
 * @Author tommy
 * @Date 7/6/2020 5:53 PM
 **/
public class VowelCount {
    /**
     * @Method count
     * @Description  my method
     * @Date 6:06 PM 7/6/2020
     * @Param [str]
     * @return int
     **/
    public static int count(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }

    public static class VowelsTest {
        @Test
        public void testCase1() {
            assertEquals("Nope!", 5, VowelCount.count("abracadabra"));
            System.out.println(count("abracadabra"));
        }

    }

    public static int getCount1(String str) {
        return str.replaceAll("(?i)[^aeiou]", "").length();
    }

    public static int getCount2(String str) {
        int vowelsCount = 0;

        for(char c : str.toCharArray()) {
            vowelsCount += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
        }

        return vowelsCount;
    }

//    public static int getCount3(String str) {
//        return (int) str.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
//    }

    public static int getCount4(String str) {
        return (int)str.chars().mapToObj(i -> (char)i).filter(i -> "aeiou".contains(String.valueOf(i))).count();
    }
}
