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
import net.sf.ehcache.Element;
import net.sf.ehcache.Status;

/**
 * @ClassName: EHCacheUtils   
 * @Description: EH缓存工具类   
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
        	log.log(LogLevel.ERROR, "【EH缓存模块】：添加新缓存失败，缓存名称为空！");  
        }else{  
            if(getCacheManager().getCache(cacheName.trim())!=null){  
                getCacheManager().removeCache(cacheName.trim());  
            }  
            getCacheManager().addCache(cacheName.trim());  
            log.log(LogLevel.INFO, "【EH缓存模块】：添加新缓存成功！缓存名称："+cacheName);;  ;  
        }  
    }  
    /**
     *  
     * @Title: getCacheByName   
     * @Description: 获取缓存   
     * @param @param cacheName
     * @param @return    
     * @return Cache    返回类型   
     * @throws
     */
    public static Cache getCacheByName(String cacheName){  
        Cache cache=null;  
        if(cacheName==null||cacheName.trim().equals("")){  
        	log.log(LogLevel.ERROR, "【EH缓存模块】：获取缓存失败，缓存名称为空！");   
        }else{  
            if(getCacheManager().getCache(cacheName.trim())!=null){  
                cache=getCacheManager().getCache(cacheName.trim());  
            }  
        }  
          
        return cache;  
    }  
    
  /**
   *   
   * @Title: putElementToCache   
   * @Description: (添加缓存元素)   
   * @param @param cacheName
   * @param @param elementKey
   * @param @param elementValue    
   * @return void    返回类型   
   * @throws
   */
    public static void putElementToCache(String cacheName,String elementKey,Object elementValue){  
        Cache cache=null;  
        if(cacheName==null||cacheName.trim().equals("")){  
        	log.log(LogLevel.ERROR, "【EH缓存模块】：缓存添加元素失败，缓存名称为空！");   
        }else if(elementKey==null||elementValue==null){  
        	log.log(LogLevel.ERROR,"【EH缓存模块】：添加缓存元素失败，elementKey or elementValue 为空！");  
        }else{  
            if(getCacheByName(cacheName.trim())!=null){//缓存存在  
                cache=getCacheByName(cacheName.trim());  
            }else{//缓存不存在  
                addCacheByName(cacheName.trim());  
                cache=getCacheByName(cacheName.trim());  
            }  
            //对cache对象添加Element  
            Element element=null;  
            if(cache.get(elementKey.trim())!=null){  
                cache.remove(elementKey.trim());  
            }  
            element=new Element(elementKey.trim(),elementValue);  
            cache.put(element);  
            log.log(LogLevel.INFO,"【EH缓存模块】：添加缓存元素:"+elementKey+"成功！");  
        }  
          
    }  
      
    /**
     * 
     * @Title: getElementValueFromCache   
     * @Description: (获取缓存元素)   
     * @param @param cacheName
     * @param @param elementKey
     * @param @return    
     * @return Object    返回类型   
     * @throws
     */
    public static Object getElementValueFromCache(String cacheName,String elementKey){  
        Object result=null;  
        Cache cache=null;  
        if(cacheName==null||cacheName.trim().equals("")){  
        	log.log(LogLevel.ERROR,"【EH缓存模块】：缓存获取元素失败，cacheName is null");  
        }else if(elementKey==null){  
        	log.log(LogLevel.ERROR,"【EH缓存模块】：获取缓存元素失败，elementKey  is null");  
        }else{  
            if(getCacheByName(cacheName.trim())!=null){//缓存存在  
                cache=getCacheByName(cacheName.trim());  
                  
                Element element=null;  
                if(cache.get(elementKey.trim())!=null){  
                    element=cache.get(elementKey.trim());  
                    if(element.getObjectValue()==null){  
                    	log.log(LogLevel.ERROR,"【EH缓存模块】：缓存中"+elementKey+" 的值为空.");  
                    }else{  
                        result=element.getObjectValue();  
                    }  
                }else{  
                	log.log(LogLevel.ERROR,"【EH缓存模块】：缓存中"+elementKey+" 的Element值为空.");  
                }  
            }else{//缓存不存在  
                System.out.println("【EH缓存模块】：获取缓存元素失败，缓存"+cacheName+" 为空.");  
            }  
        }  
          
        return result;  
    }  
    
    
}
