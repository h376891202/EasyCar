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
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	
	
	private static final Log4jUtils log = new Log4jUtils(MobileTerminalAccessController.class);
	
	@Autowired
	private CarOwnerService carOwnerService;

	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public  JsonResult<Object> mobileTerminalRegister(@Valid CarOwner carOwner,@Valid Car car,HttpServletRequest request,BindingResult result){

		if(result.hasErrors()){
			 List<ObjectError> ls=result.getAllErrors();  
		     log.log(LogLevel.ERROR, "【移动端注册模块】：参数校验失败"+"error:"+ls.toString());
		}
		
		JsonResult<Object> jsonResult = new JsonResult<>();
		
		jsonResult =carOwnerService.mobileTerminalRegester(carOwner, car);
		
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
	public void sendIdentifyingCode(HttpServletRequest request){
		
		String mobileNumber =request.getParameter("mobileNumber").trim();

		carOwnerService.getSMSCode(mobileNumber);
	}
	
}
