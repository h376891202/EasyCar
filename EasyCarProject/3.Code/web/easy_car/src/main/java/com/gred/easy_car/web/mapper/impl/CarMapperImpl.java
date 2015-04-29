/**
 * @Title: CarMapperImpl.java   
 * @Package com.gred.easy_car.web.mapper.impl   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月29日 下午2:30:53   
 * @version V2.0     
 */
package com.gred.easy_car.web.mapper.impl;

import org.springframework.stereotype.Repository;

import com.gred.easy_car.web.entity.CarEntity;
import com.gred.easy_car.web.mapper.CarMapper;

/**
 * @ClassName: CarMapperImpl   
 * @Description: 车辆数据访问实现类   
 * @author WangJianbin  
 * @date 2015年4月29日 下午2:30:53   
 *
 */
@Repository
public class CarMapperImpl extends BaseMapperImpl<CarEntity, Integer> implements CarMapper{

}
