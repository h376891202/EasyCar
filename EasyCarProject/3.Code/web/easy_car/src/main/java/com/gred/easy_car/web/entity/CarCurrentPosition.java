package com.gred.easy_car.web.entity;

public class CarCurrentPosition  {
    
	private String carId;

    private String driverId;
	
	private String carPlateNumber;

    private String orderId;

    private String orderNumber;

    private String driverName;

    private String carStartPosition;

    private String carDriverStartTime;

    private String carDriverFinishtTime;

    private String carDriverDestination;

    private String carCurrentPosition;

    
    
    
    /**
	 * @return the carId
	 */
	public String getCarId() {
		return carId;
	}

	/**
	 * @param carId the carId to set
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}

	/**
	 * @return the driverId
	 */
	public String getDriverId() {
		return driverId;
	}

	/**
	 * @param driverId the driverId to set
	 */
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber == null ? null : carPlateNumber.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    public String getCarStartPosition() {
        return carStartPosition;
    }

    public void setCarStartPosition(String carStartPosition) {
        this.carStartPosition = carStartPosition == null ? null : carStartPosition.trim();
    }

    public String getCarDriverStartTime() {
        return carDriverStartTime;
    }

    public void setCarDriverStartTime(String carDriverStartTime) {
        this.carDriverStartTime = carDriverStartTime == null ? null : carDriverStartTime.trim();
    }

    public String getCarDriverFinishtTime() {
        return carDriverFinishtTime;
    }

    public void setCarDriverFinishtTime(String carDriverFinishtTime) {
        this.carDriverFinishtTime = carDriverFinishtTime == null ? null : carDriverFinishtTime.trim();
    }

    public String getCarDriverDestination() {
        return carDriverDestination;
    }

    public void setCarDriverDestination(String carDriverDestination) {
        this.carDriverDestination = carDriverDestination == null ? null : carDriverDestination.trim();
    }

    public String getCarCurrentPosition() {
        return carCurrentPosition;
    }

    public void setCarCurrentPosition(String carCurrentPosition) {
        this.carCurrentPosition = carCurrentPosition == null ? null : carCurrentPosition.trim();
    }
}