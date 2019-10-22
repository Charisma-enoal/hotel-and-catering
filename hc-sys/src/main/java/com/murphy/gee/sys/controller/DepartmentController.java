package com.murphy.gee.sys.controller;

import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.common.entity.DeptTreeSelect;
import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.Group;
import com.murphy.gee.sys.service.IDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @ClassName DepartmentController
 * @Description 部门相关接口
 * @Author Murphy.Gee
 * @Date 2019-09-05 16:19
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/dept")
@Api(value = "部门管理相关接口",tags = "部门管理相关接口",description="部门管理相关接口",basePath = "/api/dept")
public class DepartmentController {
    @Autowired
    IDepartmentService departmentService;

    @ApiOperation(value = "部门选择树")
    @GetMapping("/tree")
    @ResponseBody
    public JsonResult<List<DeptTreeSelect>> deptTreeSelect(){
        return new JsonResult<List<DeptTreeSelect>>().success(departmentService.getDeptTree());
    }

    @ApiOperation(value = "获取部门详细信息")
    @ApiImplicitParam(value = "部门ID",name = "groupId",dataType = "Integer",required = true)
    @GetMapping("/init")
    public JsonResult<Group> getDept(@RequestParam("groupId") Integer groupId){
        return new JsonResult<Group>().success(departmentService.getGroupByGroupId(groupId));
    }

    @ApiOperation(value = "保存部门")
    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Group group, Principal principal){
        group.setCreatePerson(principal.getName());
        group.setLastEditPerson(principal.getName());
        departmentService.save(group);
        return new JsonResult().success();
    }

    @ApiOperation(value = "加载部门所拥有的角色")
    @ApiImplicitParam(value = "部门ID",name = "groupId",dataType = "Integer",required = true)
    @GetMapping("/initDeptRoles")
    public JsonResult<List<Long>> initDeptRoles(@RequestParam("groupId") Integer groupId){
        return new JsonResult<List<Long>>().success(departmentService.initDeptRoles(groupId));
    }


    @ApiOperation(value = "分配角色")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "部门ID",name = "groupId",dataType = "Integer",required = true),
            @ApiImplicitParam(value = "以逗号隔开的角色ID",name = "roleIds",dataType = "String",required = true)
    })
    @PostMapping("/allocationRoles")
    public JsonResult allocationRoles(@RequestParam("groupId") Integer groupId,@RequestParam("roleIds") String roleIds){
        departmentService.allocationRoles(groupId,roleIds);
        return new JsonResult().success();
    }

    @ApiOperation(value = "删除部门")
    @ApiImplicitParam(value = "部门ID",name = "groupId",dataType = "Integer",required = true)
    @PostMapping("/delete")
    public JsonResult delete(@RequestParam("groupId") Integer groupId) throws MurphyException {
        departmentService.delete(groupId);
        return new JsonResult().success();
    }
}
