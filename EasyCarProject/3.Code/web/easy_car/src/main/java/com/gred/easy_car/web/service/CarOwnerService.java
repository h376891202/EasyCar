/**
 * @Title: CarOwnerService.java   
 * @Package com.gred.easy_car.web.service   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月8日 下午1:45:54   
 * @version V2.0     
 */
package com.gred.easy_car.web.service;

import com.gred.easy_car.web.entity.Car;
import com.gred.easy_car.web.entity.CarOwner;
import com.gred.easy_car.web.entity.JsonResult;

/**
 * @ClassName: CarOwnerService   
 * @Description: 移动端登陆以及注册入口服务接口   
 * @author WangJianbin  
 * @date 2015年5月8日 下午1:45:54   
 *
 */
public interface CarOwnerService extends BaseService<CarOwner, String> {

	/**
	 * 
	 * @Title: mobileTerminalRegester   
	 * @Description: 移动端车主注册
	 * @param @param carOwner
	 * @param @param car
	 * @param @return    
	 * @return JsonResult<Object>    返回类型   
	 * @throws
	 */
	
	JsonResult<Object>  mobileTerminalRegester(CarOwner carOwner,Car car);
	
	/**
	 * 
	 * @Title: mobileTerminalLogin   
	 * @Description: 移动端车主登陆 
	 * @param @param carOwner
	 * @param @return    
	 * @return JsonResult<Car>    返回类型   
	 * @throws
	 */
	JsonResult<Car>  mobileTerminalLogin(CarOwner carOwner);
	
	/**
	 * @return 
	 * 
	 * @Title: getSMSCode   
	 * @Description: 获取短信验证码
	 * @param @param mobileNumber 
	 * @throws
	 */
	 void getSMSCode(String mobileNumber);
	
}
