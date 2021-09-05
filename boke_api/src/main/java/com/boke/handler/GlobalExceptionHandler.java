package com.boke.handler;

import com.boke.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liyipeng
 * @date 2021-08-15 11:06
 * 全局异常处理类 ， 对加了@Controller注解的方法进行拦截处理 AOP的实现
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //进行异常处理，处理Exception.class的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody //返回json数据
    public Result doException(Exception exception){
        exception.printStackTrace();
        return Result.fail(-999,"系统异常");
    }
}
