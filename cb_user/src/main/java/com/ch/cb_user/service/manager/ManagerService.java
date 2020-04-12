package com.ch.cb_user.service.manager;

import com.ch.cb_common.base.pojo.dto.IdDTO;
import com.ch.cb_user.pojo.vo.manager.ManagerVO;

/**
 * @author lch
 * @date 2020/4/12
 **/
public interface ManagerService {

	/**
	 * id获取用户
	 * @author lch
	 * @date 2020/4/12
	 */
	ManagerVO get(IdDTO dto);



}
