package com.rx.genericity.factory;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-11-25 11:23}
 * {{@code @Description} @Description: }
 */

public interface Money <T>{


    T apply(T agrs);

}
