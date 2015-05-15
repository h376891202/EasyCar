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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gred.easy_car.common.constant.SMSInterfaceInfo;
import com.gred.easy_car.common.constant.SMSInvokeResult;
import com.gred.easy_car.common.constant.SystemMessageConstant;
import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.CiphertextUtil;
import com.gred.easy_car.common.utils.EHCacheUtils;
import com.gred.easy_car.common.utils.HttpUtils;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.common.utils.RandomNumberUtils;
import com.gred.easy_car.common.utils.UUIDGenerator;
import com.gred.easy_car.web.entity.Car;
import com.gred.easy_car.web.entity.CarOwner;
import com.gred.easy_car.web.entity.JsonResult;
import com.gred.easy_car.web.mapper.CarOwnerMapper;
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
	
	
	private static final Log4jUtils log = new Log4jUtils(CarOwnerServiceImpl.class);
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSXXX");
	
	/**短信验证码*/
	private String identifyingCode = null;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarOwnerMapper carOwnerMapper;
	/* 
	 * <p>Title: mobileTerminalRegester</p>   
	 * <p>Description: </p>   
	 * @param carOwner
	 * @param car
	 * @return   
	 * @see com.gred.easy_car.web.service.CarOwnerService#mobileTerminalRegester(com.gred.easy_car.web.entity.CarOwner, com.gred.easy_car.web.entity.Car)   
	 */   
	@Transactional
	@Override
	public JsonResult<Object> mobileTerminalRegester(CarOwner carOwner) {

		JsonResult<Object> result = new JsonResult<>();
		
		//获取缓存中的六位短信验证码进行校验
		String smsCodeInCache = (String) EHCacheUtils.getElementValueFromCache(IDENTIFYING_CODE_CACHE, carOwner.getUserMobile());
		if(StringUtils.isEmpty(smsCodeInCache)){
		//保证之前已经存入缓存的前提下 为空则说明已经失效
			result.setStatus(201);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "201");
			result.setStatusMessage(message);
			log.log(LogLevel.INFO, "【移动端注册模块】：新用户注册，短信验证码验证失败："+message);
			
			return result;
		}else if(!smsCodeInCache.equals(carOwner.getIdentifyingCode())){
			//用户输入验证码和发送验证码不匹配
			result.setStatus(202);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "202");
			result.setStatusMessage(message);
			log.log(LogLevel.INFO, "【移动端注册模块】：新用户注册，短信验证码验证失败："+message);
			
			return result;
		}
		if(!StringUtils.isEmpty(carOwner.getRepeatedPwd())){
			if(!carOwner.getUserPwd().equals(carOwner.getRepeatedPwd())){
				result.setStatus(203);
				String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "203");
				result.setStatusMessage(message);
				log.log(LogLevel.ERROR, "【移动端注册模块】：两次输入密码不一致");
				return result;
			}
		}						
		
		try {
			carOwner.setUserId(UUIDGenerator.generateUUID());
			carOwner.setUserRegisterTime(format.format(new Date()));
			carOwner.setUserPwd(CiphertextUtil.passAlgorithmsCiphering(carOwner.getUserPwd(), CiphertextUtil.MD5));
			
			save(carOwner);
			
		} catch (DuplicateKeyException e) {
			//此异常代表违反数据库唯一约束
			result.setStatus(102);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "102");
			result.setStatusMessage(message);
			log.log(LogLevel.ERROR, "【移动端注册模块】：注册失败，手机号码为："+carOwner.getUserMobile()+"用户已经存在！", e);
			return result;
		}
		
		try {
			Car car = new Car();
			car.setCarId(UUIDGenerator.generateUUID());
			car.setCarOwnerId(carOwner.getUserId());
			car.setCarOwnerMobile(carOwner.getUserMobile());
			car.setCarBrand(carOwner.getCarBrand());
			car.setCarBrandType(carOwner.getCarBrandType());
			car.setCarPlateNumber(carOwner.getCarPlateNumber());
			car.setCarTravelledDistance(Float.valueOf(carOwner.getCarTravelledDistance()));
			
			carService.save(car);
		} catch (DuplicateKeyException e) {
			result.setStatus(106);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "106");
			result.setStatusMessage(message);
			log.log(LogLevel.ERROR, "【移动端注册模块】：注册失败，车牌号为："+carOwner.getCarPlateNumber()+"，车辆已经存在！", e);
			return result;
		}
		
		result.setStatus(107);
		String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "107");
		result.setStatusMessage(message);
		log.log(LogLevel.INFO, "【移动端注册模块】：注册成功，车牌号为："+carOwner.getCarPlateNumber());
		
		return result;
	}
	
	@Override
	public  JsonResult<Object> getSMSCode(String mobileNumber){
				
				JsonResult<Object> jsonResult = new JsonResult<>();
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
					jsonResult.setStatus(204);
					String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "204");
					jsonResult.setStatusMessage(message);
					log.log(LogLevel.INFO, "【移动端注册模块】：发送短信验证码成功"+result+",发送号码为："+mobileNumber);
					
					return jsonResult;
				}
				if(result.contains(SMSInvokeResult.STATUS_FAILED)){
					//短信接口调用失败
					jsonResult.setStatus(205);
					String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "205");
					jsonResult.setStatusMessage(message);
					log.log(LogLevel.ERROR, "【移动端注册模块】：发送短信验证码失败，短信接口异常："+result+",发送号码为："+mobileNumber);
					
					return jsonResult;
				}
				
				return null;
				
	}

	

	/* 
	 * <p>Title: validateCarOwner</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.gred.easy_car.web.service.CarOwnerService#validateCarOwner()   
	 */   
	@Override
	public JsonResult<Object> validateCarOwner(CarOwner carOwner) {
		JsonResult<Object> jsonResult = new JsonResult<>();
		CarOwner owner =carOwnerMapper.selectByMobile(carOwner.getUserMobile());
		if(owner==null){
			log.log(LogLevel.ERROR, "【用户登陆模块】：用户名不存在");
			jsonResult.setStatus(103);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "103");
			jsonResult.setStatusMessage(message);
			return jsonResult;
		}else{
			if(CiphertextUtil.verifyPassword(carOwner.getUserPwd(), CiphertextUtil.MD5, owner.getUserPwd())){
				//验证通过
				log.log(LogLevel.ERROR, "【用户登陆模块】：用户"+carOwner.getUserMobile()+"登陆成功！");
				jsonResult.setStatus(105);
				String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "105");
				jsonResult.setStatusMessage(message);
				List<Object> list = new ArrayList<>();
				Object uid  = owner.getUserId();
				list.add(uid);
				jsonResult.setData(list);
				
				//TODO 返回用户uuid 用与取des对称秘钥
				
				return jsonResult;
			}else{
				//用户名密码不匹配
				log.log(LogLevel.ERROR, "【用户登陆模块】：用户名和密码不匹配"+carOwner.getUserMobile()+"登陆失败！");
				jsonResult.setStatus(104);
				String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "104");
				jsonResult.setStatusMessage(message);
				return jsonResult;
			}
		}
		
		
	}

	/* 
	 * <p>Title: resetPwd</p>   
	 * <p>Description: </p>   
	 * @param carOwner   
	 * @see com.gred.easy_car.web.service.CarOwnerService#resetPwd(com.gred.easy_car.web.entity.CarOwner)   
	 */   
	@Transactional
	@Override
	public JsonResult<Object> resetPwd(CarOwner carOwner) {
		
		JsonResult<Object> jsonResult = new JsonResult<>();
		//获取缓存中的六位短信验证码进行校验
				String smsCodeInCache = (String) EHCacheUtils.getElementValueFromCache(IDENTIFYING_CODE_CACHE, carOwner.getUserMobile());
				if(StringUtils.isEmpty(smsCodeInCache)){
				//保证之前已经存入缓存的前提下 为空则说明已经失效
					jsonResult.setStatus(201);

					String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "201");

					jsonResult.setStatusMessage(message);
					log.log(LogLevel.INFO, "【移动端注册模块】：新用户注册，短信验证码验证失败："+message);
					
					return jsonResult;
				}else if(!smsCodeInCache.equals(carOwner.getIdentifyingCode())){
					//用户输入验证码和发送验证码不匹配
					jsonResult.setStatus(202);

					String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "202");

					jsonResult.setStatusMessage(message);
					log.log(LogLevel.INFO, "【移动端注册模块】：新用户注册，短信验证码验证失败："+message);
					
					return jsonResult;
				}
				
				try {
					CarOwner owner = carOwnerMapper.selectByMobile(carOwner.getUserMobile());
					owner.setUserPwd(CiphertextUtil.passAlgorithmsCiphering(carOwner.getUserPwd(), CiphertextUtil.MD5));
					carOwnerMapper.updateByPrimaryKeySelective(owner);
				} catch (Exception e) {
					jsonResult.setStatus(109);

					String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "109");

					jsonResult.setStatusMessage(message);
					log.log(LogLevel.ERROR, "【移动端重置密码模块】：重置失败，用户电话号码号为："+carOwner.getUserMobile()+"，数据库操作异常！", e);
					return jsonResult;
				}
				jsonResult.setStatus(110);

				String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "110");

				jsonResult.setStatusMessage(message);
				log.log(LogLevel.ERROR, "【移动端重置密码模块】：重置成功，用户电话号码号为："+carOwner.getUserMobile());
				
				return jsonResult;
		
		
	}

	

}
