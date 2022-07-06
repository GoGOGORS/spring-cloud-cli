package com.rx.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-04-21 19:26}
 * {{@code @Description} @Description: }
 */


@Data
@ToString
@AllArgsConstructor
@Accessors(chain = true)
public class BaseResult<T> implements Serializable {

	private Integer code;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;

	private String msg;

	public static <T> BaseResult<T> ok(){
		return new BaseResult<>(HttpStatusCode.OK.code, null, HttpStatusCode.OK.msg);
	}

	public static <T> BaseResult<T> ok(String msg){
		return new BaseResult<>(HttpStatusCode.OK.code, null, msg);
	}

	public static <T> BaseResult<T> ok(T data){
		return new BaseResult<>(HttpStatusCode.OK.code, data, HttpStatusCode.OK.msg);
	}

	public static <T> BaseResult<T> ok(Integer code, T data){
		return new BaseResult<>(code, data, HttpStatusCode.OK.msg);
	}

	public static <T> BaseResult<T> ok(Integer code, String msg){
		return new BaseResult<>(code, null, msg);
	}

	public static <T> BaseResult<T> ok(Integer code, T data, String msg){
		return new BaseResult<>(code, data, msg);
	}

	public static <T> BaseResult<T> error(){
		return new BaseResult<>(HttpStatusCode.ERROR.code, null, HttpStatusCode.ERROR.msg);
	}

	public static <T> BaseResult<T> error(T data){
		return new BaseResult<T>(HttpStatusCode.ERROR.code, data, HttpStatusCode.ERROR.msg);
	}

	public static <T> BaseResult<T> error(String msg){
		return new BaseResult<>(HttpStatusCode.ERROR.code, null, msg);
	}

	public static <T> BaseResult<T> error(Integer code,  String msg){
		return new BaseResult<>(code, null, msg);
	}

	public static <T> BaseResult<T> error(Integer code, T data){
		return new BaseResult<>(code, data, HttpStatusCode.ERROR.msg);
	}

	public static <T> BaseResult<T> error(Integer code, T data, String msg){
		return new BaseResult<>(code, data, msg);
	}
	
}
