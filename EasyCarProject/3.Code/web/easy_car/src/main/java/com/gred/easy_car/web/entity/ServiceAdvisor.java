package com.gred.easy_car.web.entity;

public class ServiceAdvisor {
    private String advisorId;

    private String _4sServiceId;

    private String advisorLoginName;

    private String advisorPassword;

    private String advisorRealName;

    private String advisorMobile;

    private Integer advisorIsDiscard;

    private byte[] advisorHeadPortrait;

    public String getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(String advisorId) {
        this.advisorId = advisorId == null ? null : advisorId.trim();
    }

    public String get4sServiceId() {
        return _4sServiceId;
    }

    public void set4sServiceId(String _4sServiceId) {
        this._4sServiceId = _4sServiceId == null ? null : _4sServiceId.trim();
    }

    public String getAdvisorLoginName() {
        return advisorLoginName;
    }

    public void setAdvisorLoginName(String advisorLoginName) {
        this.advisorLoginName = advisorLoginName == null ? null : advisorLoginName.trim();
    }

    public String getAdvisorPassword() {
        return advisorPassword;
    }

    public void setAdvisorPassword(String advisorPassword) {
        this.advisorPassword = advisorPassword == null ? null : advisorPassword.trim();
    }

    public String getAdvisorRealName() {
        return advisorRealName;
    }

    public void setAdvisorRealName(String advisorRealName) {
        this.advisorRealName = advisorRealName == null ? null : advisorRealName.trim();
    }

    public String getAdvisorMobile() {
        return advisorMobile;
    }

    public void setAdvisorMobile(String advisorMobile) {
        this.advisorMobile = advisorMobile == null ? null : advisorMobile.trim();
    }

    public Integer getAdvisorIsDiscard() {
        return advisorIsDiscard;
    }

    public void setAdvisorIsDiscard(Integer advisorIsDiscard) {
        this.advisorIsDiscard = advisorIsDiscard;
    }

    public byte[] getAdvisorHeadPortrait() {
        return advisorHeadPortrait;
    }

    public void setAdvisorHeadPortrait(byte[] advisorHeadPortrait) {
        this.advisorHeadPortrait = advisorHeadPortrait;
    }
}