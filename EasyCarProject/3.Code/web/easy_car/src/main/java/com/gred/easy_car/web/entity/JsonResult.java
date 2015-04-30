/**
 * @Title: JsonResult.java   
 * @Package com.gred.easy_car.web.entity   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月30日 上午10:31:01   
 * @version V2.0     
 */
package com.gred.easy_car.web.entity;

import java.util.List;

/**
 * @ClassName: JsonResult   
 * @Description: Json格式返回信息封装类
 * @author WangJianbin  
 * @param <T>
 * @date 2015年4月30日 上午10:31:01   
 *
 */
public class JsonResult<T> {
	/**状态码*/
	private Integer status ;
	/**错误信息*/
	private String statusMessage;
	/**数据*/
	private List<T>  data;

	

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
}
