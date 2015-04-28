/**
 * @Title: SMSInterfaceTest.java   
 * @Package log.test   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月27日 下午6:49:10   
 * @version V2.0     
 */
package sms.test;



import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.junit.Test;

import com.gred.easy_car.common.constant.SMSInterfaceInfo;
import com.gred.easy_car.common.utils.HttpUtils;

/**
 * @ClassName: SMSInterfaceTest   
 * @Description: (短信接口测试类)   
 * @author WangJianbin  
 * @date 2015年4月27日 下午6:49:10   
 *
 */
public class SMSInterfaceTest {

	@Test
	public void sendTest() {
		
		Map<String, String> params = new HashMap<>();
		params.put("username", SMSInterfaceInfo.SMS_USERNAME);
		params.put("password", SMSInterfaceInfo.SMS_PASSWORD);
		params.put("apikey", SMSInterfaceInfo.APIKEY);
		params.put("mobile", "15680791397");
		params.put("content", "这是一个测试");
		
		 String result = HttpUtils.doHttpGet(SMSInterfaceInfo.SMS_SEND_URL, params); //经过实测，短信接口用post发送时，会乱码，用get正常
		 System.out.println(result);
		
	}
	
	@Test
	public void queryTest(){
		
	}

}
