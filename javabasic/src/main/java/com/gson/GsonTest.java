package com.gson;



import com.google.gson.Gson;
import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.security.acl.Group;
import java.util.*;

public class GsonTest {
    public static void main(String[] args) {
        Product product1 = new Product("放",1,"类");
        Product product2 = new Product("发",2,"了");
        Product product3 = new Product("否",3,"李");
        List<Product> list1 = new ArrayList<Product>();
        list1.add(product1);
        list1.add(product2);
        list1.add(product3);
        Map<String,Product> map1 = new HashMap<String, Product>();
        map1.put(product1.getName(),product1);
        map1.put(product2.getName(),product1);
        map1.put(product3.getName(),product1);

        Gson gson = new Gson();
//用gson转为json
        System.out.println("output json data of product:");
        String jsonproduct= gson.toJson(product1);
        System.out.println(jsonproduct );
//list example
        System.out.println("output json data of list");
        String jsonArray = gson.toJson(list1);
        System.out.println(jsonArray);
// map example
        System.out.println("output json data of map");
        String jsonMap = gson.toJson(map1);
        System.out.println(jsonMap);
//反序列化
        String str = "{'name':'ok','price':1,'category':'雷'}";
        Product product4 = gson.fromJson(str,Product.class);
        System.out.println(product4);
//嵌套类
        class InstanceCreatorForB implements InstanceCreator<A.B> {
            private final A a;
            public InstanceCreatorForB(A a)  {
                this.a = a;
            }
            public A.B createInstance(Type type) {
                return a.new B();
            }
        }

//数组
        Gson gson1 = new Gson();
        int[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"abc", "def", "ghi"};

// Serialization
        gson1.toJson(ints);     // ==> [1,2,3,4,5]
        gson1.toJson(strings);  // ==> ["abc", "def", "ghi"]

// Deserialization
        int[] ints2 = gson1.fromJson("[1,2,3,4,5]", int[].class);
// ==> ints2 will be same as ints



    }


}
