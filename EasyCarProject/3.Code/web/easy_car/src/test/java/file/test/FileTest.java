/**
 * @Title: FileTest.java   
 * @Package file.test   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月13日 下午4:53:08   
 * @version V2.0     
 */
package file.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * @ClassName: FileTest   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author WangJianbin  
 * @date 2015年5月13日 下午4:53:08   
 *
 */
public class FileTest {

	@Test
	public void fileTest() throws IOException{
		File file =  new File("src/main/webapp/image/carBrand");
		if(file.isDirectory()){
			File[] fileList = 	file.listFiles();
			for(File image : fileList){
				
				
			}
		}
	}

}
