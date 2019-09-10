package com.murphy.gee.sys.controller;

import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.sys.entity.Modules;
import com.murphy.gee.sys.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * @ClassName MenuController
 * @Description 菜单管理控制器
 * @Author Murphy.Gee
 * @Date 2019-08-09 15:50
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/menu")
@Api("菜单相关接口")
public class MenuController {
    @Autowired
    private IMenuService menuService;

    @ApiOperation("菜单列表")
    @GetMapping("/list")
    @ResponseBody
    public JsonResult<List<Modules>> list(Principal principal){
        return new JsonResult<List<Modules>>().success(menuService.findMenuByUserName(principal.getName()));
    }
}
