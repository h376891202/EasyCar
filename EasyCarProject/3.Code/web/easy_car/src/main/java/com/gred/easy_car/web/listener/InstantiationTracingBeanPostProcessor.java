/**
 * @Title: InstantiationTracingBeanPostProcessor.java   
 * @Package com.gred.easy_car.web.listener   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月8日 下午6:14:09   
 * @version V2.0     
 */
package com.gred.easy_car.web.listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.Log4jUtils;

/**
 * @ClassName: InstantiationTracingBeanPostProcessor   
 * @Description: 打印出bean的加载过程  
 * @author WangJianbin  
 * @date 2015年5月8日 下午6:14:09   
 *
 */
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor{

	private static final Log4jUtils log = new Log4jUtils(InstantiationTracingBeanPostProcessor.class);
	
	/* 
	 * <p>Title: postProcessAfterInitialization</p>   
	 * <p>Description: </p>   
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws BeansException   
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)   
	 */   
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		log.log(LogLevel.INFO, "【Spring容器加载Bean】："+beanName);
		return bean;
	}

	/* 
	 * <p>Title: postProcessBeforeInitialization</p>   
	 * <p>Description: </p>   
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws BeansException   
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)   
	 */   
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		return bean;
	}

}
