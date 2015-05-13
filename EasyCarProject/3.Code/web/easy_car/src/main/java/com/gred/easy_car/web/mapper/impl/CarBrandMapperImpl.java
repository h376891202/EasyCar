/**
 * @Title: CarBrandMapperImpl.java   
 * @Package com.gred.easy_car.web.mapper.impl   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月6日 下午7:23:46   
 * @version V2.0     
 */
package com.gred.easy_car.web.mapper.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.web.entity.CarBrand;
import com.gred.easy_car.web.mapper.CarBrandMapper;

/**
 * @ClassName: CarBrandMapperImpl   
 * @Description: 车品牌数据访问实现类   
 * @author WangJianbin  
 * @date 2015年5月6日 下午7:23:46   
 *
 */
@Repository
public class CarBrandMapperImpl extends BaseMapperImpl<CarBrand, String> implements CarBrandMapper{

	
	private static final	Log4jUtils log = new Log4jUtils(CarBrandMapperImpl.class);
	
	private static final String SQLID_SELECT_ALL_WITH_BRAND_TYPE = "selectAllWithBrandType";
	/* 
	 * <p>Title: selectAllWithBrandType</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.gred.easy_car.web.mapper.CarBrandMapper#selectAllWithBrandType()   
	 */   
	@Override
	public List<CarBrand> selectAllWithBrandType() {
		
           return getSqlSession().selectList(namespace+"."+SQLID_SELECT_ALL_WITH_BRAND_TYPE);  
      
	}

}
