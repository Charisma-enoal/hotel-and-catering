package com.murphy.gee.sys.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.common.entity.MurphyResponseCode;
import com.murphy.gee.sys.entity.User;
import com.murphy.gee.sys.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @ClassName UserController
 * @Description 用户管理控制器
 * @Author Murphy.Gee
 * @Date 2019-09-04 9:40
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/user")
@Api(value = "用户管理接口",tags = "用户管理接口",description="用户管理接口",basePath = "/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation("用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "状态",name = "userEnable",dataType = "Integer"),
            @ApiImplicitParam(value = "用户名或真实姓名",name = "keyword",dataType = "String"),
            @ApiImplicitParam(value = "页数",name = "pageNum",dataType = "Integer"),
            @ApiImplicitParam(value = "每页条数",name = "pageSize",dataType = "Integer")
    })
    @GetMapping("/list")
    @ResponseBody
    public JsonResult<PageInfo<User>> list(Integer userEnable, String keyword, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        return new JsonResult<PageInfo<User>>().success(userService.findList(userEnable,keyword,pageNum,pageSize));
    }
    @ApiOperation("保存用户")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名",name = "userName",dataType = "String"),
            @ApiImplicitParam(value = "真实姓名",name = "userRealName",dataType = "String"),
            @ApiImplicitParam(value = "状态",name = "userEnable",dataType = "Integer"),
            @ApiImplicitParam(value = "部门ID",name = "deptId",dataType = "Integer"),
            @ApiImplicitParam(value = "角色ID集合，以逗号分隔的",name = "roleIds",dataType = "String")
    })
    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(User user, Principal principal){
        int count = userService.save(user,principal);
        return count > 0 ? new JsonResult().success().setMsg("保存成功") : new JsonResult().fail(MurphyResponseCode.INTERNAL_SERVER_ERROR);
    }

    @ApiOperation("加载用户")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名",name = "userName",dataType = "String")
    })
    @GetMapping("/init")
    @ResponseBody
    public JsonResult<User> initUser(String userName){
        return new JsonResult<User>().success(userService.initUser(userName));
    }

    @ApiOperation("更改用户状态")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名",name = "userName",dataType = "String"),
            @ApiImplicitParam(value = "状态",name = "userEnable",dataType = "Integer")
    })
    @GetMapping("/modifyStatus")
    @ResponseBody
    public JsonResult modifyStatus(@RequestParam("userName") String userName,@RequestParam("userEnable") Integer userEnable,Principal principal){
        return userService.modifyStatus(userName,userEnable,principal) > 0 ? new JsonResult().success().setMsg(userEnable == 0 ? "禁用成功" : "启用成功") : new JsonResult().fail(MurphyResponseCode.INTERNAL_SERVER_ERROR);
    }

    @ApiOperation("重置密码")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名",name = "userName",dataType = "String")
    })
    @PostMapping("/refresh")
    @ResponseBody
    public JsonResult refreshPassword(@RequestParam("userName") String userName,Principal principal){
        return userService.refreshPassword(userName,principal) > 0 ? new JsonResult().success().setMsg("重置成功") : new JsonResult().fail(MurphyResponseCode.INTERNAL_SERVER_ERROR);
    }

    @ApiOperation("删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户ID",name = "userId",dataType = "Integer")
    })
    @PostMapping("/delete")
    @ResponseBody
    public JsonResult deleteByUserId(@RequestParam("userId") Integer userId){
        userService.deleteByUserId(userId);
        return new JsonResult().success().setMsg("删除成功");
    }
}
