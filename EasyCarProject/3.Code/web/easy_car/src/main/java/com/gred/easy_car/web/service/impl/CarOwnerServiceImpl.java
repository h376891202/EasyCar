/**
 * @Title: CarOwnerServiceImpl.java   
 * @Package com.gred.easy_car.web.service.impl   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月8日 下午1:51:33   
 * @version V2.0     
 */
package com.gred.easy_car.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gred.easy_car.common.constant.SMSInterfaceInfo;
import com.gred.easy_car.common.constant.SMSInvokeResult;
import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.EHCacheUtils;
import com.gred.easy_car.common.utils.HttpUtils;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.common.utils.RandomNumberUtils;
import com.gred.easy_car.common.utils.UUIDGenerator;
import com.gred.easy_car.web.controller.mobile.MobileTerminalAccessController;
import com.gred.easy_car.web.entity.Car;
import com.gred.easy_car.web.entity.CarOwner;
import com.gred.easy_car.web.entity.JsonResult;
import com.gred.easy_car.web.service.CarOwnerService;
import com.gred.easy_car.web.service.CarService;

/**
 * @ClassName: CarOwnerServiceImpl   
 * @Description: 移动端注册以及登陆服务接口实现类   
 * @author WangJianbin  
 * @date 2015年5月8日 下午1:51:33   
 *
 */
@Service
public class CarOwnerServiceImpl extends BaseServiceImpl<CarOwner, String> implements CarOwnerService{

	
	
	/**EH缓存XML配置文件中配置的缓存*/
	private  final String IDENTIFYING_CODE_CACHE = "SMSCodeCache";
	
	private  final String ERROR_MESSAGE_CACHE = "ErrorMessageCache";
	
	private static final Log4jUtils log = new Log4jUtils(MobileTerminalAccessController.class);
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSXXX");
	
	/**短信验证码*/
	private String identifyingCode = null;
	
	@Autowired
	private CarService carService;
	/* 
	 * <p>Title: mobileTerminalRegester</p>   
	 * <p>Description: </p>   
	 * @param carOwner
	 * @param car
	 * @return   
	 * @see com.gred.easy_car.web.service.CarOwnerService#mobileTerminalRegester(com.gred.easy_car.web.entity.CarOwner, com.gred.easy_car.web.entity.Car)   
	 */   
	@Override
	public JsonResult<Object> mobileTerminalRegester(CarOwner carOwner, Car car) {

		JsonResult<Object> result = new JsonResult<>();
		
		//获取缓存中的六位短信验证码进行校验
		String smsCodeInCache = (String) EHCacheUtils.getElementValueFromCache(IDENTIFYING_CODE_CACHE, carOwner.getUserMobile());
		if(StringUtils.isEmpty(smsCodeInCache)){
		//保证之前已经存入缓存的前提下 为空则说明已经失效
			result.setStatus(201);
			String message = (String) EHCacheUtils.getElementValueFromCache(ERROR_MESSAGE_CACHE, "201");
			result.setStatusMessage(message);
			log.log(LogLevel.INFO, "【移动端注册模块】：新用户注册，短信验证码验证失败："+message);
			
			return result;
		}else if(!smsCodeInCache.equals(carOwner.getIdentifyingCode())){
			//用户输入验证码和发送验证码不匹配
			result.setStatus(202);
			String message = (String) EHCacheUtils.getElementValueFromCache(ERROR_MESSAGE_CACHE, "202");
			result.setStatusMessage(message);
			log.log(LogLevel.INFO, "【移动端注册模块】：新用户注册，短信验证码验证失败："+message);
			
			return result;
		}
		if(!StringUtils.isEmpty(carOwner.getRepeatedPwd())){
			if(carOwner.getUserPwd().equals(carOwner.getRepeatedPwd())){
				result.setStatus(203);
				String message = (String) EHCacheUtils.getElementValueFromCache(ERROR_MESSAGE_CACHE, "203");
				result.setStatusMessage(message);
				log.log(LogLevel.ERROR, "【移动端注册模块】：两次输入密码不一致");
			}
		}
		
		carOwner.setUserId(UUIDGenerator.generateUUID());
		car.setCarId(UUIDGenerator.generateUUID());
		save(carOwner);
		
		carService.save(car);
		
		return null;
	}
	
	@Override
	public  void getSMSCode(String mobileNumber){
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

	/* 
	 * <p>Title: mobileTerminalLogin</p>   
	 * <p>Description: </p>   
	 * @param carOwner
	 * @return   
	 * @see com.gred.easy_car.web.service.CarOwnerService#mobileTerminalLogin(com.gred.easy_car.web.entity.CarOwner)   
	 */   
	@Override
	public JsonResult<Car> mobileTerminalLogin(CarOwner carOwner) {
		
		
		return null;
	}

	

}
