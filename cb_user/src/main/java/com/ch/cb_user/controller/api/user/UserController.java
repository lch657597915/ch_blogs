package com.ch.cb_user.controller.api.user;



import com.ch.cb_common.base.pojo.dto.IdDTO;
import com.ch.cb_common.base.response.ResponseResult;
import com.ch.cb_common.base.response.ResponseWrap;
import com.ch.cb_common.support.BaseController;
import com.ch.cb_user.pojo.domain.dto.user.UserLoginByPhoneAndPasswordDTO;
import com.ch.cb_user.pojo.vo.manager.ManagerVO;
import com.ch.cb_user.pojo.vo.user.UserVO;
import com.ch.cb_user.service.manager.ManagerService;
import com.ch.cb_user.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *
 * @author lch
 * @date 2020/4/12
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "UserController", tags = {"c端用户-接口"})
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @PostMapping("/loginByPhoneAndPassword")
    @ApiOperation(value = "手机号密码登录", httpMethod = "POST")
    public ResponseResult<UserVO> loginByPhoneAndPassword(@Valid @RequestBody UserLoginByPhoneAndPasswordDTO dto) {
        UserVO vo = this.userService.loginByPhoneAndPassword(dto);
        return ResponseWrap.success(vo);
    }




}
