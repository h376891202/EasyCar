package com.gred.easy_car.web.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * 
 * @ClassName: Car   
 * @Description: 车辆信息实体
 * @author WangJianbin  
 * @date 2015年5月8日 下午2:44:09   
 *
 */

public class Car {
	
    private String carId;
    
    private String carOwnerId;
   
    private String carBrandId;
    
    private String carBrandTypeId;

    private String carOwnerMobile;
    
    @NotNull(message="车品牌不能为空")
    private String carBrand;
    
    @NotNull(message="车型不能为空")
    private String carBrandType;
    
    @NotNull(message="车牌号不能为空")
    private String carPlateNumber;
    
    @NotNull(message="车辆行驶里程不能为空")
    private float carTravelledDistance;

    private String carPosition;

    private String carProvince;

    private String carCity;

    private Integer carIsServicing;
    
    private List<Car> carList;
    
    private String carBrandIconName;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getCarOwnerId() {
        return carOwnerId;
    }

    public void setCarOwnerId(String carOwnerId) {
        this.carOwnerId = carOwnerId == null ? null : carOwnerId.trim();
    }

    public String getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(String carBrandId) {
        this.carBrandId = carBrandId == null ? null : carBrandId.trim();
    }

    public String getCarBrandTypeId() {
        return carBrandTypeId;
    }

    public void setCarBrandTypeId(String carBrandTypeId) {
        this.carBrandTypeId = carBrandTypeId == null ? null : carBrandTypeId.trim();
    }

    public String getCarOwnerMobile() {
        return carOwnerMobile;
    }

    public void setCarOwnerMobile(String carOwnerMobile) {
        this.carOwnerMobile = carOwnerMobile == null ? null : carOwnerMobile.trim();
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand == null ? null : carBrand.trim();
    }

    public String getCarBrandType() {
        return carBrandType;
    }

    public void setCarBrandType(String carBrandType) {
        this.carBrandType = carBrandType == null ? null : carBrandType.trim();
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber == null ? null : carPlateNumber.trim();
    }

  

    /**
	 * @return the carTravelledDistance
	 */
	public float getCarTravelledDistance() {
		return carTravelledDistance;
	}

	/**
	 * @param carTravelledDistance the carTravelledDistance to set
	 */
	public void setCarTravelledDistance(float carTravelledDistance) {
		this.carTravelledDistance = carTravelledDistance;
	}

	public String getCarPosition() {
        return carPosition;
    }

    public void setCarPosition(String carPosition) {
        this.carPosition = carPosition == null ? null : carPosition.trim();
    }

    public String getCarProvince() {
        return carProvince;
    }

    public void setCarProvince(String carProvince) {
        this.carProvince = carProvince == null ? null : carProvince.trim();
    }

    public String getCarCity() {
        return carCity;
    }

    public void setCarCity(String carCity) {
        this.carCity = carCity == null ? null : carCity.trim();
    }

    public Integer getCarIsServicing() {
        return carIsServicing;
    }

    public void setCarIsServicing(Integer carIsServicing) {
        this.carIsServicing = carIsServicing;
    }

	/**
	 * @return the carList
	 */
	public List<Car> getCarList() {
		return carList;
	}

	/**
	 * @param carList the carList to set
	 */
	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	/**
	 * @return the carBrandIconPath
	 */
	public String getCarBrandIconPath() {
		return carBrandIconName;
	}

	/**
	 * @param carBrandIconPath the carBrandIconPath to set
	 */
	public void setCarBrandIconPath(String carBrandIconPath) {
		this.carBrandIconName = carBrandIconPath;
	}
    
	
    
}