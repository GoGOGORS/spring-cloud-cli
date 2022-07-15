package com.rx.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-07-05 10:40}
 * {{@code @Description} @Description: }
 */

@Data
@Accessors(chain = true)
@Document(indexName = "test_category", type = "category")
public class TestCategory implements Serializable {

    @Id
    private int id;

    @Field(index = FieldIndex.analyzed, type = FieldType.String, analyzer = "ik_max_word")
    private String name;

    @Field(index = FieldIndex.not_analyzed, type = FieldType.String)
    private String address;

    private CategoryInfo categoryInfo;


}
