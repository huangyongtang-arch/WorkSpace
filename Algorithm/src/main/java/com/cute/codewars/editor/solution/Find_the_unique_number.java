package com.cute.codewars.editor.solution;
import org.junit.Test;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.Map.Entry;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;

/**
 * @ClassName Find_the_unique_number
 * @Description TODO
 * @Author tommy
 * @Date 7/7/2020 5:28 PM
 **/
public class Find_the_unique_number {
    public static double findUniq(double arr[]) {
        // Do the magic
        int start = 0;
        int end = arr.length-1;
        int mid = (start+end)/2;

        double comm=arr[start]==arr[end]?arr[start]:arr[start+1];

        while(start<end){
            if(arr[start]==arr[end]){
                start++;
                end--;
            }else{
                return (arr[start]==comm)? arr[end] : arr[start];
            }
        }
        return mid;
    }

    /**
     * @Method findUniq1
     * @Description  直接排序然后获得值
     * @Date 6:08 PM 7/7/2020
     * @Param [arr]
     * @return double
     **/
    public static double findUniq1(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    }

    /**
     * @Method findUniq2
     * @Description  流解决
     * @Date 6:09 PM 7/7/2020
     * @Param [array]
     * @return double
     **/
    public static double findUniq2(final double[] array) {
        return Arrays.stream(array).boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(Entry::getKey)
                .orElse(0.0);
    }



// TODO: Replace examples and use TDD development by writing your own tests

    public static class FindUniqTest {
        private double precision = 0.0000000000001;

        @Test
        public void sampleTestCases() {
//            assertEquals(1.0, Find_the_unique_number.findUniq(new double[]{0, 1, 0}), precision);
            System.out.println(Find_the_unique_number.findUniq(new double[]{0, 1, 0}));
//            assertEquals(2.0, Find_the_unique_number.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
            System.out.println(Find_the_unique_number.findUniq(new double[]{1, 2, 1 , 1, 1}));
        }
    }
}

