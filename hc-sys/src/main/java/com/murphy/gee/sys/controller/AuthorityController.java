package com.murphy.gee.sys.controller;

import com.murphy.gee.common.entity.AuthTreeSelect;
import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.sys.entity.AuthListModel;
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
 * @Date 2019-08-07 17:56ic
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

    @ApiOperation("权限配置列表")
    @GetMapping("/treeList")
    @ResponseBody
    public JsonResult<List<AuthListModel>> treeList(){
        return new JsonResult<List<AuthListModel>>().success(authorityService.findAllAuth());
    }
    @ApiOperation("权限选择树")
    @GetMapping("/treeSelect")
    public JsonResult<List<AuthTreeSelect>> selectTree(){
        return JsonResult.success(authorityService.initAuthTreeSelect());
    }
    @ApiOperation("根据角色ID获取到该角色所拥有的权限")
    @ApiImplicitParam(value = "角色ID",name = "roleId",required = true,dataTypeClass = Long.class)
    @GetMapping("/findAuthByRoleId")
    public JsonResult<List<Long>> findAuthByRoleId(@RequestParam("roleId") Long roleId){
        return JsonResult.success(authorityService.findAuthByRoleId(roleId));
    }
}
