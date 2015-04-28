/**
 * @Title: EHCacheUtils.java   
 * @Package com.gred.easy_car.common.utils   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月28日 下午3:56:26   
 * @version V2.0     
 */
package com.gred.easy_car.common.utils;

import com.gred.easy_car.common.enums.LogLevel;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

/**
 * @ClassName: EHCacheUtils   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author WangJianbin  
 * @date 2015年4月28日 下午3:56:26   
 *
 */
public class EHCacheUtils {
	
	public static CacheManager cacheManager = null;  
	 
	private static final Log4jUtils log = new Log4jUtils(EHCacheUtils.class);
    
    /**
     * 
     * @Title: getCacheManagerInstance   
     * @Description: (实例化缓存管理对象)   
     * @param @return    
     * @return CacheManager    返回类型   
     * @throws
     */
    public static CacheManager getCacheManagerInstance(){  
        if (cacheManager == null) {  
           
            cacheManager = new CacheManager();  
        }  
        return cacheManager;  
        
    }  
    public static CacheManager getCacheManager() {  
        return getCacheManagerInstance();//单例缓存管理  
    }  
      
    public static void setCacheManager(CacheManager cacheManager) {  
    	EHCacheUtils.cacheManager = cacheManager;  
    }  
    
  /**
   * 
   * @Title: addCacheByName   
   * @Description: (添加新缓存)   
   * @param @param cacheName    
   * @return void    返回类型   
   * @throws
   */
  
    public static void addCacheByName(String cacheName){  
        if(cacheName==null||cacheName.trim().equals("")){  
        	log.log(LogLevel.ERROR, "添加新缓存失败，缓存名称为空！");  
        }else{  
            if(getCacheManager().getCache(cacheName.trim())!=null){  
                getCacheManager().removeCache(cacheName.trim());  
            }  
            getCacheManager().addCache(cacheName.trim());  
            log.log(LogLevel.INFO, "添加新缓存成功！缓存名称："+cacheName);;  ;  
        }  
    }  
    /**
     *  
     * @Title: getCacheByName   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param @param cacheName
     * @param @return    
     * @return Cache    返回类型   
     * @throws
     */
    public static Cache getCacheByName(String cacheName){  
        Cache cache=null;  
        if(cacheName==null||cacheName.trim().equals("")){  
        	log.log(LogLevel.ERROR, "获取缓存失败，缓存名称为空！");   
        }else{  
            if(getCacheManager().getCache(cacheName.trim())!=null){  
                cache=getCacheManager().getCache(cacheName.trim());  
            }  
        }  
          
        return cache;  
    }  
    

}
