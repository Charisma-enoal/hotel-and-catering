package com.murphy.gee.common.exception;

import com.murphy.gee.common.entity.MurphyResponseCode;

/**
 * @ClassName MurphyException
 * @Description 自定义异常
 * @Author Murphy.Gee
 * @Date 2019-09-10 16:20
 * @Version 1.0
 **/
public class MurphyException extends RuntimeException {

    private MurphyResponseCode murphyResponseCode = MurphyResponseCode.INTERNAL_SERVER_ERROR;

    public MurphyException(MurphyResponseCode responseCode,String message){
        super(message);
        responseCode = murphyResponseCode;
    }


    public MurphyResponseCode getMurphyResponseCode() {
        return murphyResponseCode;
    }

    public void setMurphyResponseCode(MurphyResponseCode murphyResponseCode) {
        this.murphyResponseCode = murphyResponseCode;
    }
}
