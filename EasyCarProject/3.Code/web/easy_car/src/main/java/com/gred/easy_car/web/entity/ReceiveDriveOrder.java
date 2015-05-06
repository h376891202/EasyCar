package com.gred.easy_car.web.entity;

import java.math.BigDecimal;

public class ReceiveDriveOrder {
    private String orderId;

    private String carId;

    private String carPlateNumber;

    private String driverId;

    private String driverName;

    private String driverMobile;

    private String advisorId;

    private String _4sName;

    private String advisorName;

    private String advisorMobile;

    private String orderNumber;

    private String orderUserSubscribeReceiveTime;

    private String _4sConfirmOrderTime;

    private String orderDriveStartTime;

    private String orderDriverConfirmOrderTime;

    private String orderDriveEndTime;

    private String _4sReceiveCarTime;

    private String orderPayTime;

    private String orderClearTime;

    private String orderStartTime;

    private Integer orderStatus;

    private BigDecimal orderTradingAmount;

    private Integer orderPayType;

    private BigDecimal orderPayAmount;

    private String orderCouponNumber;

    private Integer orderCouponNominalValue;

    private String orderCarReceiveAddress;

    private BigDecimal orderDistance;

    private BigDecimal orderEstimateCost;

    private String orderComment;

    private String orderProvince;

    private String orderCity;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber == null ? null : carPlateNumber.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile == null ? null : driverMobile.trim();
    }

    public String getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(String advisorId) {
        this.advisorId = advisorId == null ? null : advisorId.trim();
    }

    public String get4sName() {
        return _4sName;
    }

    public void set4sName(String _4sName) {
        this._4sName = _4sName == null ? null : _4sName.trim();
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName == null ? null : advisorName.trim();
    }

    public String getAdvisorMobile() {
        return advisorMobile;
    }

    public void setAdvisorMobile(String advisorMobile) {
        this.advisorMobile = advisorMobile == null ? null : advisorMobile.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getOrderUserSubscribeReceiveTime() {
        return orderUserSubscribeReceiveTime;
    }

    public void setOrderUserSubscribeReceiveTime(String orderUserSubscribeReceiveTime) {
        this.orderUserSubscribeReceiveTime = orderUserSubscribeReceiveTime == null ? null : orderUserSubscribeReceiveTime.trim();
    }

    public String get4sConfirmOrderTime() {
        return _4sConfirmOrderTime;
    }

    public void set4sConfirmOrderTime(String _4sConfirmOrderTime) {
        this._4sConfirmOrderTime = _4sConfirmOrderTime == null ? null :_4sConfirmOrderTime.trim();
    }

    public String getOrderDriveStartTime() {
        return orderDriveStartTime;
    }

    public void setOrderDriveStartTime(String orderDriveStartTime) {
        this.orderDriveStartTime = orderDriveStartTime == null ? null : orderDriveStartTime.trim();
    }

    public String getOrderDriverConfirmOrderTime() {
        return orderDriverConfirmOrderTime;
    }

    public void setOrderDriverConfirmOrderTime(String orderDriverConfirmOrderTime) {
        this.orderDriverConfirmOrderTime = orderDriverConfirmOrderTime == null ? null : orderDriverConfirmOrderTime.trim();
    }

    public String getOrderDriveEndTime() {
        return orderDriveEndTime;
    }

    public void setOrderDriveEndTime(String orderDriveEndTime) {
        this.orderDriveEndTime = orderDriveEndTime == null ? null : orderDriveEndTime.trim();
    }

    public String get4sReceiveCarTime() {
        return _4sReceiveCarTime;
    }

    public void set4sReceiveCarTime(String _4sReceiveCarTime) {
        this._4sReceiveCarTime = _4sReceiveCarTime == null ? null : _4sReceiveCarTime.trim();
    }

    public String getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(String orderPayTime) {
        this.orderPayTime = orderPayTime == null ? null : orderPayTime.trim();
    }

    public String getOrderClearTime() {
        return orderClearTime;
    }

    public void setOrderClearTime(String orderClearTime) {
        this.orderClearTime = orderClearTime == null ? null : orderClearTime.trim();
    }

    public String getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(String orderStartTime) {
        this.orderStartTime = orderStartTime == null ? null : orderStartTime.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderTradingAmount() {
        return orderTradingAmount;
    }

    public void setOrderTradingAmount(BigDecimal orderTradingAmount) {
        this.orderTradingAmount = orderTradingAmount;
    }

    public Integer getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(Integer orderPayType) {
        this.orderPayType = orderPayType;
    }

    public BigDecimal getOrderPayAmount() {
        return orderPayAmount;
    }

    public void setOrderPayAmount(BigDecimal orderPayAmount) {
        this.orderPayAmount = orderPayAmount;
    }

    public String getOrderCouponNumber() {
        return orderCouponNumber;
    }

    public void setOrderCouponNumber(String orderCouponNumber) {
        this.orderCouponNumber = orderCouponNumber == null ? null : orderCouponNumber.trim();
    }

    public Integer getOrderCouponNominalValue() {
        return orderCouponNominalValue;
    }

    public void setOrderCouponNominalValue(Integer orderCouponNominalValue) {
        this.orderCouponNominalValue = orderCouponNominalValue;
    }

    public String getOrderCarReceiveAddress() {
        return orderCarReceiveAddress;
    }

    public void setOrderCarReceiveAddress(String orderCarReceiveAddress) {
        this.orderCarReceiveAddress = orderCarReceiveAddress == null ? null : orderCarReceiveAddress.trim();
    }

    public BigDecimal getOrderDistance() {
        return orderDistance;
    }

    public void setOrderDistance(BigDecimal orderDistance) {
        this.orderDistance = orderDistance;
    }

    public BigDecimal getOrderEstimateCost() {
        return orderEstimateCost;
    }

    public void setOrderEstimateCost(BigDecimal orderEstimateCost) {
        this.orderEstimateCost = orderEstimateCost;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment == null ? null : orderComment.trim();
    }

    public String getOrderProvince() {
        return orderProvince;
    }

    public void setOrderProvince(String orderProvince) {
        this.orderProvince = orderProvince == null ? null : orderProvince.trim();
    }

    public String getOrderCity() {
        return orderCity;
    }

    public void setOrderCity(String orderCity) {
        this.orderCity = orderCity == null ? null : orderCity.trim();
    }
}