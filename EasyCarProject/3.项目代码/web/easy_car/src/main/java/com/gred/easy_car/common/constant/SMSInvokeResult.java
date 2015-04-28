/**
 * @Title: SMSInvokeResult.java   
 * @Package com.gred.easy_car.common.constant   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月27日 下午5:05:29   
 * @version V2.0     
 */
package com.gred.easy_car.common.constant;

/**
 * @ClassName: SMSInvokeResult   
 * @Description: (短信接口调用返回结果)   
 * @author WangJianbin  
 * @date 2015年4月27日 下午5:05:29   
 *
 */
public interface SMSInvokeResult {

	/**短信接口调用成功*/
	String STATUS_SUCCESS ="success";
	/**短信接口调用失败*/
	String STATUS_FAILED = "error";
	/**用户名为空*/
	String MISSING_USERNAME = "Missing username";
	/**密码为空*/
	String MISSING_PASSWORD = "Missing password";
	/**apikey为空*/
	String MISSING_APIKEY = "Missing apikey";
	/**手机号码为空*/
	String MISSING_RECIPIENT= "Missing recipient";
	/**短信内容为空*/
	String MISSING_MESSAGE_CONTENT = "Missing message content";
	/**账号被禁用*/
	String ACCOUNT_BLOCKED = "Account is blocked";
	/**编码未能识别*/
	String UNRECOGNIZED_ENDODING = "Unrecognized encoding";
	/**apikey 或者密码错误*/
	String APIKEY_OR_PASSWORD_ERROR = "APIKEY or password error";
	/**未授权地址*/
	String UNAUTHORIZED_IP = "Unauthorized IP address";
	/**余额不足*/
	String ACCOUNT_BALANCE_INSUFFICIENT = "Account balance is insufficient";
	
	
}
