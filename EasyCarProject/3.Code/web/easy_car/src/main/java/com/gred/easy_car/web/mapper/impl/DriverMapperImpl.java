/**
 * @Title: DriverMapperImpl.java   
 * @Package com.gred.easy_car.web.mapper.impl   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月6日 下午7:41:34   
 * @version V2.0     
 */
package com.gred.easy_car.web.mapper.impl;

import org.springframework.stereotype.Repository;

import com.gred.easy_car.web.entity.Driver;
import com.gred.easy_car.web.mapper.DriverMapper;

/**
 * @ClassName: DriverMapperImpl   
 * @Description: 司机数据访问实现类   
 * @author WangJianbin  
 * @date 2015年5月6日 下午7:41:35   
 *
 */
@Repository
public class DriverMapperImpl extends BaseMapperImpl<Driver, String> implements DriverMapper{

}
