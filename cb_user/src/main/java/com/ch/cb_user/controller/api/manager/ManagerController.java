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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.function.DoubleToIntFunction;

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
    @ApiOperation(value = "id获取用户", httpMethod = "POST")
    public ResponseResult<ManagerVO> get(@Valid @RequestBody IdDTO dto) {
        System.out.println(1111111111);
        ManagerVO vo = this.managerService.get(dto);
        System.out.println(111);
        return ResponseWrap.success(vo);
    }

    @GetMapping("/getById")
    @ApiOperation(value = "id获取用户", httpMethod = "GET")
    public ResponseResult<ManagerVO> getById() {
        IdDTO dto = new IdDTO();
        dto.setId(1L);
        ManagerVO vo = this.managerService.get(dto);
        return ResponseWrap.success(vo);
    }



}
