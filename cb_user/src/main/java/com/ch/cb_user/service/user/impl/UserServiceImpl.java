package com.ch.cb_user.service.user.impl;

import com.ch.cb_common.base.enums.DeleteFlagEnum;
import com.ch.cb_common.base.pojo.domain.BaseDO;
import com.ch.cb_common.base.pojo.dto.IdDTO;
import com.ch.cb_common.utils.Md5Util;
import com.ch.cb_common.utils.ValidateUtil;
import com.ch.cb_common.utils.modelmapper.ModelMapperUtil;
import com.ch.cb_user.mapper.manager.ManagerMapper;
import com.ch.cb_user.mapper.user.UserMapper;
import com.ch.cb_user.pojo.domain.dto.user.UserLoginByPhoneAndPasswordDTO;
import com.ch.cb_user.pojo.domain.manager.Manager;
import com.ch.cb_user.pojo.domain.user.User;
import com.ch.cb_user.pojo.vo.manager.ManagerVO;
import com.ch.cb_user.pojo.vo.user.UserVO;
import com.ch.cb_user.service.manager.ManagerService;
import com.ch.cb_user.service.user.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * c端用户
 * @author lch
 * @date 2020/4/12
 **/
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;



	@Override
	public UserVO loginByPhoneAndPassword(UserLoginByPhoneAndPasswordDTO dto) {
		Example example = new Example(User.class);
		example.createCriteria()
				.andEqualTo(User.Fields.phone, dto.getPhone())
				.andEqualTo(User.Fields.deleteFlag, DeleteFlagEnum.UNDELETE.getCode());
		User user = this.userMapper.selectOneByExample(example);
		ValidateUtil.businessValidate(user!=null, "用户不存在");

		String md5 = Md5Util.md5(user.getSalt() + dto.getPassword());
		ValidateUtil.businessValidate(md5.equalsIgnoreCase(user.getPassword()), "密码不正确");

		UserVO vo = ModelMapperUtil.map(user, UserVO.class);
		return vo;
	}

	private User checkUserExist(Long id) {
		Example example = new Example(User.class);
		example.createCriteria()
				.andEqualTo(BaseDO.Fields.id, id)
				.andEqualTo(User.Fields.deleteFlag, DeleteFlagEnum.UNDELETE.getCode());
		User user = this.userMapper.selectOneByExample(example);
		ValidateUtil.businessValidate(user!=null, "未找到用户："+id);
		return user;
	}

	public static void main(String[] args) {
		String salt = "5dc44acd58b540b5aca3ac064a7cd8a1";
		String p = "123456";
		String md5 = Md5Util.md5(salt + p);
		System.out.println(md5);
	}

}
