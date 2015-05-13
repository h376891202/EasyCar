/**
 * @Title: GarageController.java   
 * @Package com.gred.easy_car.web.controller.mobile   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月14日 下午2:55:45   
 * @version V2.0     
 */
package com.gred.easy_car.web.controller.mobile;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gred.easy_car.common.constant.SystemMessageConstant;
import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.EHCacheUtils;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.common.utils.UUIDGenerator;
import com.gred.easy_car.web.entity.Car;
import com.gred.easy_car.web.entity.CarOwner;
import com.gred.easy_car.web.entity.JsonResult;
import com.gred.easy_car.web.service.CarOwnerService;
import com.gred.easy_car.web.service.CarService;

/**
 * @ClassName: GarageController   
 * @Description: 增删查改车辆入口
 * @author WangJianbin  
 * @date 2015年5月14日 下午2:55:45   
 *
 */
@RestController
@RequestMapping("car")
public class GarageController {

	private static final Log4jUtils log = new Log4jUtils(GarageController.class);
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarOwnerService carOwnerService;
	/**
	 * 
	 * @Title: listCars   
	 * @Description: 获取用户车辆列表 
	 * @param @param uid
	 * @param @return    
	 * @return JsonResult<Car>    返回类型   
	 * @throws
	 */
	@RequestMapping(value="/list" ,method=RequestMethod.POST)
	public JsonResult<Car>  listCars(@RequestParam(value="uid",required=false) String uid){
		
		JsonResult<Car>  jsonResult = new JsonResult<>();
		
		if(StringUtils.isEmpty(uid)){
			log.log(LogLevel.ERROR, "【移动端注册模块】：请求中不存在 uid 参数！");
			jsonResult.setStatus(108);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "108");
			jsonResult.setStatusMessage(message);
			return jsonResult;
		}
		
		jsonResult=carService.listByOwnerId(uid);
		
		return jsonResult;
		
	}
	
	/**
	 * 
	 * @Title: deleteCar   
	 * @Description: 删除车辆
	 * @param @param carid
	 * @param @return    
	 * @return JsonResult<Car>    返回类型   
	 * @throws
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JsonResult<Car> deleteCar(@RequestParam(value="carid",required=false) String carid){
		JsonResult<Car>  jsonResult = new JsonResult<>();
		
		if(StringUtils.isEmpty(carid)){
			log.log(LogLevel.ERROR, "【移动端注册模块】：请求中不存在 carid 参数！");
			jsonResult.setStatus(108);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "108");
			jsonResult.setStatusMessage(message);
			return jsonResult;
		}
		
		try {
			carService.remove(carid);
		} catch (Exception e) {
			log.log(LogLevel.ERROR, "【车库模块】：删除车辆信息异常！", e);
			jsonResult.setStatus(605);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "605");
			jsonResult.setStatusMessage(message);
			return jsonResult;
		}
		
		jsonResult.setStatus(606);
		String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "606");
		jsonResult.setStatusMessage(message);
		
		return jsonResult;
		
	}
	
	/**
	 * 
	 * @Title: modifyCar   
	 * @Description: 修改车辆信息 
	 * @param @param car
	 * @param @return    
	 * @return JsonResult<Car>    返回类型   
	 * @throws
	 */
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public JsonResult<Car> modifyCar(@Valid Car car,BindingResult result){
		JsonResult<Car>  jsonResult = new JsonResult<>();
		if(result.hasErrors()){
			 List<ObjectError> ls=result.getAllErrors();  
		     log.log(LogLevel.ERROR, "【移动端注册模块】：参数校验失败"+"error:"+ls.toString());
		     jsonResult.setStatus(101);
		     String  message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "101");
		     jsonResult.setStatusMessage(message);
		     return jsonResult;
		}
		
		try {
			carService.modify(car);
		} catch (Exception e) {
			
			log.log(LogLevel.ERROR, "【车库模块】：修改车辆信息异常！", e);
			jsonResult.setStatus(608);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "608");
			jsonResult.setStatusMessage(message);
			return jsonResult;
		}
		
		jsonResult.setStatus(607);
		String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "607");
		jsonResult.setStatusMessage(message);
		
		return jsonResult;
		
	}
	
	/**
	 * 
	 * @Title: bachAddCar   
	 * @Description: 添加车辆
	 * @param @param car
	 * @param @return    
	 * @return JsonResult<Car>    返回类型   
	 * @throws
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public JsonResult<Car> bachAddCar(@Valid Car car ,BindingResult result){
		
		JsonResult<Car>  jsonResult = new JsonResult<>();
		
		if(result.hasErrors()){
			 List<ObjectError> ls=result.getAllErrors();  
		     log.log(LogLevel.ERROR, "【移动端注册模块】：参数校验失败"+"error:"+ls.toString());
		     jsonResult.setStatus(101);
		     String  message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "101");
		     jsonResult.setStatusMessage(message);
		     return jsonResult;
		}
		
		List<Car> carList = new ArrayList<>();
		
		try {
			CarOwner owner = carOwnerService.get(car.getCarOwnerId());
			
			car.setCarId(UUIDGenerator.generateUUID());
			car.setCarOwnerMobile(owner.getUserMobile());
			
			carService.save(car);
			//TODO  车牌号码已经存在 
 		} catch (Exception e) {
			log.log(LogLevel.ERROR, "【车库模块】：保存车辆信息异常！", e);
			jsonResult.setStatus(610);
			String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "610");
			jsonResult.setStatusMessage(message);
			return jsonResult;
		}
		
		jsonResult.setStatus(609);
		String message = (String) EHCacheUtils.getElementValueFromCache(SystemMessageConstant.ERROR_MESSAGE_CACHE, "609");
		jsonResult.setStatusMessage(message);
		carList.add(car);
		jsonResult.setData(carList);
		
		return jsonResult;
		
	}
	
}
