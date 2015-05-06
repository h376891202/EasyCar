package com.gred.easy_car.web.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @ClassName: CarOwner   
 * @Description: 车主信息实体
 * @author WangJianbin  
 * @date 2015年5月8日 下午2:44:24   
 *
 */
public class CarOwner {
	
	
    private String userId;

	@NotBlank(message="车主电话不能为空！")
    private String userMobile;
	
	@Min(value=6,message="密码长度不够！")
	@Max(value=16,message="密码过长！")
	@NotBlank(message="密码不能为空！")
    private String userPwd;
    
    private String repeatedPwd;

    private String identifyingCode;
    
    private String userRegisterTime;
    
    @NotBlank(message="行驶里程不能为空！")
    private String userDrivingPermitPath;

    private byte[] userHeadPortrait;

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
    
  

	/**
	 * @return the identifyingCode
	 */
	public String getIdentifyingCode() {
		return identifyingCode;
	}

	/**
	 * @param identifyingCode the identifyingCode to set
	 */
	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}

	public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    
    /**
	 * @return the repeatedPwd
	 */
	public String getRepeatedPwd() {
		return repeatedPwd;
	}

	/**
	 * @param repeatedPwd the repeatedPwd to set
	 */
	public void setRepeatedPwd(String repeatedPwd) {
		this.repeatedPwd = repeatedPwd;
	}

	public String getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(String userRegisterTime) {
        this.userRegisterTime = userRegisterTime == null ? null : userRegisterTime.trim();
    }

    public String getUserDrivingPermitPath() {
        return userDrivingPermitPath;
    }

    public void setUserDrivingPermitPath(String userDrivingPermitPath) {
        this.userDrivingPermitPath = userDrivingPermitPath == null ? null : userDrivingPermitPath.trim();
    }

    public byte[] getUserHeadPortrait() {
        return userHeadPortrait;
    }

    public void setUserHeadPortrait(byte[] userHeadPortrait) {
        this.userHeadPortrait = userHeadPortrait;
    }
}