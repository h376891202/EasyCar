package com.gred.easy_car.web.entity;

public class DriverPosition {
    private String driverId;

    private String driverCurrentPosition;

    private String driverPositionLastUpdateTime;

    private String driverProvince;

    private String driverCity;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getDriverCurrentPosition() {
        return driverCurrentPosition;
    }

    public void setDriverCurrentPosition(String driverCurrentPosition) {
        this.driverCurrentPosition = driverCurrentPosition == null ? null : driverCurrentPosition.trim();
    }

    public String getDriverPositionLastUpdateTime() {
        return driverPositionLastUpdateTime;
    }

    public void setDriverPositionLastUpdateTime(String driverPositionLastUpdateTime) {
        this.driverPositionLastUpdateTime = driverPositionLastUpdateTime == null ? null : driverPositionLastUpdateTime.trim();
    }

    public String getDriverProvince() {
        return driverProvince;
    }

    public void setDriverProvince(String driverProvince) {
        this.driverProvince = driverProvince == null ? null : driverProvince.trim();
    }

    public String getDriverCity() {
        return driverCity;
    }

    public void setDriverCity(String driverCity) {
        this.driverCity = driverCity == null ? null : driverCity.trim();
    }
}