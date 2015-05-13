package com.gred.easy_car.web.mapper;

import java.util.List;

import com.gred.easy_car.web.entity.Car;


public interface CarMapper extends BaseMapper<Car, String>{

	/**
	 * @Title: selectByOwnerId   
	 * @Description: 根据用户ID查询用户所拥有车辆
	 * @param @param uid
	 * @param @return    
	 * @return List<Car>    返回类型   
	 * @throws   
	 */
	List<Car> selectByOwnerId(String uid);


}