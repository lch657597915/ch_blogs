package com.ch.cb_user.pojo.domain.manager;

import com.ch.cb_common.base.pojo.domain.BaseDO;
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

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 部门Id
     */
    private Long departmentId;

    /**
     * 删除标记
     * @author lch
     * @date 2020/4/12
     */
    private Integer deleteFlag;
}
