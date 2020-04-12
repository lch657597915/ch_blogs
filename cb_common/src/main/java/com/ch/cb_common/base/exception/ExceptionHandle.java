package com.ch.cb_common.base.exception;

import com.ch.cb_common.base.enums.SystemErrorCodeEnum;
import com.ch.cb_common.base.response.ResponseResult;
import com.ch.cb_common.base.response.ResponseWrap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

/**
 * 异常处理工具类
 * @author lch
 * @date 2020/4/12
 */
@Slf4j
public class ExceptionHandle {

    /**
     * 根据异常类型返回对应信息
     * @author lch
     * @date 2020/4/12
     */
    public static ResponseResult<String> handle(Exception e) {
        if (e instanceof ParamDefectException) {
            // 参数缺失异常
            return ResponseWrap.error(SystemErrorCodeEnum.SYS_PARAM_DEFECT.getCode(),
                    e.getMessage());
        } else if (e instanceof BusinessException) {
            // 业务异常
            log.warn("业务返回异常：[数据错误],信息:{}",
                    e.getMessage());
            int code = ((BusinessException) e).getCode();
            if(code == 0){
                code = SystemErrorCodeEnum.SYS_FAIL.getCode();
            }
            return ResponseWrap.error(code, e.getMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            //实体参数注解校验
            StringBuilder errorBuilder = new StringBuilder();
            MethodArgumentNotValidException exceptions = (MethodArgumentNotValidException) e;
            List<ObjectError> objectErrors = exceptions.getBindingResult().getAllErrors();
            if (!CollectionUtils.isEmpty(objectErrors) && objectErrors.size() > 0) {
                for (ObjectError objectError : objectErrors) {
                    errorBuilder.append(objectError.getDefaultMessage()).append(",");
                }
                errorBuilder.deleteCharAt(errorBuilder.length() - 1);
            }
            return ResponseWrap.error(SystemErrorCodeEnum.SYS_FAIL.getCode(),
                    errorBuilder.toString());
        } else {
            // 其他异常
            log.error("系统异常,异常信息:{}", e.getMessage(),
                    e);
            return ResponseWrap.error(SystemErrorCodeEnum.SYS_ERROR.getCode(),
                    SystemErrorCodeEnum.SYS_ERROR.getMsg());
        }
    }
}
