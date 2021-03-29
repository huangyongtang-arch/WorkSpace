package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: tommy wing
 * @description stream的获取
 */
public class GetStream {

    public static void main(String[] args) {
        GetStream getStream = new GetStream();

        /*通过collection 获取*/
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Stream<Integer> streamCollection = list.stream();

        /*通过数组获取*/
        String[] stringArray = {"a", "b", "c"};
        Stream<String> stringStream = Arrays.stream(stringArray);

        //        基本数据类型的获取
        //        boxed() 对基本数据类型装箱
        int[] ints = {1, 2, 3, 4};
        Stream<Integer> integerStream = Arrays.stream(ints).boxed();

        /*直接获取*/
        Stream<String> stringStream1 = Stream.of("a","b");

    }

}
