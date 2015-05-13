package com.gred.easy_car.web.entity;

public class CarBrand {

    private String carBrandName;

    private byte[] carBrandIcon;


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