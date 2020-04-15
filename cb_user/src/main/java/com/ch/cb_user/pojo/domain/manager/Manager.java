package com.ch.cb_user.pojo.domain.manager;

import com.ch.cb_common.base.pojo.domain.BaseDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Table;

/**
 * 后台用户
 * @author lch
 * @date 2020/4/12
 */
@Data
@FieldNameConstants
@Table(name = "manager")
public class Manager extends BaseDO {

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "密码盐")
    private String salt;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "部门Id")
    private Long departmentId;

    @ApiModelProperty(value = "删除标记")
    private Integer deleteFlag;
}
