/**
 * @Title: CarBrandInfoController.java   
 * @Package com.gred.easy_car.web.controller.mobile   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月13日 上午10:47:25   
 * @version V2.0     
 */
package com.gred.easy_car.web.controller.mobile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.web.entity.CarBrand;
import com.gred.easy_car.web.entity.JsonResult;
import com.gred.easy_car.web.service.CarBrandService;

/**
 * @ClassName: CarBrandInfoController   
 * @Description: 移动端获取车品牌信息
 * @author WangJianbin  
 * @date 2015年5月13日 上午10:47:25   
 *
 */
@RestController
@RequestMapping(value="carBrand")
public class CarBrandInfoController {

	private static final Log4jUtils log = new Log4jUtils(CarBrandInfoController.class);
	
	@Autowired
	private CarBrandService carBrandService;
	
	
	
	@RequestMapping(value="/carBrandInfo" ,method=RequestMethod.GET)
	public JsonResult<CarBrand> getCarBrandInfo(){
		JsonResult<CarBrand> jsonResult = new JsonResult<>();
		
		jsonResult = carBrandService.listCarBrandInfo();
		
		
		return jsonResult;
		
	}
	
	
	@RequestMapping(value="/icon/{fileName}" )
	public void download(@PathVariable("fileName") String fileName,HttpServletRequest request, HttpServletResponse response) {
	
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fileName = new String (fileName.getBytes("ISO-8859-1"),"utf-8");
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");

			String ctxPath = request.getSession().getServletContext().getRealPath("/")+ "image"+File.separator+"carBrand"+File.separator;
			String downLoadPath = ctxPath + fileName;

			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					log.log(LogLevel.ERROR, "【汽车标志下载模块】：缓冲流关闭异常！", e);
				}
			if (bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					log.log(LogLevel.ERROR, "【汽车标志下载模块】：缓冲流关闭异常！", e);
				}
		}

	}
	
}
