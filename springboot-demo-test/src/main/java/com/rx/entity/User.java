package com.rx.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-25 17:18}
 * {{@code @Description} @Description: }
 */

@Data
@Accessors(chain = true)
public class User implements Serializable {

    @TableId()
    private String uId;

    private String name;

    private Integer age;

    private String email;

    private String creator;

    private String modifier;

    private Date createTime;

    private Date updateTime;




}
