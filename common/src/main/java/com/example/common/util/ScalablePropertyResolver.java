package com.example.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Ocean
 * @date 2016/3/26
 */
public class ScalablePropertyResolver {

    /**
     * 将 modelForMongo 转换成 excel 中的数据。
     * 支持 excel 中的列是动态的，即可以自定义列的顺序以及列的数目。但是列名必须是在 propsMap 的 key 中存在。
     * @param entities
     * @param properties　　excel 列号与属性名的 pair
     * @param <T>
     * @return
     */
    public static <T> List<Map<Integer, Object>> deparse(List<T> entities, Map<Integer, String> properties) {
        if (entities == null || properties == null) {
            return null;
        }

        List<Map<Integer, Object>> datas = new ArrayList<>();

        for (T item : entities) {
            datas.add(deparse(item, properties));
        }
        return datas;
    }

    private static <T> Map<Integer, Object> deparse(T entity, Map<Integer, String> properties) {
        final Map<Integer, Object> data = new HashMap<>();

        Iterator<Integer> iter = properties.keySet().iterator();
        while (iter.hasNext()) {
            Integer i = iter.next();
            String prop = properties.get(i);
            Method getter = BeanUtils.matchGetter(entity.getClass(), prop);
            try {
                Object value = getter.invoke(entity);
                data.put(i, value);
            } catch (IllegalAccessException |InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /**
     * 将 excel 中的数据转换成 modelForMongo。
     * 支持 excel 中的列是动态的，即可以自定义列的顺序以及列的数目。但是列名必须是在 propsMap 的 key 中存在。
     * @param datas     excel 中的数据
     * @param properties　　excel 列号与属性名的 pair
     * @param clazz    modelForMongo 的类型
     * @param <T>
     * @return
     */
    public static <T> List<T> parse(List<Map<Integer, String>> datas, Map<Integer, String> properties, Class<T> clazz) {
        if (datas == null || properties == null) {
            return null;
        }

        List<T> entities = new ArrayList<>();

        for (Map<Integer, String> item : datas) {
            entities.add(parse(item, properties, clazz));
        }
        return entities;
    }

    private static <T> T parse(Map<Integer, String> data, Map<Integer, String> properties, Class<T> clazz) {
        try {
            final T entity = clazz.newInstance();
            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

}
