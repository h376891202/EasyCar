/**
 * @Title: EHCacheTest.java   
 * @Package ehcache.test   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月28日 下午7:27:34   
 * @version V2.0     
 */
package ehcache.test;

import static org.junit.Assert.*;
import net.sf.ehcache.Cache;

import org.junit.Test;

import com.gred.easy_car.common.utils.EHCacheUtils;

/**
 * @ClassName: EHCacheTest   
 * @Description: 缓存测试   
 * @author WangJianbin  
 * @date 2015年4月28日 下午7:27:34   
 *
 */
public class EHCacheTest {

	@Test
	public void test() throws InterruptedException {
		EHCacheUtils.putElementToCache("SMSCodeCache", "test", "这是一个缓存测试");
		Cache cache = EHCacheUtils.getCacheByName("SMSCodeCache");
		
		Object obj =EHCacheUtils.getElementValueFromCache("SMSCodeCache", "test");
		System.out.println(obj);
		Thread.sleep(1000*80);
	//	Thread.sleep(1000*10);
		Object obj1 = EHCacheUtils.getElementValueFromCache("SMSCodeCache", "test");
		System.out.println(obj1);
		
		
	}

}
