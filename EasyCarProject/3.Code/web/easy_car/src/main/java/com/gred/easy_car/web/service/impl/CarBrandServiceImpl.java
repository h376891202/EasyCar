/**
 * @Title: CarBrandServiceImpl.java   
 * @Package com.gred.easy_car.web.service.impl   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月13日 上午11:01:42   
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
import com.gred.easy_car.web.controller.mobile.CarBrandInfoController;
import com.gred.easy_car.web.entity.CarBrand;
import com.gred.easy_car.web.entity.JsonResult;
import com.gred.easy_car.web.mapper.CarBrandMapper;
import com.gred.easy_car.web.service.CarBrandService;

/**
 * @ClassName: CarBrandServiceImpl   
 * @Description: 车品牌业务实现类
 * @author WangJianbin  
 * @date 2015年5月13日 上午11:01:42   
 *
 */
@Service
public class CarBrandServiceImpl  extends BaseServiceImpl<CarBrand, String> implements CarBrandService{

	
	
	private static final Log4jUtils log = new Log4jUtils(CarBrandInfoController.class);
	
	@Autowired
	private CarBrandMapper carBrandMapper;
	/* 
	 * <p>Title: listCarBrandInfo</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.gred.easy_car.web.service.CarBrandService#listCarBrandInfo()   
	 */   
	@Override
	public JsonResult<CarBrand> listCarBrandInfo() {
		List<CarBrand>  carBrandList;
		JsonResult<CarBrand> result = new JsonResult<>();
		 try {
			 carBrandList = carBrandMapper.selectAllWithBrandType();
		} catch (Exception e) {
			//此异常代表违反数据库唯一约束
			result.setStatus(602);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "602");
			result.setStatusMessage(message);
			log.log(LogLevel.ERROR, "【车型数据获取模块】：操作数据库异常！", e);
			return result;
		}
		 
		 result.setStatus(601);
		 String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "601");
		 result.setStatusMessage(message);
		 result.setData(carBrandList);
		 return result;
	}

}
