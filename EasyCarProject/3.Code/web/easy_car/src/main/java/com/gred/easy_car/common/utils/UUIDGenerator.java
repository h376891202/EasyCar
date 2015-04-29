/**
 * @Title: UUIDGenerator.java   
 * @Package com.gred.easy_car.common.utils   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月25日 下午6:28:23   
 * @version V2.0     
 */
package com.gred.easy_car.common.utils;

import java.util.UUID;

/**
 * @ClassName: UUIDGenerator   
 * @Description: (uuid生成类)   
 * @author WangJianbin  
 * @date 2015年4月25日 下午6:28:23   
 *
 */
public class UUIDGenerator {
	
	private UUIDGenerator(){
		
	}
	
	/**
	 * 
	 * @Title: generateUUID   
	 * @Description: (生成不带 - 的UUID)   
	 * @param @return    设定文件   
	 * @return String    返回类型   
	 * @throws   
	 * @return
	 */
	public static String generateUUID(){
		
		return UUID.randomUUID().toString().replaceAll("-", "");  
	}

}
