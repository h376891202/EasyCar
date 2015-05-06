package com.gred.easy_car.web.entity;

public class CarBrandType {
    private String carBrandTypeId;

    private String carBrandId;

    private String carBrandName;

    private String carBrandTypeName;

    private String carBrandTypeBrandId;

    public String getCarBrandTypeId() {
        return carBrandTypeId;
    }

    public void setCarBrandTypeId(String carBrandTypeId) {
        this.carBrandTypeId = carBrandTypeId == null ? null : carBrandTypeId.trim();
    }

    public String getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(String carBrandId) {
        this.carBrandId = carBrandId == null ? null : carBrandId.trim();
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName == null ? null : carBrandName.trim();
    }

    public String getCarBrandTypeName() {
        return carBrandTypeName;
    }

    public void setCarBrandTypeName(String carBrandTypeName) {
        this.carBrandTypeName = carBrandTypeName == null ? null : carBrandTypeName.trim();
    }

    public String getCarBrandTypeBrandId() {
        return carBrandTypeBrandId;
    }

    public void setCarBrandTypeBrandId(String carBrandTypeBrandId) {
        this.carBrandTypeBrandId = carBrandTypeBrandId == null ? null : carBrandTypeBrandId.trim();
    }
}