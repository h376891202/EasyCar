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

import com.gred.easy_car.web.entity.User;
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
		
		User user = new User();
		user.setUserId("xxx");
		user.setUserMobile("12154213ss");
		user.setUserPwd("xxxxxxxxx");
		user.setUserRegisterTime("xxxxx");
		userMapperImpl.insertSelective(user);
		
	}

}
