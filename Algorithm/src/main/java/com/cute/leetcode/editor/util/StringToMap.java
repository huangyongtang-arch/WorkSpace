package com.cute.leetcode.editor.util;


import java.util.HashMap;
import java.util.Map;

public class StringToMap {

    public void test(){
        String str = new String("String=1,Int=2,Char=3");
        HashMap<String, String> map=stringToMap(str);
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.print(entry.getKey()+",");
            System.out.println(entry.getValue());
        }
    }

    /**
     * String转回map
     * @param str
     * @return
     */
    public  HashMap<String, String> stringToMap(String str){
        str = str.substring(0, str.length());
        String[] strs = str.split(",");
        HashMap<String, String> map = new HashMap<String, String>();
        for (String string : strs) {
            String key = string.split("=")[0].trim();
            String value = string.split("=")[1].trim();
            map.put(key, value);
        }
        return map;
    }
}
