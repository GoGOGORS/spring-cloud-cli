package com.rx.controller.es;

import com.mongodb.DB;
import com.rx.entity.Account;
import com.rx.entity.EsGoods;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;
import static org.elasticsearch.index.query.QueryBuilders.termsQuery;


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
       elasticsearchTemplate.deleteIndex("es_goods");
       elasticsearchTemplate.deleteIndex("es_goods_info");
       elasticsearchTemplate.deleteIndex("goods_cate_brand");
       elasticsearchTemplate.deleteIndex("s2b");
    }


    @Test
    public void test2() {
       /*  elasticsearchTemplate.getClient().admin().indices()
                .prepareCreate("test_category")
                .addMapping("category_info")
                // .addMapping(EsConstants.DOC_GOODS_INFO_TYPE, "_parent", "type=".concat(EsConstants.DOC_CATE_BRAND_TYPE))
                .execute().actionGet(); */

        elasticsearchTemplate.createIndex(TestCategory.class);
        elasticsearchTemplate.putMapping(TestCategory.class);

    }

    @Test
    public void test3() {


    }

    @Test
    public void test4() {
        SearchQuery query = new NativeSearchQueryBuilder().withQuery(termQuery("goodsInfos.cateId", "2598")).build();
        List<EsGoods> responses =
                elasticsearchTemplate.queryForList(query, EsGoods.class);

        System.out.println(responses);


    }

    //测试mongo

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void test5() {
        DB db = mongoTemplate.getDb();
        System.out.println(db);
        mongoTemplate.findAll(Account.class);
    }


    @Test
    public void test6() {
        Account account = new Account();
        account.setId("1").setName("aaaa").setAge(18);
        mongoTemplate.insert(account);
        mongoTemplate.save(account);
    }

    @Test
    public void esSearch3() {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.boolQuery().must(termsQuery("companyCateIds", Arrays.asList(214, 215, 216, 217)))
                        .must(termsQuery("storeState", "1"))
                ).build();

        List<Account> esStores = elasticsearchTemplate.queryForList(query, Account.class);

        log.info("搜素结果为：{}", esStores);
    }


    public void esSearch() {
        /* SearchQuery searchQuery = new NativeSearchQuery(QueryBuilders.matchAllQuery());
        List<EsCateBrand> list = elasticsearchTemplate.queryForList(searchQuery, EsCateBrand.class);
        for(EsCateBrand item : list){
            System.out.println(item);
        }

        log.info("结果集：{}", list);

        repository.findAll().forEach(item -> log.info("repository 查询结果：{}", list)); */

        SearchQuery query = new NativeSearchQueryBuilder().withQuery(termsQuery("goodsInfos.cateId", "2598"))
                .withPageable(new PageRequest(0, 10)).build();
        Page<EsGoods> responses =
                elasticsearchTemplate.queryForPage(query, EsGoods.class);

    }


    // @Test
    // public void esSearch2() {
    //    /*  SearchQuery query = new NativeSearchQueryBuilder().withQuery(termQuery("companyCateIds", 215)).build();
    //     Page<EsStore> search = esStoreElasticRepository.search(query); */
    //
    //     SearchQuery builder = new NativeSearchQueryBuilder()
    //             .withIndices("").withTypes("")
    //             .withQuery(QueryBuilders.matchAllQuery())
    //             .withPageable(new PageRequest(0, 10))
    //             .build();
    //     Page<Account> search = re.search(builder);
    //     log.info("search：{}", search);
    //
    //     List<EsStore> esStores = elasticsearchTemplate.queryForList(builder, EsStore.class);
    //     log.info("esStores：{}", esStores);
    //
    //     AggregatedPage<EsStore> stores = elasticsearchTemplate.queryForPage(builder, EsStore.class);
    //     log.info("AggregatedPage stores：{}", stores);
    // }





    @Test
    public void sha1() throws NoSuchAlgorithmException {
        // 第二种：执行使用DigestUtil
        // String sha1Hex = DigestUtil.sha1Hex(text);

        Map<String, Object> map = new HashMap<>();
        map.put("username", "jsf");

        System.out.println(sign(map, "af5dad8adca199595c7e4d8906a543c0"));
    }

    //a32b13bb8bfe3d9a

    //b9e12e5f881ebc47179cdf0c8869c12700920a99
    public String sign(Map<String, Object> params, String signKey) throws NoSuchAlgorithmException {
        params.put("signKey", signKey);
        Map<String, String> needVerify = new HashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            needVerify.put(entry.getKey(), String.valueOf(entry.getValue()));
        }

        List<Map.Entry<String, String>> entryList = new ArrayList<>(needVerify.entrySet());
        //排序
        Collections.sort(entryList, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, String> entry : entryList) {
            buffer.append(entry.getKey()).append(entry.getValue());
        }
        log.info("sha1 签名参数:{}", buffer.toString());

        MessageDigest sha1 = MessageDigest.getInstance("sha1");
        sha1.update(buffer.toString().getBytes());
        BigInteger b = new BigInteger(1, sha1.digest());
        System.out.println("sha1 (Generated by Java built-in algorithm): " + b.toString(16));
        return b.toString(16);
    }


}