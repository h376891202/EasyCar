package com.gred.easy_car.web.mapper;

import com.gred.easy_car.web.entity.CarOwner;


public interface CarOwnerMapper extends BaseMapper<CarOwner, String>{
	
	
	/**
	 * 
	 * @Title: selectByMobile   
	 * @Description:根据移动电话选出用户
	 * @param @param userMobile
	 * @param @return    
	 * @return CarOwner    返回类型   
	 * @throws
	 */
    CarOwner selectByMobile(String userMobile);
}