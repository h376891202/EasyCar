/**
 * @Title: RandomNumberUtils.java   
 * @Package com.gred.easy_car.common.utils   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月27日 下午8:31:03   
 * @version V2.0     
 */
package com.gred.easy_car.common.utils;

import java.util.Random;

/**
 * @ClassName: RandomNumberUtils   
 * @Description: (随机数产生工具类)   
 * @author WangJianbin  
 * @date 2015年4月27日 下午8:31:03   
 *
 */
public class RandomNumberUtils {
	
	
	private static Random  random= new Random();
	
	private RandomNumberUtils(){
		
	}
	
	
	public static String generateRandomNumber(int length){
		
		String sRand="";   
		for (int i=0;i<length;i++){   
		String rand=String.valueOf(random.nextInt(10));   
		sRand+=rand;   
		
		}
		return sRand;
	}

}
