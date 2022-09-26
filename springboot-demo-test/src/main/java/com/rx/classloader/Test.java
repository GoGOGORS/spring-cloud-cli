package com.rx.classloader;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-30 10:37}
 * {{@code @Description} @Description: }
 */

public class Test {

    public static String s = "hello";

    static {
        System.out.println(s);
    }

}
