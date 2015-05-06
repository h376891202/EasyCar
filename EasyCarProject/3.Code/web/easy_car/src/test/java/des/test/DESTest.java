/**
 * @Title: DESTest.java   
 * @Package des.test   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月7日 下午5:04:15   
 * @version V2.0     
 */
package des.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.gred.easy_car.common.utils.DESUtils;

/**
 * @ClassName: DESTest   
 * @Description: DES对称加密测试类   
 * @author WangJianbin  
 * @date 2015年5月7日 下午5:04:15   
 *
 */
public class DESTest {

	@Test
	public void test() {
		
		try {
			//String str1 = DESUtils.encryptDES("这是一个加密测试", "20150507");
			//System.out.println(str1);
			String str = DESUtils.decryptDES("XMlN8rEODvf0y2xpu5/EmNb9YrEOFXWQzHnxGJr1Bf8=", "20150507");
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
