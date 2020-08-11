//package com.tommy.example.appconfig;
//
//import com.tommy.example.controller.ParameterLogger;
//import com.tommy.example.ms.controller.user.AclInterceptor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Component
//public class InterceptorConfig extends WebMvcConfigurerAdapter {
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        //配置拦截器
//        AclInterceptor aclInterceptor = new AclInterceptor();
//        aclInterceptor.setIgnores("/admin/home,/admin/home,/admin/menu,/admin/muser/changepwd,/admin/muser/updatepwd,/admin/muser/checkpwd,/admin/upload/uploadfile,/admin/upload/showFile");
//        aclInterceptor.setLoginURI("scala_ms_login");
//        registry.addInterceptor(aclInterceptor).addPathPatterns("/admin/**");
//
//        ParameterLogger parameterLogger = new ParameterLogger();
//        registry.addInterceptor(parameterLogger).addPathPatterns("/**");
//    }
//
//}
