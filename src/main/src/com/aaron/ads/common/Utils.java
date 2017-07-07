package com.aaron.ads.common;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hzq on 2017/5/14.
 */
public class Utils {

    public static void main(String[] args) {
        System.out.println(md5("111"));
        System.out.println(md5("111111"));
    }

    public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy/M/d/HH:mm:ss");

    public static String md5(String str) {
        String newstr = "";
        try {
            //确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newstr;

    }


    public static String getTime() {
        return String.valueOf(new Date().getTime());
    }

    public static String format(String time) {
        return formatter.format(new Date(Long.valueOf(time)));
    }

}


