package com.ch.cb_user.pojo.vo.user;

import com.ch.cb_common.base.pojo.domain.BaseDO;
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
@Table(name = "UserVO")
public class UserVO extends BaseDO {

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "省code")
    private Long provinceCode;

    @ApiModelProperty(value = "省名称")
    private String provinceName;

    @ApiModelProperty(value = "市code")
    private Long cityCode;

    @ApiModelProperty(value = "市名称")
    private String cityName;

    @ApiModelProperty(value = "区code")
    private Long areaCode;

    @ApiModelProperty(value = "区名称")
    private String areaName;


}
