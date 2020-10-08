package com.String;

/**
 * @ClassName String3
 * @Description TODO
 * @Author tommy
 * @Date 9/11/2020 5:20 PM
 **/
public class String3 {
    public static void main(String[] args) {
        String urltest= "/group1/source/测试url/Gson - Copy.html";
        String urltest2 = urltest.substring(urltest.indexOf("source/")+"source/".length());
        String urltest3 = urltest.substring(urltest.lastIndexOf("/")+1);
        System.out.println(urltest3);


        StringBuilder sb1 = new StringBuilder("车系1,车系1");
        String cc = "车系1";

        if (sb1.toString().contains(cc)){
            System.out.println(sb1.toString().replaceFirst(cc,"车系2"));
        }


    }


}
