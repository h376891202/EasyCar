/**
 * @Title: MobileTerminalAccessController.java   
 * @Package com.gred.easy_car.web.controller.mobile   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月27日 下午4:28:32   
 * @version V2.0     
 */
package com.gred.easy_car.web.controller.mobile;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.EHCacheUtils;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.web.entity.Car;
import com.gred.easy_car.web.entity.CarOwner;
import com.gred.easy_car.web.entity.JsonResult;
import com.gred.easy_car.web.service.CarOwnerService;

/**
 * @ClassName: MobileTerminalAccessController   
 * @Description: (移动端用户入口)   
 * @author WangJianbin  
 * @date 2015年4月27日 下午4:28:32   
 *
 */
@RestController //spring4新特性 此类所有方法均返回json 相当于所有方法打上 @ResponseBody
@RequestMapping(value="login")
public class MobileTerminalAccessController {
	
	private  final String ERROR_MESSAGE_CACHE = "ErrorMessageCache";
	
	private static final Log4jUtils log = new Log4jUtils(MobileTerminalAccessController.class);
	
	@Autowired
	private CarOwnerService carOwnerService;

	
	/**
	 * 
	 * @Title: mobileTerminalLogin   
	 * @Description: 移动端登陆
	 * @param @param carOwner
	 * @param @param result
	 * @param @return    
	 * @return JsonResult<Object>    返回类型   
	 * @throws
	 */
	@RequestMapping(method=RequestMethod.POST)
	public JsonResult<Object> mobileTerminalLogin(@Valid CarOwner carOwner,BindingResult result){
		JsonResult<Object> jsonResult = new JsonResult<>();
		if(result.hasErrors()){
			 List<ObjectError> ls=result.getAllErrors();  
		     log.log(LogLevel.ERROR, "【移动端注册模块】：参数校验失败"+"error:"+ls.toString());
		     jsonResult.setStatus(101);
		     String  message = (String) EHCacheUtils.getElementValueFromCache(ERROR_MESSAGE_CACHE, "101");
		     jsonResult.setStatusMessage(message);
		     return jsonResult;
		}
		jsonResult = carOwnerService.validateCarOwner(carOwner);
		
		return jsonResult;
	}
	
	
	/**
	 * 
	 * @Title: mobileTerminalRegister   
	 * @Description: 移动端注册
	 * @param @param carOwner
	 * @param @param car
	 * @param @param request
	 * @param @param result
	 * @param @return    
	 * @return JsonResult<Object>    返回类型   
	 * @throws
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public  JsonResult<Object> mobileTerminalRegister(@Valid CarOwner carOwner,BindingResult result){
		JsonResult<Object> jsonResult = new JsonResult<>();
		
		if(result.hasErrors()){
			 List<ObjectError> ls=result.getAllErrors();  
		     log.log(LogLevel.ERROR, "【移动端注册模块】：参数校验失败"+"error:"+ls.toString());
		     jsonResult.setStatus(101);
		     String  message = (String) EHCacheUtils.getElementValueFromCache(ERROR_MESSAGE_CACHE, "101");
		     jsonResult.setStatusMessage(message);
		     return jsonResult;
		}
		
		jsonResult =carOwnerService.mobileTerminalRegester(carOwner);
		
		return jsonResult;
	}
	
	
	/**
	 * 
	 * @Title: sendIdentifyingCode   
	 * @Description: 移动端获取验证码接口
	 * @param @param request    
	 * @return void    返回类型   
	 * @throws
	 */
	@RequestMapping(value="/IdentifyingCode",method=RequestMethod.GET)
	public JsonResult<Object> sendIdentifyingCode(HttpServletRequest request){
		JsonResult<Object> jsonResult = new JsonResult<>();
		String mobileNumber = request.getParameter("mobileNumber");
		if(StringUtils.isEmpty(mobileNumber)){
			log.log(LogLevel.ERROR, "【移动端注册模块】：请求中不存在 mobileNumber 参数！");
			jsonResult.setStatus(108);
			String message = (String) EHCacheUtils.getElementValueFromCache(ERROR_MESSAGE_CACHE, "108");
			jsonResult.setStatusMessage(message);
			return jsonResult;
		}
		
		
		jsonResult= carOwnerService.getSMSCode(mobileNumber);
		
		return jsonResult;
	}
	
	/**
	 * 
	 * @Title: resetPassword   
	 * @Description: 移动端重置密码
	 * @param @param carOwner
	 * @param @return    
	 * @return JsonResult<Object>    返回类型   
	 * @throws
	 */
	@RequestMapping(value ="/resetPwd",method=RequestMethod.POST)
	public JsonResult<Object> resetPassword(CarOwner carOwner){
		
		JsonResult<Object> jsonResult = new JsonResult<>();
		jsonResult= carOwnerService.resetPwd(carOwner);
		return jsonResult;
		
	}
	
}
