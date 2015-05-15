/**
 * @Title: DaoTest.java   
 * @Package dao.test   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月29日 下午3:07:38   
 * @version V2.0     
 */
package dao.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gred.easy_car.web.entity.Car;
import com.gred.easy_car.web.entity.CarBrand;
import com.gred.easy_car.web.entity.SystemErrorMessage;
import com.gred.easy_car.web.mapper.CarBrandMapper;
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
	@Autowired

	private CarBrandMapper brandMapper;
	@Autowired
	

	
	
	@Test
	public void carOwnertest() {
		
//		CarOwner carOwner = new CarOwner();
//		carOwner.setUserId("vvvvv");
//		carOwner.setUserMobile("12154213ss");
//		carOwner.setUserPwd("xxxxxxxxx");
//		carOwner.setUserRegisterTime("xxxxx");
//		userMapperImpl.insertSelective(carOwner);
		//CarOwner carowner=userMapperImpl.selectByPrimaryKey("xxxcccccccc");org.springframework.dao.DuplicateKeyException
		//System.out.println(carowner.getUserId());
		userMapperImpl.selectByMobile("18808052574");
		
		
		
	}
	
	@Test
	public void carTest(){
		Car car = new Car();
		car.setCarId("xxxx");
		car.setCarBrand("东风日产");
		car.setCarBrandType("307");
		car.setCarOwnerId("xxxcccccccc");
		car.setCarOwnerMobile("xxxxxxxxx");
		car.setCarPlateNumber("50789");
		
		Car car2 = new Car();
		car2.setCarId("ccccc");
		car2.setCarBrand("英菲尼迪");
		car2.setCarBrandType("307");
		car2.setCarOwnerId("xxxcccccccc");
		car2.setCarOwnerMobile("vvvvvvv");
		car2.setCarPlateNumber("XXXXXXX");
		List<Car> list = new ArrayList<>();
		list.add(car);
		list.add(car2);
		
		carMapper.insertBatch(list);
	
		//Car cara = carMapper.selectByPrimaryKey("xxxx");
		
		
	}
	
	@Test
	public void systemErrorTest(){
		List<SystemErrorMessage> list = errorMessageMapper.selectAll();
	}
	
	@Test
	public void carBrandIconImport(){
		byte[] bbb =  new byte[1024*50];
		File  folder = new File("C:\\Users\\Administrator\\Desktop\\汽车LOGO 100X100\\汽车LOGO 100X100");
		CarBrand carBrand = new CarBrand();
		if(folder.isDirectory()){
			File[] imageList = folder.listFiles();
			for(File image  : imageList){
				InputStream in;
				try {
					in = new FileInputStream(image);
					in.read(bbb);
					carBrand.setCarBrandIcon(bbb);
					String imageName=image.getName();//DS.PNG
					String ImageNameWithOutSuffix = imageName.substring(0,imageName.lastIndexOf('.'));
					carBrand.setCarBrandName(ImageNameWithOutSuffix);
					brandMapper.updateByPrimaryKeySelective(carBrand);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

	
	@Test
	public void carBrandIconExport(){
		
		List<CarBrand>  list =brandMapper.selectAll();
		
		for(CarBrand brand : list){
			OutputStream out;
			try {
				
				File file =  new File("src/main/webapp/image/carBrand/"+brand.getCarBrandName()+".png");
				if(!file.exists()){
					file.createNewFile();
				}
				out = new FileOutputStream(file);
				out.write(brand.getCarBrandIcon());
				brandMapper.updateByPrimaryKeySelective(brand);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	@Test
	public void carBrandIconRename(){
		List<CarBrand>  list =brandMapper.selectAll();
		for(int i =0;i<list.size();i++){
			CarBrand carBrand  = list.get(i);
			File file =  new File("src/main/webapp/image/carBrand/"+carBrand.getCarBrandName()+".png");
			file.renameTo(new File(i+1+".png"));
			carBrand.setCarBrandIconPicName(i+1+".png");
			brandMapper.updateByPrimaryKeySelective(carBrand);
		}
	}
	
	@Test
	public void carBrandTest(){
		
		@SuppressWarnings("unused")
		List<CarBrand> list = brandMapper.selectAllWithBrandType();
	}
	
	

}
