package com.haohao.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//使用SpringMVC提供的异常处理器做统一的异常处理。
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R doOtherException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        ex.printStackTrace();
        //发送错误消息
        return new R(false,"系统错误，请稍后再试！");
    }
}