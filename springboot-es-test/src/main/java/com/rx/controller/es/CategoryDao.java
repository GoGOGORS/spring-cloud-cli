package com.rx.controller.es;

import com.rx.entity.TestCategory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-07-05 10:45}
 * {{@code @Description} @Description: }
 */

public interface CategoryDao extends ElasticsearchRepository<TestCategory, Long> {


}
