package com.example.common.model;

import java.io.Serializable;

/**
 * 接口返回的数据类型
 * @author : Ocean
 * @date : 19-3-29
 */
public class ResponseVo implements Serializable {
    /**
     * 业务上成功与否的标志，0 表示成功，其它表示失败
     */
    private Integer code;
    /**
     * 返回的数据
     */
    private Object data;
    /**
     * 提示信息
     */
    private String msg;

    private Integer total;

    public static ResponseVo success() {
        ResponseVo vo = new ResponseVo();
        vo.setCode(0);
        return vo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
