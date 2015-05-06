package com.gred.easy_car.web.entity;

public class CarOwnerMessage {
    private String carOwnerMessageId;

    private String carOwnerMessageCarOwnerId;

    private Integer carOwnerMessageType;

    private String carOwnerMessageContent;

    public String getCarOwnerMessageId() {
        return carOwnerMessageId;
    }

    public void setCarOwnerMessageId(String carOwnerMessageId) {
        this.carOwnerMessageId = carOwnerMessageId == null ? null : carOwnerMessageId.trim();
    }

    public String getCarOwnerMessageCarOwnerId() {
        return carOwnerMessageCarOwnerId;
    }

    public void setCarOwnerMessageCarOwnerId(String carOwnerMessageCarOwnerId) {
        this.carOwnerMessageCarOwnerId = carOwnerMessageCarOwnerId == null ? null : carOwnerMessageCarOwnerId.trim();
    }

    public Integer getCarOwnerMessageType() {
        return carOwnerMessageType;
    }

    public void setCarOwnerMessageType(Integer carOwnerMessageType) {
        this.carOwnerMessageType = carOwnerMessageType;
    }

    public String getCarOwnerMessageContent() {
        return carOwnerMessageContent;
    }

    public void setCarOwnerMessageContent(String carOwnerMessageContent) {
        this.carOwnerMessageContent = carOwnerMessageContent == null ? null : carOwnerMessageContent.trim();
    }
}