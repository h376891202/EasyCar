/**
 * @Title: Log4jUtils.java   
 * @Package com.gred.easy_car.common.utils   
 * @Description:    
 * @author WangJianbin     
 * @date 2015年4月25日 下午4:50:11   
 * @version V2.0     
 */
package com.gred.easy_car.common.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.gred.easy_car.common.enums.LogLevel;

/**
 * @ClassName: Log4jUtils   
 * @Description: (log工具类)   
 * @author WangJianbin  
 * @date 2015年4月25日 下午4:50:11   
 *
 */
public class Log4jUtils {

	/** 
     * Log4j的一个实例 
     */  
    private  Logger logger;  
  
    /** 
     * 默认的构造方法 
     */  
    public Log4jUtils() {  
        setPropertyConfigurator();  
        logger = Logger.getLogger(Log4jUtils.class);  
  
    }  
  
    /** 
     * 自定义所要输出日志的类的构造方法 
     * @param clazz 
     */  
    public Log4jUtils(Class<?> clazz) {  
        setPropertyConfigurator();  
        logger = Logger.getLogger(clazz);  
    }  
    
    /** 
     * @desc : 配置Log4j所需要的属性 
     */  
    private void setPropertyConfigurator() {  
        String path = this.getClass().getClassLoader().getResource("log4j.xml").getPath();  
        PropertyConfigurator.configure(path);  
    }
    
    
	
    public  void log(LogLevel level, String message) {  
    	  
        switch (level) {  
            case OFF:  
                logOFF(message);  
                break;  
            case FATAL:  
                logFATAL(message);  
                break;  
            case ERROR:  
                logERROR(message);  
                break;  
            case WARN:  
                logWARN(message);  
                break;  
            case INFO:  
                logINFO(message);  
                break;  
            case DEBUG:  
                logDEBUG(message);  
                break;  
            case TRACE:  
                logTRACE(message);  
                break;  
            default:  
                logALL(message);  
                break;  
        }  
    }  
  
    private  void logOFF(String message) {  
    }  
  
    private   void logFATAL(String message) {  
        logger.fatal(message);  
    }  
  
    private  void logERROR(String message) {  
        logger.error(message);  
    }  
  
    private   void logWARN(String message) {  
        logger.warn(message);  
    }  
  
    private  void logINFO(String message) {  
        logger.info(message);  
    }  
  
    private  void logDEBUG(String message) {  
        logger.debug(message);  
    }  
  
    private  void logTRACE(String message) {  
        logger.trace(message);  
    }  
  
    private  void logALL(String message) {  
    }  
  
    public  void log(LogLevel level, String message, Throwable t) {  
  
        switch (level) {  
            case OFF:  
                logOFF(message, t);  
                break;  
            case FATAL:  
                logFATAL(message, t);  
                break;  
            case ERROR:  
                logERROR(message, t);  
                break;  
            case WARN:  
                logWARN(message, t);  
                break;  
            case INFO:  
                logINFO(message, t);  
                break;  
            case DEBUG:  
                logDEBUG(message, t);  
                break;  
            case TRACE:  
                logTRACE(message, t);  
                break;  
            default:  
                logALL(message, t);  
                break;  
        }  
    }  
  
    private  void logOFF(String message, Throwable t) {  
    }  
  
    private  void logFATAL(String message, Throwable t) {  
        logger.fatal(message, t);  
    }  
  
    private  void logERROR(String message, Throwable t) {  
        logger.error(message, t);  
    }  
  
    private  void logWARN(String message, Throwable t) {  
        logger.warn(message, t);  
    }  
  
    private  void logINFO(String message, Throwable t) {  
        logger.info(message, t);  
    }  
  
    private  void logDEBUG(String message, Throwable t) {  
        logger.debug(message, t);  
    }  
  
    private  void logTRACE(String message, Throwable t) {  
        logger.trace(message, t);  
    }  
  
    private  void logALL(String message, Throwable t) {  
    }  
}
