package com.rx.controller.es;

import com.rx.entity.TestCategory;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryDaoTest {

    @Resource
    ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void queryItemDoc() {
        // 少年去和所有field进行匹配
        QueryStringQueryBuilder queryStringQueryBuilder = QueryBuilders.queryStringQuery("");
        // 查询条件SearchQuery是接口，只能实例化实现类。

        SearchQuery searchQuery = new NativeSearchQuery(queryStringQueryBuilder);
        List<MoreLikeThisQueryBuilder.Item> list = elasticsearchTemplate.queryForList(searchQuery, MoreLikeThisQueryBuilder.Item.class);
        for(MoreLikeThisQueryBuilder.Item item : list){
            System.out.println(item);
        }
    }



    @Test
    public void matchAllItemDoc() {
        SearchQuery searchQuery = new NativeSearchQuery(QueryBuilders.matchAllQuery());
        List<TestCategory> list = elasticsearchTemplate.queryForList(searchQuery, TestCategory.class);
        for(TestCategory item : list){
            System.out.println(item);
        }
    }


    @Test
    public void test1() {
        SearchQuery searchQuery = new NativeSearchQuery(QueryBuilders.matchAllQuery());
        List<Object> list = elasticsearchTemplate.queryForList(searchQuery, Object.class);
        for(Object item : list){
            System.out.println(item);
        }
    }


    @Test
    public void isExistsIndex() {
        IndicesExistsResponse indicesExistsResponse = elasticsearchTemplate.getClient().admin().indices()
                .exists(new IndicesExistsRequest().indices(new String[]{"test_category"}))
                .actionGet();

        log.info("判断index是否存在：{}", indicesExistsResponse.isExists());
    }

    @Test
    public void isExistsDocument() {
        TypesExistsResponse document = elasticsearchTemplate.getClient().admin().indices()
                        .typesExists(new TypesExistsRequest(new String[]{"test"}, "category")).actionGet();
        log.info("判断Document是否存在：{}", document.isExists());
    }

    @Test
    public void deleteIndex() {
        boolean test_category = elasticsearchTemplate.deleteIndex("test_category");
        log.info("索引删除是否成功：{}", test_category);
    }


    @Test
    public void test2() {
        elasticsearchTemplate.getClient().admin().indices()
                .prepareCreate("test_category")
                .addMapping("category_info")
                // .addMapping(EsConstants.DOC_GOODS_INFO_TYPE, "_parent", "type=".concat(EsConstants.DOC_CATE_BRAND_TYPE))
                .execute().actionGet();

        elasticsearchTemplate.putMapping(TestCategory.class);

    }

}