package com.murphy.gee.sys.controller;

import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.Modules;
import com.murphy.gee.sys.service.IModulesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @ClassName ModulesController
 * @Description 模块管理控制器
 * @Author Murphy.Gee
 * @Date 2019-08-09 14:57
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/modules")
@Api(value = "模块管理接口",tags = "模块管理接口",description="模块管理接口",basePath = "/api/modules")
public class ModulesController {
    @Autowired
    private IModulesService modulesService;

    @ApiOperation("根据当前登录用户获取菜单")
    @GetMapping("/findModulesByUserName")
    @ResponseBody
    public JsonResult<List<Modules>> findModulesByUserName(Principal principal){
        return new JsonResult<List<Modules>>(modulesService.findModulesByUserName(principal.getName()));
    }
    @ApiOperation("保存模块")
    @PostMapping("/save")
    @ResponseBody
    public JsonResult saveModule(Modules modules,Principal principal) throws MurphyException {
        modules.setCreatePerson(principal.getName());
        modules.setLastEditPerson(principal.getName());
        modulesService.saveModules(modules);
        return new JsonResult().success();
    }
    @ApiOperation("查看模块")
    @GetMapping("/view")
    public JsonResult<Modules> view(@RequestParam("modulesId") Long modulesId){
        return new JsonResult<Modules>(modulesService.view(modulesId));
    }

    @ApiOperation("删除模块")
    @PostMapping("/delete")
    public JsonResult delete(@RequestParam("modulesId") Long modulesId) throws MurphyException{
        modulesService.delete(modulesId);
        return new JsonResult().success();
    }
}
