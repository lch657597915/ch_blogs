package com.ch.cb_user.service.manager.impl;

import com.ch.cb_common.base.enums.DeleteFlagEnum;
import com.ch.cb_common.base.pojo.domain.BaseDO;
import com.ch.cb_common.base.pojo.dto.IdDTO;
import com.ch.cb_common.utils.ValidateUtil;
import com.ch.cb_common.utils.modelmapper.ModelMapperUtil;
import com.ch.cb_user.mapper.manager.ManagerMapper;
import com.ch.cb_user.pojo.domain.manager.Manager;
import com.ch.cb_user.pojo.vo.manager.ManagerVO;
import com.ch.cb_user.service.manager.ManagerService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台用户
 * @author lch
 * @date 2020/4/12
 **/
@Service
public class ManagerServiceImpl implements ManagerService {

	@Resource
	private ManagerMapper managerMapper;

	/**
	 * id获取用户
	 * @author lch
	 * @date 2020/4/12
	 */
	@Override
	public ManagerVO get(IdDTO dto) {
		Manager manager = this.checkManagerExist(dto.getId());
		ManagerVO vo = ModelMapperUtil.map(manager, ManagerVO.class);
		return vo;
	}


	private Manager checkManagerExist(Long id) {
		Example example = new Example(Manager.class);
		example.createCriteria()
				.andEqualTo(BaseDO.Fields.id, id)
				.andEqualTo(Manager.Fields.deleteFlag, DeleteFlagEnum.UNDELETE.getCode());
		Manager manager = this.managerMapper.selectOneByExample(example);
		ValidateUtil.businessValidate(manager!=null, "未找到后台用户："+id);
		return manager;
	}
}
