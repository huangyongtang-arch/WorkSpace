package com.example.common.util;

import java.util.Random;

public class ColorUtils {
	/**15个固定颜色集**/
	public static final String COLOR = "#4572A7,#92A8CD,#5D7F97,#55758C,#82D8EF,#F76864,#B85552,#A47D7C,#FFE081,#DB843D,#80699B,#89A54E,#44BF82,#338F61,#FD9FC1,";

	/**随机取16进制色**/
    public static String getRandColorCode(){  
    	String r,g,b;  
    	Random random = new Random();  
    	r = Integer.toHexString(random.nextInt(256)).toUpperCase();  
    	g = Integer.toHexString(random.nextInt(256)).toUpperCase();  
    	b = Integer.toHexString(random.nextInt(256)).toUpperCase();  

    	r = r.length()==1 ? "0" + r : r ;  
    	g = g.length()==1 ? "0" + g : g ;  
    	b = b.length()==1 ? "0" + b : b ;  

    	return "#"+r+g+b;  
    }
}
