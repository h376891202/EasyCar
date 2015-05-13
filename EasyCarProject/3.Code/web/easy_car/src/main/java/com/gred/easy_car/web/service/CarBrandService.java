/**
 * @Title: CarBrandService.java   
 * @Package com.gred.easy_car.web.service   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月13日 上午11:01:05   
 * @version V2.0     
 */
package com.gred.easy_car.web.service;

import com.gred.easy_car.web.entity.CarBrand;
import com.gred.easy_car.web.entity.JsonResult;

/**
 * @ClassName: CarBrandService   
 * @Description: 车品牌业务接口 
 * @author WangJianbin  
 * @date 2015年5月13日 上午11:01:05   
 *
 */
public interface CarBrandService extends BaseService<CarBrand, String>{

	/**
	 * @Title: listCarBrandInfo   
	 * @Description: 获取车品牌以及其下属车型业务实现类  
	 * @param @return    
	 * @return JsonResult<CarBrand>    返回类型   
	 * @throws   
	 */
	JsonResult<CarBrand> listCarBrandInfo();

}
