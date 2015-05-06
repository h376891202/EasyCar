package com.gred.easy_car.web.entity;

public class CarBrand {
    private String carBrandId;

    private String carBrandName;

    private byte[] carBrandIcon;

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

    public byte[] getCarBrandIcon() {
        return carBrandIcon;
    }

    public void setCarBrandIcon(byte[] carBrandIcon) {
        this.carBrandIcon = carBrandIcon;
    }
}