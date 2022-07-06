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
	ERROR(500, "服务异常！"),

	/**
	 * 订单相关返回值
	 */
	ORDER_DATA_ERROR(10000,"订单数据异常"),
	ORDER_SKU_ERROR(10001,"订单SKU异常"),
	ORDER_ADD_ERROR(10002,"新增订单异常"),
	ORDER_RECHARGE_AMOUNT_ERROR(10003,"订单充值金额异常"),
	CUSTOMER_NON_EXISTENT(10004, "会员不存在"),
	ORDER_RECHARGE_PAY_AMOUNT_ERROR(10005,"支付金额异常"),
	BALANCE_INSUFFICIENT(10006, "余额不足"),
	FREQUENT_OPERATION(10007, "操作太频繁"),
	DUPLICATE_PAY(10008,"请勿重复支付"),
	GOODS_NOT_EXIST(10009,"商品不存在"),
	PHONE_NUMBER_ERROR(10010, "手机号码错误"),
	NON_ABNORMAL_ORDER(10011,"非异常订单，不允许手动充值"),
	ABNORMAL_RECHARGE(10012, "充值异常"),
	REFUND_FAILED(10013, "订单退款失败"),
	EXCEED_LIMIT(10014,"超过今日限额"),

	/**
	 * 分发系统相关返回值
	 */
	RECORD_ALREADY_EXISTS(30000,"发放记录已存在"),
	RECORD_DOES_NOT_EXIST(30001,"发放记录不存在"),
	NO_DELAY_RECORD(30002, "没有延迟记录，不允许手动补发"),
	RECORD_WRONG_STATE(30003, "状态错误,不允许操作"),
	FAILED_TO_ISSUE_POINTS(30004,"积分发放失败"),
	USER_DOES_NOT_EXIST(30005, "用户不存在"),
	OPERATION_FAIL(3006,"操作失败，请稍后重试"),
	DATA_EXCEPTION(3007,"数据异常"),
	STAGE_ERROR(3008,"分期数错误"),

	/**
	 * 易货分相关返回值
	 */
	BARTER_POINTS_GRANT_FAIL(40000, "发放失败，请稍后重试"),
	BARTER_POINTS_ACCOUNT_NOT_OPENED(40001, "易货分账户未开通"),
	REPEAT_OPERATION(40002, "重复操作"),
	BARTER_POINTS_PAY_FAIL(40003, "支付失败，请稍后重试"),
	BARTER_POINTS_REFUND_FAIL(40004, "退款失败，请稍后重试"),
	;


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
