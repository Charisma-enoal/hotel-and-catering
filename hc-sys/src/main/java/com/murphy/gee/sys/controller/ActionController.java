package com.murphy.gee.sys.controller;

import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.Action;
import com.murphy.gee.sys.service.IActionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName ActionController
 * @Description 操作权限控制器
 * @Author Murphy.Gee
 * @Date 2019-10-08 15:07
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/action")
@Api("操作权限相关接口")
public class ActionController {
    @Autowired
    IActionService actionService;

    @ApiOperation("保存操作权限")
    @PostMapping("/save")
    public JsonResult save(Action action) throws MurphyException {
        actionService.save(action);
        return new JsonResult().success();
    }
    @ApiOperation("查看操作权限")
    @GetMapping("/view")
    public JsonResult<Action> view(@RequestParam("actionId") Long actionId){
        return new JsonResult<Action>(actionService.view(actionId));
    }
    @ApiOperation("删除操作权限")
    @PostMapping("/delete")
    public JsonResult delete(@RequestParam("actionId") Long actionId){
        actionService.delete(actionId);
        return new JsonResult().success();
    }
}
