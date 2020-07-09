//Write a function that accepts an array of 10 integers (between 0 and 9),
// that returns a string of those numbers in the form of a phone number.
//
//        Example:
//        Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
//        The returned format must be correct in order to complete this challenge.
//        Don't forget the space after the closing parentheses!
//




package com.cute.codewars.editor.solution;


import org.junit.Test;

public class Create_Phone_Number {
    @Test
    public void test(){
        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));

    }

    public static String createPhoneNumber(int[] numbers) {
        // Your code here!
        StringBuilder str = new StringBuilder();
        if(numbers.length==10){
            int i=0;
            str.append("(");
            while (i < 3) {
                str.append(numbers[i]);
                i++;
            }
            str.append(") ");
            while(i < 6){
                str.append(numbers[i]);
                i++;
            }
            str.append("-");
            while(i<10){
                str.append(numbers[i]);
                i++;
            }
        }
        return str.toString();
    }

    /**
     * String.format
     * @param numbers
     * @return
     */
    public static String createPhoneNumber1(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",numbers[0],numbers[1],numbers[2],
                numbers[3],numbers[4],numbers[5],numbers[6],numbers[7],numbers[8],numbers[9]);
    }

    /**
     * String.format
     * @param numbers
     * @return
     */
    public static String createPhoneNumber2(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
    }

    /**
     * replaceFirst
     * @param numbers
     * @return
     */
    public static String createPhoneNumber3(int[] numbers) {
        String phoneNumber = new String("(xxx) xxx-xxxx");

        for (int i : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }

        return phoneNumber;
    }

    /**
     *
     * @param n
     * @return
     */
    public static String createPhoneNumber4(final int[] n) {
        return "("+n[0]+n[1]+n[2]+") "+n[3]+n[4]+n[5]+"-"+n[6]+n[7]+n[8]+n[9];
    }
}
