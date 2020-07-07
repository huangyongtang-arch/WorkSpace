package com.example.common.util;

import org.springframework.util.Assert;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Cookie
 * 
 * @author
 * 
 */
public class CookieUtils {


    public static final String COOKIE_PAGE_SIZE = "_cookie_page_size";


    public static final int    DEFAULT_SIZE     = 10;


    public static final int    MAX_SIZE         = 200;



    public static int getPageSize(HttpServletRequest request) {
        Assert.notNull(request);
        Cookie cookie = getCookie(request, COOKIE_PAGE_SIZE);
        int count = 0;
        if (cookie != null) {
            try {
                count = Integer.parseInt(cookie.getValue());
            } catch (Exception e) {}
        }
        if (count <= 0) {
            count = DEFAULT_SIZE;
        } else if (count > MAX_SIZE) {
            count = MAX_SIZE;
        }
        return count;
    }


    public static Cookie getCookie(HttpServletRequest request, String name) {
        Assert.notNull(request);
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) { return c; }
            }
        }
        return null;
    }

}
