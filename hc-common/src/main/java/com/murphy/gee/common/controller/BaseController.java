package com.murphy.gee.common.controller;

import com.murphy.gee.common.entity.JsonResult;
import com.murphy.gee.common.entity.MurphyResponseCode;
import com.murphy.gee.common.exception.MurphyException;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

/**
 * @ClassName BaseController
 * @Description 基础控制器
 * @Author Murphy.Gee
 * @Date 2019-10-11 17:01
 * @Version 1.0
 **/
public class BaseController {
    public void validData(BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String errorMsg = bindingResult.getAllErrors().stream().map(err -> "<p>" + err.getDefaultMessage() + "</p>").collect(Collectors.joining(""));
            throw new MurphyException(MurphyResponseCode.VALIDATE_ERROR,errorMsg);
        }
    }
}
