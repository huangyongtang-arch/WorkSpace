package com.example.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Ocean on 2015/12/14.
 */
public class BeanUtils {

    public static Method matchSetter(Class clazz, String name) {
        return matchAccesser(clazz, name, "set");
    }

    public static Method matchGetter(Class clazz, String name) {
        return matchAccesser(clazz, name, "get");
    }

    public static Method matchAccesser(Class clazz, String name, String accesser) {
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith(accesser) && methodName.length() > accesser.length()) {
                if (name.equalsIgnoreCase(methodName.substring(accesser.length()))) {
                    return method;
                }
            }
        }
        return null;
    }

    public static Method matchMethod(Class clazz, String name) {
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.equals(name)) {
                return method;
            }
        }
        return null;
    }

    public static Object clone(Object obj) throws Exception {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(obj);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in =new ObjectInputStream(byteIn);

        return in.readObject();
    }

    /**
     * 两个相同类型对象之间进行属性拷贝
     * @param src　源
     * @param tgt　目标
     * @param includes　需要进行拷贝的属性列表
     * @param <T>
     * @return
     */
    public static <T> void copyProperties(T src, T tgt, List<String> includes) {
        if (src == null || tgt == null) {
            return;
        }

        if (includes != null && includes.size() > 0) {
            for (String property : includes) {
                copyProperty(src, tgt, property);
            }
        }
    }

    /**
     * 两个相同类型对象之间进行属性拷贝，只拷贝指定的某一个属性
     * @param src
     * @param tgt
     * @param property　需要进行拷贝的属性
     * @param <T>
     */
    public static <T> void copyProperty(T src, T tgt, String property) {
        if (src == null || tgt == null || property == null || property.isEmpty()) {
            return;
        }

        try {
            Method getter = matchGetter(src.getClass(), property);
            Method setter = matchSetter(tgt.getClass(), property);

            Object value = getter.invoke(src);
            setter.invoke(tgt, value);
        } catch (IllegalAccessException |InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
