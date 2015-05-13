package com.gred.easy_car.web.entity;

/**
 * 
 * @ClassName: CarBrandType
 * @Description: 车型实体
 * @author WangJianbin
 * @date 2015年5月13日 上午11:26:48
 * 
 */
public class CarBrandType {

	/**车型ID*/
	private Integer carBrandTypeId;
	/**首字母大写（用于排序）*/
	private String carFirstLetter;
	/**品牌名称*/
	private String carBrandName;
	/**车型系列*/
	private String carModelSeries;
	/**车型名称*/
	private String carModelName;

	private String carTypeSeries;

	private String carTypeName;

	private String carMadeCountry;

	private String carTechnology;

	private String carVehicleClass;

	private String carEngineCapacity;

	private String carTransmission;

	public Integer getCarBrandTypeId() {
		return carBrandTypeId;
	}

	public void setCarBrandTypeId(Integer carBrandTypeId) {
		this.carBrandTypeId = carBrandTypeId;
	}

	public String getCarFirstLetter() {
		return carFirstLetter;
	}

	public void setCarFirstLetter(String carFirstLetter) {
		this.carFirstLetter = carFirstLetter == null ? null : carFirstLetter
				.trim();
	}

	public String getCarBrandName() {
		return carBrandName;
	}

	public void setCarBrandName(String carBrandName) {
		this.carBrandName = carBrandName == null ? null : carBrandName.trim();
	}

	public String getCarModelSeries() {
		return carModelSeries;
	}

	public void setCarModelSeries(String carModelSeries) {
		this.carModelSeries = carModelSeries == null ? null : carModelSeries
				.trim();
	}

	public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName == null ? null : carModelName.trim();
	}

	public String getCarTypeSeries() {
		return carTypeSeries;
	}

	public void setCarTypeSeries(String carTypeSeries) {
		this.carTypeSeries = carTypeSeries == null ? null : carTypeSeries
				.trim();
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName == null ? null : carTypeName.trim();
	}

	public String getCarMadeCountry() {
		return carMadeCountry;
	}

	public void setCarMadeCountry(String carMadeCountry) {
		this.carMadeCountry = carMadeCountry == null ? null : carMadeCountry
				.trim();
	}

	public String getCarTechnology() {
		return carTechnology;
	}

	public void setCarTechnology(String carTechnology) {
		this.carTechnology = carTechnology == null ? null : carTechnology
				.trim();
	}

	public String getCarVehicleClass() {
		return carVehicleClass;
	}

	public void setCarVehicleClass(String carVehicleClass) {
		this.carVehicleClass = carVehicleClass == null ? null : carVehicleClass
				.trim();
	}

	public String getCarEngineCapacity() {
		return carEngineCapacity;
	}

	public void setCarEngineCapacity(String carEngineCapacity) {
		this.carEngineCapacity = carEngineCapacity == null ? null
				: carEngineCapacity.trim();
	}

	public String getCarTransmission() {
		return carTransmission;
	}

	public void setCarTransmission(String carTransmission) {
		this.carTransmission = carTransmission == null ? null : carTransmission
				.trim();
	}
}