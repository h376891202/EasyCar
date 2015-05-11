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
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.EHCacheUtils;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.web.controller.mobile.MobileTerminalAccessController;
import com.gred.easy_car.web.entity.SystemErrorMessage;
import com.gred.easy_car.web.service.SystemErrorMessageService;

/**
 * @ClassName: SystemErrorMessageInitListener   
 * @Description: 监听spring容器启动完成事件，完成系统错误码初始化   
 * @author WangJianbin  
 * @date 2015年4月30日 上午11:34:36   
 *
 */
@Component
public class SystemErrorMessageInitListener implements ApplicationListener<ContextRefreshedEvent>{

	/**系统错误信息缓存，key=错误码，value=错误信息*/
	private final String ERROR_MESSAGE_CACHE = "ErrorMessageCache";
	
	private static final Log4jUtils log = new Log4jUtils(SystemErrorMessageInitListener.class);
	
	@Autowired
	private SystemErrorMessageService systemErrorMessageService ;


	/* 
	 * <p>Title: onApplicationEvent</p>   
	 * <p>Description: </p>   
	 * @param arg0   
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)   
	 */   
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		log.log(LogLevel.INFO, "【系统错误信息初始化监听器】：开始加载......");
		
		List<SystemErrorMessage> systemErrorMessage =  systemErrorMessageService.listAll();
		for(SystemErrorMessage errorMessage : systemErrorMessage){
			//存入EH缓存
			EHCacheUtils.putElementToCache(ERROR_MESSAGE_CACHE, errorMessage.getErrorCode(), errorMessage.getErrorMessage());
		}
		
		log.log(LogLevel.INFO, "【系统错误信息初始化监听器】：加载完毕！");
		
	}
	
	
	
	
	

}
