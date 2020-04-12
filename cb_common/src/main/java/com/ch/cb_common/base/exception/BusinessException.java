package com.ch.cb_common.base.exception;

/**
 * 业务类异常类
 * @author lch
 * @date 2020/4/12
 */
public class BusinessException extends RuntimeException {

	private int code;

	public BusinessException() {
		super();
	}

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(int code, String msg) {
		super(msg);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
