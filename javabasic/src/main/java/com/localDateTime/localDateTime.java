package com.localDateTime;

import java.time.LocalDateTime;

/**
 * @author: tommy wing
 * @description
 */
public class localDateTime {
    public static void main(String[] args) {
        LocalDateTime now =  LocalDateTime.now();
        System.out.println(now);

        LocalDateTime bigNow = LocalDateTime.now().plusSeconds(1L).plusMinutes(1L);
        System.out.println(bigNow);

        int i = now.compareTo(bigNow);
        System.out.println(i);
    }
}
