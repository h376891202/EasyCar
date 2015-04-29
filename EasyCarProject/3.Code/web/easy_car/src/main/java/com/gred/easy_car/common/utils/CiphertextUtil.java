/**
 * @Title: CiphertextUtil.java   
 * @Package com.gred.easy_car.common.utils   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月29日 上午11:31:49   
 * @version V2.0     
 */
package com.gred.easy_car.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @ClassName: CiphertextUtil
 * @Description: 信息加密类，支持MD5,SHA256,SHA384,SHA512算法
 * @author WangJianbin
 * @date 2015年4月29日 上午11:31:49
 * 
 */
public class CiphertextUtil {
	
	
	public static final String MD5 = "MD5";
	
	public static final String SHA_256 = "SHA256";
	
	public static final String SHA_384 = "SHA384";
	
	public static final String SHA_512 = "SHA512";

	/**
	 * 加密字符串
	 * 
	 * @param sourceStr
	 *            需要加密目标字符串
	 * @param algorithmsName
	 *            算法名称(MD5,SHA256,SHA384,SHA512)
	 * @return
	 */
	public static String passAlgorithmsCiphering(String sourceStr,String algorithmsName) {
		
		String afterCiphertext = "";
		switch (algorithmsName) {

		case "MD5":
			afterCiphertext = DigestUtils.md5Hex(sourceStr);
			break;

		case "SHA256":
			afterCiphertext = DigestUtils.sha256Hex(sourceStr);
			break;
		case "SHA384":
			afterCiphertext = DigestUtils.sha384Hex(sourceStr);
			break;
		case "SHA512":
			afterCiphertext = DigestUtils.sha512Hex(sourceStr);
			break;
		}
		return afterCiphertext;
	}
	
	/**
	 * 
	 * @Title: verifyPassword   
	 * @Description: 校验密码是否正确（摘要后是否和存储的密文相同） 
	 * @param @param password
	 * @param @param algorithmsName
	 * @param @param afterCiphertext
	 * @param @return    
	 * @return boolean    返回类型   
	 * @throws
	 */
	public static boolean verifyPassword(String password,String algorithmsName,String afterCiphertext){
		
		return passAlgorithmsCiphering(password, algorithmsName).equalsIgnoreCase(afterCiphertext);
		
	}
	
}
