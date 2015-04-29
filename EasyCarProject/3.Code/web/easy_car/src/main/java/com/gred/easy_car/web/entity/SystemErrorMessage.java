/**
 * @Title: SystemErrorMessage.java   
 * @Package com.gred.easy_car.web.entity   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月30日 上午11:42:41   
 * @version V2.0     
 */
package com.gred.easy_car.web.entity;

/**
 * @ClassName: SystemErrorMessage   
 * @Description: 系统错误信息类
 * @author WangJianbin  
 * @date 2015年4月30日 上午11:42:41   
 *
 */
public class SystemErrorMessage {
	 
		/**错误码*/
		private Integer errorCode;
		/**错误信息*/
	    private String errorMessage;

	    public Integer getErrorCode() {
	        return errorCode;
	    }

	    public void setErrorCode(Integer errorCode) {
	        this.errorCode = errorCode;
	    }

	    public String getErrorMessage() {
	        return errorMessage;
	    }

	    public void setErrorMessage(String errorMessage) {
	        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
	    }
	    
}
