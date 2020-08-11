//package com.tommy.example.appconfig;
//
//import com.tommy.example.controller.ServletExceptionHandler;
//import com.tommy.example.exception.ExceptionAdvisor;
//import com.tommy.example.util.Configuration;
//import com.tommy.example.util.BackroomDataUtils;
//import org.springframework.context.annotation.Bean;
//
///**
// * date  : 18/11/22
// * author: Ocean
// */
//@org.springframework.context.annotation.Configuration
//public class BeanConfig {
//    @Bean
//    public ExceptionAdvisor exceptionAdvisor() {
//        return new ExceptionAdvisor();
//    }
//
//    @Bean
//    public ServletExceptionHandler servletExceptionHandler() {
//        ServletExceptionHandler handler = new ServletExceptionHandler();
//        handler.setViewURL("/admin/error");
//        handler.setMsgAttribute("msg");
//        return handler;
//    }
//
//    @Bean
//    public BackroomDataUtils backroomDataUtils() {
//        BackroomDataUtils bean = new BackroomDataUtils();
//        BackroomDataUtils.setDataKey(Configuration.DATA_KEY);
//        // 不需要中间件了，直接读取配置库，然后解密
//        BackroomDataUtils.listEcu();
//        return bean;
//    }
//}
