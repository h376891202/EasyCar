package com.gred.easy_car.web.mapper;

import java.util.List;

import com.gred.easy_car.web.entity.CarBrand;


public interface CarBrandMapper extends BaseMapper<CarBrand, String>{
	
	/**
	 * 
	 * @Title: selectAllWithBrandType   
	 * @Description: 获取车品牌列表（包含子车型）
	 * @param @return    
	 * @return List<CarBrand>    返回类型   
	 * @throws
	 */
	List<CarBrand> selectAllWithBrandType();
}