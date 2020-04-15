package com.ch.cb_user.service.user;

import com.ch.cb_common.base.pojo.dto.IdDTO;
import com.ch.cb_user.pojo.domain.dto.user.UserLoginByPhoneAndPasswordDTO;
import com.ch.cb_user.pojo.vo.manager.ManagerVO;
import com.ch.cb_user.pojo.vo.user.UserVO;

/**
 * @author lch
 * @date 2020/4/12
 **/
public interface UserService {

	/**
	 * 手机号密码登录
	 * @author lch
	 * @date 2020/4/15
	 */
	UserVO loginByPhoneAndPassword(UserLoginByPhoneAndPasswordDTO dto);
}
