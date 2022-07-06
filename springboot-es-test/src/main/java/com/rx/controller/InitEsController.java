package com.rx.controller;

import com.rx.entity.BaseResult;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-07-06 16:11}
 * {{@code @Description} @Description: }
 */

@RestController
@RequestMapping("/test")
public class InitEsController {

    @Resource
    private ElasticsearchTemplate template;


    @RequestMapping(value = "/goodsES", method = RequestMethod.GET)
    public BaseResult<Object> initGoods() {



        return BaseResult.ok();
    }

}
