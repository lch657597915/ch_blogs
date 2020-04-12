package com.ch.cb_common.base.exception;

/**
 * 参数缺失类异常
 * @author lch
 * @date 2020/4/12
 */
public class ParamDefectException extends RuntimeException {

    private static final long serialVersionUID = 4024823458418290570L;

    public ParamDefectException() {
        super();
    }

    public ParamDefectException(String msg) {
        super(msg);
    }
}
