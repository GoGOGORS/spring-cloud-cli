package com.rx.hutoolTest;

import cn.hutool.system.SystemUtil;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-06-23 10:21}
 * {{@code @Description} @Description: }
 */

public class HuToolSystemUtil {

    public static void main(String[] args) {
        System.out.println(SystemUtil.getHostInfo());
        System.out.println(SystemUtil.getJavaInfo());
        System.out.println(SystemUtil.getJvmInfo());
    }


}
