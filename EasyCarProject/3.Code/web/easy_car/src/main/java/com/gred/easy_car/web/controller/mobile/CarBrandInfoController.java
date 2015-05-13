/**
 * @Title: CarBrandInfoController.java   
 * @Package com.gred.easy_car.web.controller.mobile   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月13日 上午10:47:25   
 * @version V2.0     
 */
package com.gred.easy_car.web.controller.mobile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gred.easy_car.web.entity.CarBrand;
import com.gred.easy_car.web.entity.JsonResult;

/**
 * @ClassName: CarBrandInfoController   
 * @Description: 移动端获取车品牌信息
 * @author WangJianbin  
 * @date 2015年5月13日 上午10:47:25   
 *
 */
@RestController
@RequestMapping(value="carBrand")
public class CarBrandInfoController {

	
	
	
	@RequestMapping(value="/carBrandInfo")
	public JsonResult<CarBrand> getCarBrandInfo(){
		JsonResult<CarBrand> jsonResult = new JsonResult<>();
		
		
		
		
		return null;
		
	}
	
}
