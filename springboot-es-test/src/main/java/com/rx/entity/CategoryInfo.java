package com.rx.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-07-06 10:52}
 * {{@code @Description} @Description: }
 */

@Data
// @Document(indexName = "test_category_info", type = "category_info")
public class CategoryInfo implements Serializable {

    @Id
    private Integer categoryId;

    @Field(index = FieldIndex.analyzed, type = FieldType.String, analyzer = "ik_max_word")
    private String categoryName;

    @Field(index = FieldIndex.not_analyzed, type = FieldType.Double)
    private Double price;


}



