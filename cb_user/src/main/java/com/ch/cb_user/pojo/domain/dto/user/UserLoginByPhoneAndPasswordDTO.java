package com.ch.cb_user.pojo.domain.dto.user;

import com.ch.cb_common.base.pojo.domain.BaseDO;
import com.ch.cb_common.base.pojo.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Table;

/**
 * c端用户
 * @author lch
 * @date 2020/4/12
 */
@Data
@FieldNameConstants
@Table(name = "UserLoginByPhoneAndPasswordDTO")
public class UserLoginByPhoneAndPasswordDTO extends BaseDTO {

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "登录密码")
    private String password;


}
