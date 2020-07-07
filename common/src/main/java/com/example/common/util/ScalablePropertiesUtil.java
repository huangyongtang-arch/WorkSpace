package com.example.common.util;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Ocean
 * @date 2016/4/9
 */
public class ScalablePropertiesUtil {
    public static String[] getPropertiesToPrint(String[] selectedProperties, Map<String, String> propsMap) {
        if (selectedProperties == null || selectedProperties.length < 2) {
            String[] propsToPrint = new String[propsMap.size()];

            int index = 0;
            Iterator<String> iter = propsMap.keySet().iterator();
            while (iter.hasNext()) {
                propsToPrint[index++] = iter.next();
            }
            return propsToPrint;
        }
        else {
            return selectedProperties;
        }
    }
}
