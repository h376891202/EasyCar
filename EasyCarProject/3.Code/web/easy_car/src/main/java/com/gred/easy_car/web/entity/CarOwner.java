package com.gred.easy_car.web.entity;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

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
	
	
	@Length(max=16,min=6,message="密码长度要求6-16位")
    private String userPwd;
    
    private String repeatedPwd;

    private String identifyingCode;
    
    private String userRegisterTime;
    
    private String userDrivingPermitPath;

    private byte[] userHeadPortrait;
    
    /**封装参数用字段，与数据库非对应**/
    
    private String carBrand;
    
    private String carBrandType;
    
    private String carPlateNumber;
    
    private String  carTravelledDistance;
    
   

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
	 * @return the carTravelledDistance
	 */
	public String getCarTravelledDistance() {
		return carTravelledDistance;
	}

	/**
	 * @param carTravelledDistance the carTravelledDistance to set
	 */
	public void setCarTravelledDistance(String carTravelledDistance) {
		this.carTravelledDistance = carTravelledDistance;
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

	/**
	 * @return the carBrand
	 */
	public String getCarBrand() {
		return carBrand;
	}

	/**
	 * @param carBrand the carBrand to set
	 */
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	/**
	 * @return the carBrandType
	 */
	public String getCarBrandType() {
		return carBrandType;
	}

	/**
	 * @param carBrandType the carBrandType to set
	 */
	public void setCarBrandType(String carBrandType) {
		this.carBrandType = carBrandType;
	}

	/**
	 * @return the carPlateNumber
	 */
	public String getCarPlateNumber() {
		return carPlateNumber;
	}

	/**
	 * @param carPlateNumber the carPlateNumber to set
	 */
	public void setCarPlateNumber(String carPlateNumber) {
		this.carPlateNumber = carPlateNumber;
	}

	
    
    
}