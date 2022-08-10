package com.rx.entity;


import java.io.Serializable;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-04-21 20:19}
 * {{@code @Description} @Description: }
 */

public enum HttpStatusCode implements Serializable {
	
	/**
	 * ok
	 */
	OK(200,"请求成功！"),
	ERROR(500, "服务异常！");




	public final Integer code;
	public final String msg;
	
	public Integer getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	HttpStatusCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
}
