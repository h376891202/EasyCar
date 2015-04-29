/**
 * @Title: MobileTerminalAccessController.java   
 * @Package com.gred.easy_car.web.controller.mobile   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月27日 下午4:28:32   
 * @version V2.0     
 */
package com.gred.easy_car.web.controller.mobile;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gred.easy_car.common.constant.SMSInterfaceInfo;
import com.gred.easy_car.common.constant.SMSInvokeResult;
import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.EHCacheUtils;
import com.gred.easy_car.common.utils.HttpUtils;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.common.utils.RandomNumberUtils;

/**
 * @ClassName: MobileTerminalAccessController   
 * @Description: (移动端用户入口)   
 * @author WangJianbin  
 * @date 2015年4月27日 下午4:28:32   
 *
 */
@RestController //spring4新特性 此类所有方法均返回json 相当于所有方法打上 @ResponseBody
@RequestMapping(value="mobile")
public class MobileTerminalAccessController {
	
	/**EH缓存XML配置文件中配置的缓存*/
	private  final String IDENTIFYING_CODE_CACHE = "SMSCodeCache";
	
	private static final Log4jUtils log = new Log4jUtils(MobileTerminalAccessController.class);
	
	/**短信验证码*/
	private String identifyingCode = null;

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public  String mobileTerminalRegister(HttpServletRequest request){
		
		
		return null;
	}
	
	@RequestMapping(value="/IdentifyingCode",method=RequestMethod.GET)
	public void sendIdentifyingCode(HttpServletRequest request){
		
		String mobileNumber =request.getParameter("mobileNumber").trim();
		//生成六位数随机验证码 
		identifyingCode=RandomNumberUtils.generateRandomNumber(6);
		
		//保存验证码到EHCache中，用于验证
		EHCacheUtils.putElementToCache(IDENTIFYING_CODE_CACHE, mobileNumber, identifyingCode);
		
		Map<String, String> params = new HashMap<>();
		params.put("username", SMSInterfaceInfo.SMS_USERNAME);
		params.put("password", SMSInterfaceInfo.SMS_PASSWORD);
		params.put("apikey", SMSInterfaceInfo.APIKEY);
		params.put("mobile", mobileNumber);
		params.put("content", "您的注册验证码为："+identifyingCode+"【智睿达车联网】");
		
		String result = HttpUtils.doHttpGet(SMSInterfaceInfo.SMS_SEND_URL, params);
		
		if(result.contains(SMSInvokeResult.STATUS_SUCCESS)){
			//发信成功
			log.log(LogLevel.INFO, "【移动端注册模块】：新用户注册，发送验证短信成功"+result+",发送号码为："+mobileNumber);
		}
		if(result.contains(SMSInvokeResult.STATUS_FAILED)){
			//短信接口调用失败
			log.log(LogLevel.ERROR, "【移动端注册模块】：发送短信验证码失败，短信接口异常："+result+",发送号码为："+mobileNumber);
		}
		
	}
	
}
