package com.ch.cb_user.controller.api.manager;



import com.ch.cb_common.base.pojo.dto.IdDTO;
import com.ch.cb_common.base.response.ResponseResult;
import com.ch.cb_common.base.response.ResponseWrap;
import com.ch.cb_common.support.BaseController;
import com.ch.cb_user.pojo.vo.manager.ManagerVO;
import com.ch.cb_user.service.manager.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author lch
 * @date 2020/4/12
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/manager", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "ManagerController", tags = {"后台用户-接口"})
public class ManagerController extends BaseController {

    @Resource
    private ManagerService managerService;

    @PostMapping("/get")
    @ApiOperation(value = "id获取用户")
    public ResponseResult<ManagerVO> get(@Valid @RequestBody IdDTO dto) {
        ManagerVO vo = this.managerService.get(dto);
        return ResponseWrap.success(vo);
    }



}
