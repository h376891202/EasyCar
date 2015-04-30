/**
 * @Title: SystemErrorMessageInitListener.java   
 * @Package com.gred.easy_car.web.listener   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月30日 上午11:34:36   
 * @version V2.0     
 */
package com.gred.easy_car.web.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.gred.easy_car.common.utils.EHCacheUtils;
import com.gred.easy_car.web.entity.SystemErrorMessage;
import com.gred.easy_car.web.service.SystemErrorMessageService;

/**
 * @ClassName: SystemErrorMessageInitListener   
 * @Description: 监听应用启动，完成系统错误码初始化   
 * @author WangJianbin  
 * @date 2015年4月30日 上午11:34:36   
 *
 */
public class SystemErrorMessageInitListener implements ServletContextListener{

	/**系统错误信息缓存，key=错误码，value=错误信息*/
	private final String ERROR_MESSAGE_CACHE = "ErrorMessageCache";
	
	@Autowired
	private SystemErrorMessageService systemErrorMessageService;
	
	/* 
	 * <p>Title: contextInitialized</p>   
	 * <p>Description: </p>   
	 * @param arg0   
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)   
	 */   
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		List<SystemErrorMessage> systemErrorMessage =  systemErrorMessageService.listAll();
		for(SystemErrorMessage errorMessage : systemErrorMessage){
			//存入EH缓存
			EHCacheUtils.putElementToCache(ERROR_MESSAGE_CACHE, errorMessage.getErrorCode(), errorMessage.getErrorMessage());
		}
		
	}
	
	/* 
	 * <p>Title: contextDestroyed</p>   
	 * <p>Description: </p>   
	 * @param arg0   
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)   
	 */   
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	

}
