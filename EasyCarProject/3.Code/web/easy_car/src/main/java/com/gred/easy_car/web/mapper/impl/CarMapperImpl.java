/**
 * @Title: CarMapperImpl.java   
 * @Package com.gred.easy_car.web.mapper.impl   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月6日 下午7:28:44   
 * @version V2.0     
 */
package com.gred.easy_car.web.mapper.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.web.entity.Car;
import com.gred.easy_car.web.mapper.CarMapper;

/**
 * @ClassName: CarMapperImpl   
 * @Description: 车辆数据访问实现类   
 * @author WangJianbin  
 * @date 2015年5月6日 下午7:28:44   
 *
 */
@Repository
public class CarMapperImpl extends BaseMapperImpl<Car, String> implements CarMapper{

	
   private static final	Log4jUtils log = new Log4jUtils(CarMapperImpl.class);
	
	private static final String SQLID_SELECT_OWNER_ID = "selectByOwnerId";
	/* 
	 * <p>Title: selectByOwnerId</p>   
	 * <p>Description: </p>   
	 * @param uid
	 * @return   
	 * @see com.gred.easy_car.web.mapper.CarMapper#selectByOwnerId(java.lang.String)   
	 */   
	@Override
	public List<Car> selectByOwnerId(String uid) {
		
	  return getSqlSession().selectList(namespace + "." + SQLID_SELECT_OWNER_ID,uid);  
	
	}

}
