package com.example.common.util;

public class MD5MixUtil {
    public static final String MD5_MIX = "jw134#%pqNLVfn";

    public MD5MixUtil() {
    }

    public static String md5Mix(String pwd) {
        String chartset = "utf-8";
        if (pwd == null) {
            return null;
        } else {
            String md5Pwd = MD5Util.MD5Encode("jw134#%pqNLVfn" + pwd, chartset);
            return MD5Util.MD5Encode(md5Pwd, chartset);
        }
    }

    public static void main(String[] args) {
        String pwd = "16449@SDEC";
        pwd = "111111";
        pwd = "17503@SDEC";
        pwd = "Rratchet2019@nac";
        System.out.print(md5Mix(pwd));
    }
}