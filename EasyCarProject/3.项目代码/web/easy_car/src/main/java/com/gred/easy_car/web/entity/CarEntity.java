/**
 * @Title: CarEntity.java   
 * @Package com.gred.easy_car.web.entity   
 * @Description: (用一句话描述该文件做什么)   
 * @author WangJianbin     
 * @date 2015年4月29日 下午2:05:33   
 * @version V2.0     
 */
package com.gred.easy_car.web.entity;

/**
 * @ClassName: CarEntity
 * @Description: 车辆信息实体
 * @author WangJianbin
 * @date 2015年4月29日 下午2:05:33
 * 
 */
public class CarEntity {
	
	
	/**车辆UUID*/
	private String carId;
	
	/**车主UUID*/
	private String carOwnerId;
	
	/**车主移动电话*/
	private String carOwnerMobile;
	
	/**车辆品牌*/
	private String carBrand;
	
	/**车型*/
	private String carBrandType;
	
	/**车牌号*/
	private String carPlateNumber;
	
	/**行驶里程*/
	private String carTravelledDistance;
	
	

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

	public String getCarOwnerMobile() {
		return carOwnerMobile;
	}

	public void setCarOwnerMobile(String carOwnerMobile) {
		this.carOwnerMobile = carOwnerMobile == null ? null : carOwnerMobile
				.trim();
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
		this.carPlateNumber = carPlateNumber == null ? null : carPlateNumber
				.trim();
	}

	public String getCarTravelledDistance() {
		return carTravelledDistance;
	}

	public void setCarTravelledDistance(String carTravelledDistance) {
		this.carTravelledDistance = carTravelledDistance == null ? null
				: carTravelledDistance.trim();
	}

}
