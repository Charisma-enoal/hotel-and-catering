package com.murphy.gee.sys.controller;

import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.sys.entity.Authority;
import com.murphy.gee.sys.service.IAuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @ClassName AuthorityController
 * @Description 权限菜单控制器
 * @Author Murphy.Gee
 * @Date 2019-08-07 17:56
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/auth")
@Api(value = "权限管理接口",tags = "权限管理接口",description="权限管理接口",basePath = "/api/auth")
public class AuthorityController {
    @Autowired
    private IAuthorityService authorityService;

    @ApiOperation("获取到所有权限")
    @GetMapping("/list")
    @ResponseBody
    public JsonResult<List<Authority>> menu(Principal principal){
        return new JsonResult<List<Authority>>(authorityService.selectAuthByUsername(principal.getName()));
    }
}
