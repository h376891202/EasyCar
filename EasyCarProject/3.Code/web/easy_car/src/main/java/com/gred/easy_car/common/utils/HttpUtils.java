/**
 * @Title: HttpUtils.java   
 * @Package com.gred.easy_car.common.utils   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月27日 下午1:35:08   
 * @version V2.0     
 */
package com.gred.easy_car.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.web.controller.mobile.MobileTerminalAccessController;


/**
 * @ClassName: HttpUtils   
 * @Description: (此类为模拟http请求工具类，采用apache http client4.x实现)   
 * @author WangJianbin  
 * @date 2015年4月27日 下午1:35:08   
 *
 */
public class HttpUtils {
	
	
	private static final Log4jUtils log = new Log4jUtils(HttpUtils.class);
	
	private static HttpClientBuilder httpClientBuilder = null;
	
	private static HttpClient  httpClient= null;
	
	static {
		httpClientBuilder = HttpClientBuilder.create();
		
		httpClientBuilder.setConnectionTimeToLive(3000, TimeUnit.MILLISECONDS);//设置链接超时时间 3000毫秒
		
		httpClient = httpClientBuilder.build();
	}
	
	
	/**
	 * 
	 * @Title: doHttpGet   
	 * @Description: (模拟HttpGet请求)   
	 * @param @param url
	 * @param @param params
	 * @return HttpResponse    返回类型   
	 * @throws   
	 */
	public static String doHttpGet(String url , Map<String, String> params){
		HttpResponse httpResponse =null;
		HttpEntity entity = null;  
        String result = null;  
        
		StringBuffer  urlWithPrams = new StringBuffer(url+"?");
		for(Entry<String, String> entry : params.entrySet()){
			String paramName = entry.getKey();
			String paramValue = entry.getValue();
			urlWithPrams.append(paramName+"="+paramValue+"&");
		}
		urlWithPrams.deleteCharAt(urlWithPrams.length()-1);//去除最后多余的 &符号
		
		HttpGet httpGet = new HttpGet(urlWithPrams.toString());
		
		try {
			httpResponse  = httpClient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();  
            if(statusCode != HttpStatus.SC_OK){
            	 log.log(LogLevel.ERROR, "httpGet URL [" + url+ "]:+HttpStatus ERROR" + "Method failed: "+ httpResponse.getStatusLine());
            }else{
            	entity = httpResponse.getEntity();  
                if (null != entity) {  
                    byte[] bytes = EntityUtils.toByteArray(entity);  
                    result = new String(bytes, "UTF-8");  
                } else {  
                	log.log(LogLevel.ERROR,"httpGet URL [" + url+ "]:,httpEntity is null!");
                }  
                
            }
			
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	/**
	 * 
	 * @Title: dohttpPost   
	 * @Description: (模拟HttpPost请求)   
	 * @param @param url
	 * @param @param params
	 * @param @return    
	 * @return HttpResponse    返回类型   
	 * @throws
	 */
	public static String  dohttpPost (String url , Map<String, String> params){
		
		HttpResponse httpResponse =null;
		HttpEntity entity = null;  
        String result = null;  
        
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		
		for(Entry<String, String> entry : params.entrySet()){
			String paramName = entry.getKey();
			String paramValue = entry.getValue();
			nameValuePairs.add(new BasicNameValuePair(paramName, paramValue));
		}
		
		try {
			
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();  
            if(statusCode != HttpStatus.SC_OK){
            	 log.log(LogLevel.ERROR,"httpPost URL [" + url+ "]:HttpStatus ERROR" + "Method failed: "+ httpResponse.getStatusLine()); 
            }else{
            	entity = httpResponse.getEntity();  
                if (null != entity) {  
                    byte[] bytes = EntityUtils.toByteArray(entity);  
                    result = new String(bytes, "UTF-8");  
                } else {  
                	 log.log(LogLevel.ERROR,"httpPost URL [" + url+ "]:,httpEntity is null!");
                }  
            } 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	
	}
	
}
