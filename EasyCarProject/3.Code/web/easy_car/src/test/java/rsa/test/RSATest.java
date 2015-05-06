/**
 * @Title: RSATest.java   
 * @Package rsa.test   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月8日 上午10:17:59   
 * @version V2.0     
 */
package rsa.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gred.easy_car.common.utils.RSAEncryptor;

/**
 * @ClassName: RSATest   
 * @Description: RSA解密测试  
 * @author WangJianbin  
 * @date 2015年5月8日 上午10:17:59   
 *
 */
public class RSATest {

	@Test
	public void test() throws Exception {
		RSAEncryptor rsaEncryptor = new RSAEncryptor();
		String base64String = "OtIK+CdFavhLngkdjShNKl0em3BsF+jGBYFCsqQELQFTwCSep2UHr8R7UlxT zwCR1XK/mkGjk+fY9Tsn62ZHmYUSp/Ow1ibYKCzF+u7qiQ3DHwewmBVBnzCV 44pmuEPZRLkyvNKUPN/ustrbWHa4lk96DctoYQi2MkYgk0CgZ+o=";
		String result = rsaEncryptor.decryptWithBase64(base64String);
		System.out.println(result);
	}

}
