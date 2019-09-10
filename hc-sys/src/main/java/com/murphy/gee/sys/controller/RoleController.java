package com.murphy.gee.sys.controller;

import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.sys.entity.Role;
import com.murphy.gee.sys.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RoleController
 * @Description 角色相关接口
 * @Author Murphy.Gee
 * @Date 2019-09-06 16:19
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/role")
@Api(value = "角色相关接口",tags = "角色相关接口",description="角色相关接口",basePath = "/api/role")
public class RoleController {
    @Autowired
    IRoleService roleService;

    @ApiOperation(value = "角色选择组件接口")
    @GetMapping("/select")
    @ResponseBody
    public JsonResult<List<Role>> roleComponentSelectList(){
        return new JsonResult<List<Role>>().success(roleService.allList());
    }
}
