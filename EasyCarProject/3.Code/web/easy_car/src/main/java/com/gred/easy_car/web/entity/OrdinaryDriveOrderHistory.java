package com.gred.easy_car.web.entity;

import java.math.BigDecimal;

public class OrdinaryDriveOrderHistory {
    private String orderId;

    private String carId;

    private String driverId;

    private String orderNumber;

    private String orderStartTime;

    private String orderUserSubscribeTime;

    private String _4sConfirmOrderTime;

    private String orderDriverConfirmOrderTime;

    private String _4sReceiveCarTime;

    private String orderPayTime;

    private String orderClearTime;

    private String orderDriveStartTime;

    private String orderDriveEndTime;

    private Integer orderStatus;

    private BigDecimal orderTradingAmount;

    private Integer orderPayType;

    private BigDecimal orderPayAmount;

    private String orderCouponNumber;

    private Integer orderCouponNominalValue;

    private String orderCarSendAddress;

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

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(String orderStartTime) {
        this.orderStartTime = orderStartTime == null ? null : orderStartTime.trim();
    }

    public String getOrderUserSubscribeTime() {
        return orderUserSubscribeTime;
    }

    public void setOrderUserSubscribeTime(String orderUserSubscribeTime) {
        this.orderUserSubscribeTime = orderUserSubscribeTime == null ? null : orderUserSubscribeTime.trim();
    }

    public String get4sConfirmOrderTime() {
        return _4sConfirmOrderTime;
    }

    public void set4sConfirmOrderTime(String _4sConfirmOrderTime) {
        this._4sConfirmOrderTime = _4sConfirmOrderTime == null ? null : _4sConfirmOrderTime.trim();
    }

    public String getOrderDriverConfirmOrderTime() {
        return orderDriverConfirmOrderTime;
    }

    public void setOrderDriverConfirmOrderTime(String orderDriverConfirmOrderTime) {
        this.orderDriverConfirmOrderTime = orderDriverConfirmOrderTime == null ? null : orderDriverConfirmOrderTime.trim();
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

    public String getOrderDriveStartTime() {
        return orderDriveStartTime;
    }

    public void setOrderDriveStartTime(String orderDriveStartTime) {
        this.orderDriveStartTime = orderDriveStartTime == null ? null : orderDriveStartTime.trim();
    }

    public String getOrderDriveEndTime() {
        return orderDriveEndTime;
    }

    public void setOrderDriveEndTime(String orderDriveEndTime) {
        this.orderDriveEndTime = orderDriveEndTime == null ? null : orderDriveEndTime.trim();
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

    public String getOrderCarSendAddress() {
        return orderCarSendAddress;
    }

    public void setOrderCarSendAddress(String orderCarSendAddress) {
        this.orderCarSendAddress = orderCarSendAddress == null ? null : orderCarSendAddress.trim();
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