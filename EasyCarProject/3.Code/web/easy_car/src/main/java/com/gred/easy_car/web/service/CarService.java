/**
 * @Title: CarService.java   
 * @Package com.gred.easy_car.web.service   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月8日 下午1:57:07   
 * @version V2.0     
 */
package com.gred.easy_car.web.service;

import java.util.List;

import com.gred.easy_car.web.entity.Car;
import com.gred.easy_car.web.entity.JsonResult;

/**
 * @ClassName: CarService   
 * @Description: 车辆业务类接口
 * @author WangJianbin  
 * @date 2015年5月8日 下午1:57:07   
 *
 */
public interface CarService extends BaseService<Car, String>{

	/**
	 * @Title: listByOwnerMobile   
	 * @Description: 根据车主手机号筛选车辆 
	 * @param @return    
	 * @return List<Car>    返回类型   
	 * @throws   
	 */
	JsonResult<Car> listByOwnerId(String uid);

}
