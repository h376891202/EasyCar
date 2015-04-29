/**
 * @Title: SMSInterfaceUrl.java   
 * @Package com.gred.easy_car.common.constant   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月27日 下午6:30:39   
 * @version V2.0     
 */
package com.gred.easy_car.common.constant;

/**
 * @ClassName: SMSInterfaceUrl   
 * @Description: (短信接口http请求地址)   
 * @author WangJianbin  
 * @date 2015年4月27日 下午6:30:39   
 *
 */
public interface SMSInterfaceInfo {

	/**美联软通短信发送接口地址*/
	String SMS_SEND_URL = "http://m.5c.com.cn/api/send/index.php";
	/**美联软通查询接口地址*/
	String SMS_QUERY_URL="http://m.5c.com.cn/api/query/index.php";
	/**美联软通APIKEY*/
	String APIKEY="37895b55153ec7698722d66407b6b33c";
	/**美联软通短信用户名*/
	String SMS_USERNAME="zhirui";
	/**美联软通短信密码*/
	String SMS_PASSWORD="ml150210";
	
}
