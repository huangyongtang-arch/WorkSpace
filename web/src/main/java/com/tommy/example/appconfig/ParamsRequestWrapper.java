//package com.tommy.example.appconfig;
//
//import org.springframework.web.util.HtmlUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 继承javax.servlet.http.HttpServletRequestWrapper装饰者类
// * 修改request中参数
// * @author Administrator
// */
//public class ParamsRequestWrapper extends HttpServletRequestWrapper {
//
//    private Map<String, String[]> params = new HashMap<>();
//    /**
//     * Constructs a request object wrapping the given request.
//     *
//     * @param request
//     * @throws IllegalArgumentException if the request is null
//     */
//    public ParamsRequestWrapper(HttpServletRequest request) {
//        super(request);
//        /**
//         * 将参数表，赋予给当前的Map以便于持有request中的参数
//         */
//        RefreshParams(request);
//    }
//
//    /**
//     * 重写getParameter方法
//     *
//     * @param name 参数名
//     * @return 返回参数值
//     */
//    @Override
//    public String getParameter(String name) {
//        String[] values = params.get(name);
//        if (values == null || values.length == 0) {
//            return null;
//        }
//        return values[0];
//    }
//
//    @Override
//    public String[] getParameterValues(String name) {
//        String[] values = params.get(name);
//        if (values == null || values.length == 0) {
//            return null;
//        }
//        return values;
//    }
//
//    /**
//     * 编译请求参数
//     * @param request
//     */
//    private void RefreshParams(HttpServletRequest request){
//        Map<String, String[]> temp_params=request.getParameterMap();
//        Map<String, String[]> result=new HashMap<>();
//        /**
//         * 遍历之前的请求参数并重新赋值
//         */
//        temp_params.forEach((k, v) ->{
//            String[] values = new String[v.length];
//            for(int i=0;i<v.length;i++){
//                values[i]=HtmlUtils.htmlEscape(v[i]) ;
//            }
//            result.put(k,values);
//        });
//        this.params.putAll(result);
//    }
//
//}
