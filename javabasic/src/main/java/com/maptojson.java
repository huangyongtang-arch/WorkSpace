package com;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName maptojson
 * @Description TODO
 * @Author HYT
 * @Date 2021/1/13 20:50
 **/
public class maptojson {
    public static void main(String[] args) {
        HashMap<String,Object> mapname = new HashMap<>();
        mapname.put("jj",1);
        mapname.put("qq",2);

        HashMap<String,Object> testmap = new HashMap<>();
        testClass testClass = new testClass();
        testClass.setMap(mapname);
        testClass.setTest11("test11");
        List<HashMap<String,Object>> list = new ArrayList<>();

        mapname.put("jj",1);
        mapname.put("qq",2);
        list.add(mapname);
        testclass2 testclass2 = new testclass2();
        testclass2.setTestClass(testClass);
        testclass2.setTest22("test");
        testmap.put("mapname",mapname);
        String json = JSONObject.toJSONString(testClass);
        System.out.println(json);
    }

    static class testClass{
        String test11;

        public String getTest11() {
            return test11;
        }

        public void setTest11(String test11) {
            this.test11 = test11;
        }

        HashMap<String,Object> map  = new HashMap<>();

        public HashMap<String, Object> getMap() {
            return map;
        }

        public void setMap(HashMap<String, Object> map) {
            this.map = map;
        }
    }

    static class testclass2{
        String test22;

        public String getTest22() {
            return test22;
        }

        public void setTest22(String test22) {
            this.test22 = test22;
        }

        testClass testClass;

        public maptojson.testClass getTestClass() {
            return testClass;
        }

        public void setTestClass(maptojson.testClass testClass) {
            this.testClass = testClass;
        }
    }
}
