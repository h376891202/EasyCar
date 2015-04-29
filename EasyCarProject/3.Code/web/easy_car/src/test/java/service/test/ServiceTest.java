/**
 * @Title: ServiceTest.java   
 * @Package service.test   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月30日 下午2:14:58   
 * @version V2.0     
 */
package service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gred.easy_car.web.service.SystemErrorMessageService;

/**
 * @ClassName: ServiceTest   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author WangJianbin  
 * @date 2015年4月30日 下午2:14:58   
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml","classpath:spring-aop.xml","classpath:spring-database.xml" })
public class ServiceTest {

	@Autowired
	SystemErrorMessageService errorMessageService;
	
	@Test
	public void systemErrorMessageTest() {
		errorMessageService.listAll();
	}

}
