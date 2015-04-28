/**
 * @Title: UserEntity.java   
 * @Package com.gred.easy_car.web.entity   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月29日 下午2:05:03   
 * @version V2.0     
 */
package com.gred.easy_car.web.entity;

/**
 * @ClassName: UserEntity
 * @Description: 用户信息实体
 * @author WangJianbin
 * @date 2015年4月29日 下午2:05:03
 * 
 */
public class UserEntity {
	

	/**用户UUID*/
	private String userId;
	
	/**用户移动电话（登陆依据）*/
	private String userMobile;
	
	/**用户密码*/
	private String userPwd;
	
	/**注册时间*/
	private String userRegisterTime;
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd == null ? null : userPwd.trim();
	}

	public String getUserRegisterTime() {
		return userRegisterTime;
	}

	public void setUserRegisterTime(String userRegisterTime) {
		this.userRegisterTime = userRegisterTime == null ? null
				: userRegisterTime.trim();
	}
}
