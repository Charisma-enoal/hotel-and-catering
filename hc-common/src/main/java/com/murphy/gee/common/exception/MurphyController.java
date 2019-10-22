package com.murphy.gee.common.exception;

import com.murphy.gee.common.entity.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName MurphyController
 * @Description 全局异常处理
 * @Author Murphy.Gee
 * @Date 2019-09-10 17:03
 * @Version 1.0
 **/
@RestControllerAdvice
public class MurphyController {
    @ExceptionHandler(value = MurphyException.class)
    public JsonResult handlerMurphyException(MurphyException ex){
        return new JsonResult().setCode(ex.getMurphyResponseCode()).setMsg(ex.getMessage());
    }
}
