/**
 * @Title: MobileTerminalAccessController.java   
 * @Package com.gred.easy_car.web.controller.mobile   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月27日 下午4:28:32   
 * @version V2.0     
 */
package com.gred.easy_car.web.controller.mobile;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
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
import com.gred.easy_car.web.entity.JsonResult;

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
	private final String ERROR_MESSAGE_CACHE = "ErrorMessageCache";
	
	private static final Log4jUtils log = new Log4jUtils(MobileTerminalAccessController.class);
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSXXX");
	
	/**短信验证码*/
	private String identifyingCode = null;

	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public  JsonResult<Object> mobileTerminalRegister(HttpServletRequest request){

		String smsCode = request.getParameter("identifyingCode").trim();
		String userMobile = request.getParameter("userMobile");
		String  password = request.getParameter("password");
		String  carBrand = request.getParameter("carBrand");
		String  carBrandType = request.getParameter("carBrandType");
		String  carPlateNumber = request.getParameter("carPlateNumber");
		String  carTravelledDistance = request.getParameter("carTravelledDistance");
		
		JsonResult<Object> result = new JsonResult<>();
		
		//获取缓存中的六位短信验证码进行校验
		String smsCodeInCache = (String) EHCacheUtils.getElementValueFromCache(IDENTIFYING_CODE_CACHE, userMobile);
		if(StringUtils.isEmpty(smsCodeInCache)){
		//保证之前已经存入缓存的前提下 为空则说明已经失效
			result.setStatus(201);
			String message = (String) EHCacheUtils.getElementValueFromCache(ERROR_MESSAGE_CACHE, "201");
			result.setStatusMessage(message);
			log.log(LogLevel.INFO, "【移动端注册模块】：新用户注册，短信验证码验证失败："+message);
			
			return result;
		}else if(!smsCodeInCache.equals(smsCode)){
			//用户输入验证码和发送验证码不匹配
			result.setStatus(202);
			String message = (String) EHCacheUtils.getElementValueFromCache(ERROR_MESSAGE_CACHE, "202");
			result.setStatusMessage(message);
			log.log(LogLevel.INFO, "【移动端注册模块】：新用户注册，短信验证码验证失败："+message);
			
			return result;
		}
		
		
		
		
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
