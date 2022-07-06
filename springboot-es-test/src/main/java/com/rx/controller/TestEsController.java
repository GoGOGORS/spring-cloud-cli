package com.rx.controller;

import com.rx.controller.es.CategoryDao;
import com.rx.entity.TestCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-07-05 10:43}
 * {{@code @Description} @Description: }
 */

@Slf4j
@RestController
@RequestMapping("/test")
public class TestEsController {

    @Resource
    private CategoryDao categoryDao;

    @Resource
    private ElasticsearchTemplate template;

    @PostMapping("/addCategory")
    public String addCategory(@RequestBody TestCategory test){
        log.info("request param: {}", test);
        categoryDao.save(test);
        return "OK";
    }


    @PostMapping("/getCategory")
    public Object getCategory(@RequestBody TestCategory test){
        log.info("request param: {}", test);
        List<Object> list = new ArrayList<>();
        categoryDao.findAll().forEach(list::add);
        return list;
    }




}

