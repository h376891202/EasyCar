package com.gred.easy_car.web.entity;

import java.math.BigDecimal;

public class Car {
    private String carId;

    private String carOwnerId;

    private String carBrandId;

    private String carBrandTypeId;

    private String carOwnerMobile;

    private String carBrand;

    private String carBrandType;

    private String carPlateNumber;

    private BigDecimal carTravelledDistance;

    private String carPosition;

    private String carProvince;

    private String carCity;

    private Integer carIsServicing;

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

    public BigDecimal getCarTravelledDistance() {
        return carTravelledDistance;
    }

    public void setCarTravelledDistance(BigDecimal carTravelledDistance) {
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
}