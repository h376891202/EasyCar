/**
 * @Title: DaoTest.java   
 * @Package dao.test   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月29日 下午3:07:38   
 * @version V2.0     
 */
package dao.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gred.easy_car.web.entity.Car;
import com.gred.easy_car.web.entity.CarOwner;
import com.gred.easy_car.web.entity.SystemErrorMessage;
import com.gred.easy_car.web.mapper.CarMapper;
import com.gred.easy_car.web.mapper.CarOwnerMapper;
import com.gred.easy_car.web.mapper.SystemErrorMessageMapper;


/**
 * @ClassName: DaoTest   
 * @Description: 数据访问层测试类   
 * @author WangJianbin  
 * @date 2015年4月29日 下午3:07:38   
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true) 
//@Transactional 
@ContextConfiguration(locations = { "classpath:applicationContext.xml","classpath:spring-aop.xml","classpath:spring-database.xml" })
public class DaoTest {

	@Autowired
	private CarOwnerMapper userMapperImpl;
	@Autowired
	private CarMapper carMapper;
	@Autowired
	private SystemErrorMessageMapper errorMessageMapper;
	
	
	@Test
	public void carOwnertest() {
		
		CarOwner carOwner = new CarOwner();
		carOwner.setUserId("vvvvv");
		carOwner.setUserMobile("12154213ss");
		carOwner.setUserPwd("xxxxxxxxx");
		carOwner.setUserRegisterTime("xxxxx");
		userMapperImpl.insertSelective(carOwner);
		//CarOwner carowner=userMapperImpl.selectByPrimaryKey("xxxcccccccc");org.springframework.dao.DuplicateKeyException
		//System.out.println(carowner.getUserId());
		
		
	}
	
	@Test
	public void carTest(){
		Car car = new Car();
		car.setCarId("xxxx");
		car.setCarBrand("东风日产");
		car.setCarBrandType("307");
		car.setCarOwnerId("xxxcccccccc");
		car.setCarPlateNumber("50789");
	
		//Car cara = carMapper.selectByPrimaryKey("xxxx");
		
		
	}
	
	@Test
	public void systemErrorTest(){
		List<SystemErrorMessage> list = errorMessageMapper.selectAll();
	}

}
