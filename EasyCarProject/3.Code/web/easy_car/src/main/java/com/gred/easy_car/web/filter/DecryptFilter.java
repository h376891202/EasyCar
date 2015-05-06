/**
 * @Title: DecryptFilter.java   
 * @Package com.gred.easy_car.web.filter   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年5月7日 下午6:42:30   
 * @version V2.0     
 */
package com.gred.easy_car.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.Log4jUtils;

/**
 * @ClassName: DecryptFilter   
 * @Description: 通信解密过滤器
 * @author WangJianbin  
 * @date 2015年5月7日 下午6:42:30   
 *
 */
public class DecryptFilter implements Filter{

	
	private static final Log4jUtils log = new Log4jUtils();
	/* 
	 * <p>Title: init</p>   
	 * <p>Description: </p>   
	 * @param arg0
	 * @throws ServletException   
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)   
	 */   
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		log.log(LogLevel.INFO, "【通信解密过滤器】加载.....");
	}

	/* 
	 * <p>Title: doFilter</p>   
	 * <p>Description: </p>   
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException   
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)   
	 */   
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain filter) throws IOException, ServletException {
		//TODO 实现移动端访问拦截，DES解密
		
		filter.doFilter(request, response);
		
	}

	
	/* 
	 * <p>Title: destroy</p>   
	 * <p>Description: </p>      
	 * @see javax.servlet.Filter#destroy()   
	 */   
	@Override
	public void destroy() {
		log.log(LogLevel.INFO, "【通信解密过滤器】销毁.....");
		
	}
}
