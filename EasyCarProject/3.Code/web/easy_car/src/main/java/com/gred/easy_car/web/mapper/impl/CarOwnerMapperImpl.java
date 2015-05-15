/**
 * @Title: CarOwnerMapperImpl.java   
 * @Package com.gred.easy_car.web.mapper.impl   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月6日 下午7:29:43   
 * @version V2.0     
 */
package com.gred.easy_car.web.mapper.impl;

import org.springframework.stereotype.Repository;

import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.web.entity.CarOwner;
import com.gred.easy_car.web.mapper.CarOwnerMapper;

/**
 * @ClassName: CarOwnerMapperImpl   
 * @Description: 车主数据访问实现类   
 * @author WangJianbin  
 * @date 2015年5月6日 下午7:29:43   
 *
 */
@Repository
public class CarOwnerMapperImpl extends BaseMapperImpl<CarOwner, String> implements CarOwnerMapper{

	private static final	Log4jUtils log = new Log4jUtils(CarOwnerMapperImpl.class);
	
	private static final String SQLID_SELECT_MOBILE = "selectByMobile";
	/* 
	 * <p>Title: selectByMobile</p>   
	 * <p>Description: </p>   
	 * @param mobileNumber
	 * @return   
	 * @see com.gred.easy_car.web.mapper.CarOwnerMapper#selectByMobile(java.lang.String)   
	 */   
	@Override
	public CarOwner selectByMobile(String userMobile) {
	

	            return getSqlSession().selectOne(namespace + "." + SQLID_SELECT_MOBILE,userMobile);  
	       

	} 

}
