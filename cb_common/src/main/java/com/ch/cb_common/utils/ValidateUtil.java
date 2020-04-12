package com.ch.cb_common.utils;

import com.ch.cb_common.base.enums.SystemErrorCodeEnum;
import com.ch.cb_common.base.exception.BusinessException;
import com.ch.cb_common.base.exception.ParamDefectException;
import com.ch.cb_common.base.response.ResponseResult;
import org.apache.commons.lang3.StringUtils;

/**
 * 校验数据有效性工具类
 * @author lch
 * @date 2020/4/12
 */
public class ValidateUtil {

    /**
     * 校验条件是否为空，如果符合则抛出参数缺失异常
     * @author lch
     * @date 2020/4/12
     */
    public static void paramRequired(Object value, String message) {
        if (value == null) {
            throw new ParamDefectException(message);
        } else {
            if (value instanceof String
                    && StringUtils.isBlank(String.valueOf(value))) {
                throw new ParamDefectException(message);
            }
        }
    }

    public static void paramRequired(Object... values) {
        String message = SystemErrorCodeEnum.SYS_PARAM_DEFECT.getMsg();
        for (Object val : values) {
            paramRequired(val, message);
        }
    }

    /**
     * 校验条件是否符合，如果不符合则抛出业务异常
     * @author lch
     * @date 2020/4/12
     */
    public static void businessValidate(boolean condition, String message) {
        if (!condition) {
            throw new BusinessException(message);
        }
    }

    public static void businessValidate(boolean condition, int code, String message) {
        if (!condition) {
            throw new BusinessException(code, message);
        }
    }

    /**
     * 数据库影响行数的校验,默认1返回true
     * @author lch
     * @date 2020/4/12
     */
    public static Boolean checkAffectRow(int rows) {
        int effectRows = 1;
        businessValidate(rows == effectRows, SystemErrorCodeEnum.SYS_FAIL.getMsg());
        return true;
    }

    public static Boolean checkAffectRow(boolean condition) {
        businessValidate(condition, SystemErrorCodeEnum.SYS_FAIL.getMsg());
        return true;
    }

    public static Boolean checkResponseApi(ResponseResult<?> result) {
        if (result == null) {
            throw new BusinessException(SystemErrorCodeEnum.SYS_SERVICE_NETWORK_ERROR.getCode(), SystemErrorCodeEnum.SYS_SERVICE_NETWORK_ERROR.getMsg());
        }
        if (!result.isSuccess()) {
            throw new BusinessException(SystemErrorCodeEnum.SYS_SERVICE_FAIL.getCode(), SystemErrorCodeEnum.SYS_SERVICE_FAIL.getMsg());
        }
        return true;
    }


}
