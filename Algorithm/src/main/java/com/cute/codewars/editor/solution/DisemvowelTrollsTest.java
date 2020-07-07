package com.cute.codewars.editor.solution;

import com.cute.leetcode.editor.util.Examination;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.Random;

/**
 * @ClassName Disemvowel_Trolls
 * @Description
 * @Author tommy
 * @Date 7/6/20204:35 PM
 **/
public class DisemvowelTrollsTest{
    /**
     *
     * @Description  result
     * @Date 5:14 PM 7/6/2020
     * @Param [Z]
     * @return java.lang.String
     **/
    public static String disemvowelTrolls(String Z){
        return Z.replaceAll("(?i)[aeiou]","");
    }
    @Test
    public void testResult(){
        System.out.println(disemvowelTrolls("AEIOUZ"));

    }

    @Test
    public void FixedTests() {
        System.out.print("This website is for losers LOL!"+" : : ");
        System.out.println(DisemvowelTrollsTest.disemvowelTrolls("This website is for losers LOL!"));
        System.out.print("Ths wbst s fr lsrs LL!"+" : : ");
        System.out.println(DisemvowelTrollsTest.disemvowelTrolls("This website is for losers LOL!"));
        System.out.print("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd"+" : : ");
        System.out.println(DisemvowelTrollsTest.disemvowelTrolls
                ("No offense but,\nYour writing is among the worst I've ever read"));
        System.out.print("Wht r y,  cmmnst?"+" : : ");
        System.out.println(DisemvowelTrollsTest.disemvowelTrolls("What are you, a communist?"));
    }

    public static String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }

    @Test
    public void RandomTests() {

        for(int i = 0; i < 100; i++) {
            String X = generateRandomChars(
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", i + 3);
            assertEquals(C(X) , DisemvowelTrollsTest.disemvowelTrolls(X));
        }

    }

    public static String C(String Z) {
        return Z.replaceAll("(?i)[aeiou]" , "");
    }
}
