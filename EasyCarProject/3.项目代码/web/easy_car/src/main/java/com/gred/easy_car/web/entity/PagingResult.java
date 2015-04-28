/**
 * @Title: PagingResult.java   
 * @Package com.gred.easy_car.web.entity   
 * @Description:    
 * @author WangJianbin     
 * @date 2015年4月25日 下午3:13:57   
 * @version V2.0     
 */
package com.gred.easy_car.web.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PagingResult   
 * @Description: (分页结果类)   
 * @author WangJianbin  
 * @date 2015年4月25日 下午3:13:57   
 *
 */
public class PagingResult<T> {
	
	 /**当前页**/
    private int currentPage;  
    /**总共记录条数**/  
    private int totalSize;  
    /**结果集**/
    private List<T> resultList = new ArrayList<T>();
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the totalSize
	 */
	public int getTotalSize() {
		return totalSize;
	}
	/**
	 * @param totalSize the totalSize to set
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	/**
	 * @return the resultList
	 */
	public List<T> getResultList() {
		return resultList;
	}
	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}  
    
    

}
