package com.rx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-15 14:44}
 * {{@code @Description} @Description: }
 */


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnCommit {
}
