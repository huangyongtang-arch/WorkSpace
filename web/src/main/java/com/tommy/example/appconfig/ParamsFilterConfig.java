//package com.tommy.example.appconfig;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 参数过滤
// * @author Administrator
// */
//@Component
//@WebFilter(urlPatterns = {"/admin/*"})
//public class ParamsFilterConfig implements Filter {
//
//    /**
//     * 过滤器初始化
//     * @param filterConfig
//     */
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    /**
//     * 执行过滤器
//     * @param servletRequest
//     * @param servletResponse
//     * @param filterChain
//     * @throws IOException
//     * @throws
//     */
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        //修改传入的参数
//        ParamsRequestWrapper wrapper = new ParamsRequestWrapper(request);
//        filterChain.doFilter(wrapper, response);
//    }
//
//    /**
//     * 过滤器销毁
//     */
//    @Override
//    public void destroy() {
//
//    }
//}
