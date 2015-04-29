/**
 * @Title: UserMapperImpl.java   
 * @Package com.gred.easy_car.web.mapper.impl   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月29日 下午2:20:11   
 * @version V2.0     
 */
package com.gred.easy_car.web.mapper.impl;

import org.springframework.stereotype.Repository;

import com.gred.easy_car.web.entity.User;
import com.gred.easy_car.web.mapper.UserMapper;

/**
 * @ClassName: UserMapperImpl   
 * @Description: User实体数据访问接口实现类
 * @author WangJianbin  
 * @date 2015年4月29日 下午2:20:11   
 *
 */
@Repository
public class UserMapperImpl extends BaseMapperImpl<User, Integer> implements UserMapper{



	
}
