/**
 * @Title: PageEntity.java   
 * @Package com.gred.easy_car.web.entity   
 * @Description:    
 * @author WangJianbin     
 * @date 2015年4月25日 下午3:08:55   
 * @version V2.0     
 */
package com.gred.easy_car.web.entity;

import java.util.Map;

/**
 * @ClassName: PageEntity   
 * @Description: (分页信息类)   
 * @author WangJianbin  
 * @date 2015年4月25日 下午3:08:55   
 *
 */
public class Page {
	
	/**目前第几页**/
	private Integer page; 
    /**每页大小**/
	private Integer size; 
    /**传入参数**/
	private Map params;  
	/**排序列**/
    private String orderColumn;  
    /**升降序**/
    private String orderTurn = "ASC";
	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	/**
	 * @return the params
	 */
	public Map getParams() {
		return params;
	}
	/**
	 * @param params the params to set
	 */
	public void setParams(Map params) {
		this.params = params;
	}
	/**
	 * @return the orderColumn
	 */
	public String getOrderColumn() {
		return orderColumn;
	}
	/**
	 * @param orderColumn the orderColumn to set
	 */
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	/**
	 * @return the orderTurn
	 */
	public String getOrderTurn() {
		return orderTurn;
	}
	/**
	 * @param orderTurn the orderTurn to set
	 */
	public void setOrderTurn(String orderTurn) {
		this.orderTurn = orderTurn;
	}  
    
    

}
