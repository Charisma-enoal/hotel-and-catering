package com.murphy.gee.sys.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.gee.common.controller.BaseController;
import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.common.entity.MurphyResponseCode;
import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.Role;
import com.murphy.gee.sys.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
public class RoleController extends BaseController {
    @Autowired
    IRoleService roleService;

    @ApiOperation(value = "角色选择组件接口")
    @GetMapping("/select")
    @ResponseBody
    public JsonResult<List<Role>> roleComponentSelectList(){
        return new JsonResult<List<Role>>().success(roleService.allList());
    }
    @ApiOperation(value = "角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize",value = "每页展示条数",required = true,dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageNum",value = "页数",required = true,dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "keyword",value = "关键字",required = true,dataTypeClass = String.class),
            @ApiImplicitParam(name = "roleEnable",value = "状态",required = true,dataTypeClass = Integer.class)
    })
    @GetMapping("/list")
    public JsonResult<PageInfo<Role>> list(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum, @RequestParam("keyword") String keyword, @RequestParam("roleEnable") Integer roleEnable){
        return new JsonResult<PageInfo<Role>>().success(roleService.list(pageSize,pageNum,keyword,roleEnable));
    }

    @ApiOperation(value = "新增或修改角色")
    @PostMapping("/save")
    public JsonResult save(@Validated Role role, BindingResult bindingResult){
        validData(bindingResult);
        roleService.save(role);
        return new JsonResult().success();
    }

    @ApiOperation(value = "修改时，初始化角色")
    @ApiImplicitParam(name = "roleId",value = "角色ID",required = true,dataTypeClass = Long.class)
    @GetMapping("/initRole")
    public JsonResult<Role> initRole(@RequestParam("roleId") Long roleId){
        return new JsonResult<Role>().success(roleService.initRole(roleId));
    }

    @ApiOperation(value = "禁用或启用角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId",value = "角色ID",required = true,dataTypeClass = Long.class),
            @ApiImplicitParam(name = "roleEnable",value = "状态",required = true,dataTypeClass = Integer.class)
    })
    @PostMapping("/updateStatus")
    public JsonResult updateStatus(@RequestParam("roleId") Long roleId,@RequestParam("roleEnable") Integer roleEnable){
        return roleService.updateStatus(roleId,roleEnable) > 0 ? JsonResult.success() : JsonResult.fail(MurphyResponseCode.FAIL);
    }
    @ApiOperation(value = "删除角色")
    @ApiImplicitParam(name = "roleId",value = "角色ID",required = true,dataTypeClass = Long.class)
    @PostMapping("/delete")
    public JsonResult delete(@RequestParam("roleId") Long roleId) throws MurphyException {
        roleService.delete(roleId);
        return JsonResult.success();
    }
    @ApiOperation(value = "分配权限")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "角色ID",name = "roleId",required = true,dataTypeClass = Long.class),
            @ApiImplicitParam(value = "以逗号分割的权限ID字符串",name = "authStr",required = true,dataTypeClass = String.class)
    })
    @PostMapping("/allotAuth")
    public JsonResult allotAuth(@RequestParam("roleId") Long roleId,@RequestParam("authStr") String authStr){
        roleService.allotAuth(roleId,authStr);
        return JsonResult.success();
    }
}
