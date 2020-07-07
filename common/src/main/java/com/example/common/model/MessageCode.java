package com.example.common.model;

/**
 * 消息错误码以及部分规定的消息
 *
 */
public class MessageCode {

	/**
	 * 成功，并且有数据或者没有任何系统和逻辑的异常的返回code
	 */
	public static int CODE_200 = 200;
	/**
	 * 成功，并且有数据或者没有任何系统和逻辑的异常的返回code
	 */
	public static String MESSAGE_200 = "成功";
	
	/**
	 * 缺失参数
	 */
	public static int CODE_201 = 201;
	/**
	 * 缺失参数
	 */
	public static String MESSAGE_201 = "缺失参数";
	
	/**
	 * 数据格式错误 code
	 */
	public static int CODE_202 = 202;
	
	/**
	 * 数据格式错误 code
	 */
	public static String MESSAGE_202 = "数据格式错误";
	
	/**
	 * 参数有误
	 */
	public static int CODE_400 = 400;
	public static String MESSAGE_400 = "参数有误";
	
	/**
	 *没有权限的code
	 */
	public static int CODE_403 = 403;
	public static String MESSAGE_403 = "没有权限";

	/**
	 * 登录session失效
	 */
	public static int CODE_403001 = 403001;
	public static String MESSAGE_403001 = "登录失效";
	/**
	 * 标识没有任何数据的返回code
	 */
	public static int CODE_404 = 404;
	/**
	 * 标识没有任何数据的返回code
	 */
	public static String MESSAGE_404 = "没有任何数据";
	/**
	 * 在运行的时候，出现系统异常，并且没有终止程序的时候返回的code
	 */
	
	/**
	 * 405 已经存在
	 */
	public static int CODE_405 = 405;
	
	/**
	 * 405 已经存在
	 */
	public static String MESSAGE_405 = "已经存在";
	
	public static int CODE_500 = 500;
	/**
	 * 在运行的时候，出现系统异常，并且没有终止程序的时候返回的code
	 */
	public static String MESSAGE_500 = "服务器错误";
	
	/**
	 *  501 操作失败
	 */
	public static int CODE_501 = 501;
	/**
	 *  501 操作失败
	 */
	public static String MESSAGE_501 = "操作失败";
	
	/**
	 * 第三方平台服务器通道未打开
	 */
	public static int CODE_1000 = 1000;
	public static String MESSAGE_1000 = "业务系统维护中";
	
	/**
	 * 第三方平台服务器忙，请稍后再试
	 */
	public static int CODE_1001 = 1001;
	public static String MESSAGE_1001 = "业务系统外联开关切换失败";

	/**
	 * 重复操作
	 */
	public static int CODE_300 = 300;
	/**
	 * 重复操作
	 */
	public static String MESSAGE_300 = "重复操作";

	public static String MESSAGE_SUCCESS = "success";
	public static String MESSAGE_FAILURE = "failure";

}
