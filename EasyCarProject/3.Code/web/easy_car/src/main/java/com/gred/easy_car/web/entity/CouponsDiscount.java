package com.gred.easy_car.web.entity;

public class CouponsDiscount {
    private String couponId;

    private String couponCode;

    private String couponCreateDate;

    private String couponExpiryDate;

    private Integer couponNominalValue;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    public String getCouponCreateDate() {
        return couponCreateDate;
    }

    public void setCouponCreateDate(String couponCreateDate) {
        this.couponCreateDate = couponCreateDate == null ? null : couponCreateDate.trim();
    }

    public String getCouponExpiryDate() {
        return couponExpiryDate;
    }

    public void setCouponExpiryDate(String couponExpiryDate) {
        this.couponExpiryDate = couponExpiryDate == null ? null : couponExpiryDate.trim();
    }

    public Integer getCouponNominalValue() {
        return couponNominalValue;
    }

    public void setCouponNominalValue(Integer couponNominalValue) {
        this.couponNominalValue = couponNominalValue;
    }
}