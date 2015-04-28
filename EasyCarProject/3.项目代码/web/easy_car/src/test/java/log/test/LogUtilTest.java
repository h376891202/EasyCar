/**
 * @Title: LogUtilTest.java   
 * @Package log.test   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月25日 下午5:07:59   
 * @version V2.0     
 */
package log.test;


import org.junit.Test;

import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.Log4jUtils;

/**
 * @ClassName: LogUtilTest   
 * @Description: (logUtil测试类)   
 * @author WangJianbin  
 * @date 2015年4月25日 下午5:07:59   
 *
 */
public class LogUtilTest {

	@Test
	public void test() {
		Log4jUtils log = new Log4jUtils(LogUtilTest.class);
		log.log(LogLevel.INFO, "log测试");
		log.log(LogLevel.ERROR, "log测数据", new Throwable("异常了"));
	}

}
