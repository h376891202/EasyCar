/**
 * @Title: CarServiceImpl.java   
 * @Package com.gred.easy_car.web.service.impl   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月8日 下午1:58:25   
 * @version V2.0     
 */
package com.gred.easy_car.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gred.easy_car.common.constant.SystemMessageConstant;
import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.EHCacheUtils;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.web.entity.Car;
import com.gred.easy_car.web.entity.JsonResult;
import com.gred.easy_car.web.mapper.CarMapper;
import com.gred.easy_car.web.mapper.impl.CarMapperImpl;
import com.gred.easy_car.web.service.CarService;

/**
 * @ClassName: CarServiceImpl   
 * @Description: 车辆业务实现类   
 * @author WangJianbin  
 * @date 2015年5月8日 下午1:58:25   
 *
 */
@Service
public class CarServiceImpl extends BaseServiceImpl<Car, String> implements CarService{

	 private static final	Log4jUtils log = new Log4jUtils(CarServiceImpl.class);
	 
	@Autowired
	private CarMapper carMapper;
	/* 
	 * <p>Title: listByOwnerMobile</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.gred.easy_car.web.service.CarService#listByOwnerMobile()   
	 */   
	@Override
	public JsonResult<Car> listByOwnerId(String uid) {
		
		JsonResult<Car>  jsonResult = new JsonResult<>();
		List<Car>  carList ;
		try {
			carList=carMapper.selectByOwnerId(uid);
		} catch (Exception e) {
			log.log(LogLevel.ERROR, "【车库模块】：获取车辆信息异常！", e);
			jsonResult.setStatus(603);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "603");
			jsonResult.setStatusMessage(message);
			return jsonResult;
			
		}
		jsonResult.setStatus(604);
		String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "604");
		jsonResult.setStatusMessage(message);
		jsonResult.setData(carList);
		
		return jsonResult;
		
	}

}
