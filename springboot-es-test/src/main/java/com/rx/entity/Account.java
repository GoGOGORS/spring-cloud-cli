package com.rx.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-07-09 18:03}
 * {{@code @Description} @Description: }
 */

@Data
@Accessors(chain = true)
@Document
public class Account {

    @Id
    private String id;

    private String name;

    private Integer age;

}
