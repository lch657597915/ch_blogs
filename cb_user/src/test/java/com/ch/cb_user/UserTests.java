package com.ch.cb_user;


import com.alibaba.fastjson.JSONObject;
import com.ch.cb_common.base.pojo.dto.IdDTO;
import com.ch.cb_common.base.response.ResponseResult;
import com.ch.cb_common.base.response.ResponseWrap;
import com.ch.cb_common.utils.JSONUtil;
import com.ch.cb_user.pojo.domain.dto.user.UserLoginByPhoneAndPasswordDTO;
import com.ch.cb_user.pojo.vo.manager.ManagerVO;
import com.ch.cb_user.pojo.vo.user.UserVO;
import com.ch.cb_user.service.manager.ManagerService;
import com.ch.cb_user.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

	@Resource
	private UserService userService;

	/**
	 * 手机号密码登录
	 * @author lch
	 * @date 2020/4/15
	 */
	@Test
	public void loginByPhoneAndPassword() {
		UserLoginByPhoneAndPasswordDTO dto = new UserLoginByPhoneAndPasswordDTO();
		dto.setPhone("17601001780");
		dto.setPassword("1234561");
		UserVO vo = this.userService.loginByPhoneAndPassword(dto);
		JSONUtil.printPretyJsonForObject(vo);
	}


}
