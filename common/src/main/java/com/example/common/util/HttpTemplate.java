package com.example.common.util;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpTemplate {

    private static Logger logger = LoggerFactory.getLogger(HttpTemplate.class);

    private static String map2ParaStr(Map<String, Object> map) throws Exception {
        StringBuffer buffer = new StringBuffer();
        if (map == null) {
            return "";
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object val = entry.getValue();
            if (val instanceof String) {
                val = URLEncoder.encode((String) val, "UTF-8");
            }
            buffer.append(entry.getKey()).append("=").append(val).append("&");
        }
        return buffer.toString();
    }

    public static String post(String host, String action, Map<String, Object> paraMap) {
        return post(host + action, paraMap);
    }

    public static String post(String hostAction, Map<String, Object> paraMap) {
        /*
         * 如果连接地址为 null ，那么证明当前环境无法连接到服务器，直接返回 null
         */
        if (hostAction == null) {
            return null;
        }

        OutputStreamWriter out = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            // Post请求的url，与get不同的是不需要带参数
            URL postUrl = new URL(hostAction);
            // 打开连接
            HttpURLConnection con = (HttpURLConnection) postUrl.openConnection();
            con.setRequestMethod("POST");
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
            // http正文内，因此需要设为true, 默认情况下是false;
            con.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            con.setDoInput(true);
            // Post 请求不能使用缓存
            con.setUseCaches(false);
            // 设定传送的内容类型是可序列化的java对象
            // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
            con.addRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            out = new OutputStreamWriter(con.getOutputStream());
            String content = map2ParaStr(paraMap);
            out.write(content);//map2ParaStr(paraMap)
            out.flush();
            isr = new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                buf.append(line);
            }

            return buf.toString();

        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            disconnect(out, isr, br);
        }
        return null;
    }

    public static JSONObject postAndObtainJson(String host, String action, Map<String, Object> paraMap) {
        String result = post(host, action, paraMap);
        if (result != null) {
            return JSONObject.fromObject(result);
        }
        else {
            return null;
        }
    }

    public static JSONObject postAndObtainJson(String hostAction, Map<String, Object> paraMap) {
        String result = post(hostAction, paraMap);
        if (result != null) {
            return JSONObject.fromObject(result);
        }
        else {
            return null;
        }
    }

    public static JSONObject getAndObtainJson(String host, String action, Map<String, Object> paraMap) {
        String result = get(host+action, paraMap);
        if (result != null) {
            return JSONObject.fromObject(result);
        }
        else {
            return null;
        }
    }

    public static JSONObject getAndObtainJson(String hostAction, Map<String, Object> paraMap) {
        String result = get(hostAction, paraMap);
        if (result != null) {
            return JSONObject.fromObject(result);
        }
        else {
            return null;
        }
    }

    public static String get(String action, Map<String, Object> paraMap) {
        OutputStreamWriter out = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            URL url = new URL(action);
            // 打开连接
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            out = new OutputStreamWriter(con.getOutputStream());
            out.write(map2ParaStr(paraMap));
            out.flush();
            isr = new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                buf.append(line);
            }

            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(out, isr, br);
        }
        return null;
    }

    private static void disconnect(OutputStreamWriter out, InputStreamReader isr, BufferedReader br) {
        try {
            if (out != null) {
                out.close();
                out = null;
            }
            if (isr != null) {
                isr.close();
                isr = null;
            }
            if (br != null) {
                br.close();
                br = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
