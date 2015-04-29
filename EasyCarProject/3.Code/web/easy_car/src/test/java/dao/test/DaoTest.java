/**
 * @Title: DaoTest.java   
 * @Package dao.test   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月29日 下午3:07:38   
 * @version V2.0     
 */
package dao.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gred.easy_car.web.entity.UserEntity;
import com.gred.easy_car.web.mapper.UserMapper;


/**
 * @ClassName: DaoTest   
 * @Description: 数据访问层测试类   
 * @author WangJianbin  
 * @date 2015年4月29日 下午3:07:38   
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml","classpath:spring-aop.xml","classpath:spring-database.xml" })
public class DaoTest {

	@Autowired
	private UserMapper userMapperImpl;
	
	@Test
	public void test() {
		
		UserEntity user = new UserEntity();
		user.setUserId("xxxxx");
		user.setUserMobile("12154213");
		user.setUserPwd("xxxxxxx");
		user.setUserRegisterTime("xxxxxxx");
		userMapperImpl.insertSelective(user);
		
	}

}
