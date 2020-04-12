package com.ch.cb_user;


import com.alibaba.fastjson.JSONObject;
import com.ch.cb_common.base.pojo.dto.IdDTO;
import com.ch.cb_common.base.response.ResponseResult;
import com.ch.cb_common.base.response.ResponseWrap;
import com.ch.cb_user.pojo.vo.manager.ManagerVO;
import com.ch.cb_user.service.manager.ManagerService;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CbUserApplicationTests {

	@Resource
	private ManagerService managerService;

	@Test
	public void getById() {
		IdDTO dto = new IdDTO();
		dto.setId(1L);
		ManagerVO vo = this.managerService.get(dto);
		System.out.println(JSONObject.toJSONString(vo));
	}


}
