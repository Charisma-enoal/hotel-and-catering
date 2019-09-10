package com.murphy.gee.sys.controller;

import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.common.entity.DeptTreeSelect;
import com.murphy.gee.sys.service.IDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
