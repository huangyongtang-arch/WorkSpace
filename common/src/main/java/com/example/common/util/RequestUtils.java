package com.example.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * HttpServletRequest帮助类
 * 
 * @author liufang
 */
public class RequestUtils {

    /**
     * Parses a query string passed from the client to the server and builds a <code>HashTable</code> object with key-value pairs. The query string
     * should be in the form of a string packaged by the GET or POST method,
     * that is, it should have key-value pairs in the form <i>key=value</i>,
     * with each pair separated from the next by a &amp; character.
     * <p>
     * A key can appear more than once in the query string with different values. However, the key appears only once in the hashtable, with its value being an array of strings containing the multiple
     * values sent by the query string.
     * <p>
     * The keys and values in the hashtable are stored in their decoded form, so any + characters are converted to spaces, and characters sent in hexadecimal notation (like <i>%xx</i>) are converted
     * to ASCII characters.
     * 
     * @param s
     *            a string containing the query to be parsed
     * @return a <code>HashTable</code> object built from the parsed key-value
     *         pairs
     * @exception IllegalArgumentException
     *                if the query string is invalid
     */
    public static Map<String, String[]> parseQueryString(String s) {
        String valArray[] = null;
        if (s == null) { throw new IllegalArgumentException(); }
        Map<String, String[]> ht = new HashMap<String, String[]>();
        StringTokenizer st = new StringTokenizer(s, "&");
        while (st.hasMoreTokens()) {
            String pair = st.nextToken();
            int pos = pair.indexOf('=');
            if (pos == -1) {
                continue;
            }
            String key = pair.substring(0, pos);
            String val = pair.substring(pos + 1, pair.length());
            if (ht.containsKey(key)) {
                String oldVals[] = ht.get(key);
                valArray = new String[oldVals.length + 1];
                for (int i = 0; i < oldVals.length; i++) {
                    valArray[i] = oldVals[i];
                }
                valArray[oldVals.length] = val;
            } else {
                valArray = new String[1];
                valArray[0] = val;
            }
            ht.put(key, valArray);
        }
        return ht;
    }

    
    /**
     * 获取ip地址
     * @param request
     * @return
     */   
    public static String getClientIP(HttpServletRequest request) {
    	//从SSL取客户IP
    	String ip = request.getHeader( "entrust-client-ip" );
    	//从格尔的SSL取
    	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
	         // 获取客户IP
			Cookie[] cookies = request.getCookies();
		    if(cookies == null) {
		        cookies = new Cookie[0];
		    }
		    for(int i = 0; i < cookies.length; i ++) {   
		    	Cookie cookie = cookies[i];
		    	if("KOAL_CLIENT_IP".equals(cookie.getName())) {
		    		ip = cookie.getValue();
		    	}
		    }
        }
    	// 反向代理
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip.equals("127.0.0.1")){
            	//根据网卡取本机配置的 IP
            	InetAddress inet=null;
            	try {
            		inet = InetAddress.getLocalHost();
            	} catch (UnknownHostException e) {
            		// e.printStackTrace();
            	}
            	ip= inet.getHostAddress();
            }
        }
        //存在多级反向代理的情况下，从x-forwarded-for获取的值为逗号分隔的ip串
        if(ip.indexOf(",") > 0){
        	ip = ip.substring(0, ip.indexOf(",")).trim();
        }
        return ip;
    }
}
