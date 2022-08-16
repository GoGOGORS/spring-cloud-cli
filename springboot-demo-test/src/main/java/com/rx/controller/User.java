package com.rx.controller;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-15 15:36}
 * {{@code @Description} @Description: }
 */

@Data
@Accessors(chain = true)
public class User implements Serializable {

    private Integer id;

    private String name;

    private Integer age;



}
