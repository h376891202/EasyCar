package com.gred.easy_car.web.entity;

public class Driver {
    private String driverId;

    private String companyId;

    private String driverName;

    private String driverMobile;

    private String driverPassword;

    private String driverIdCardNumber;

    private String driverLicenseNumber;

    private String driverBankAccount;

    private String driverLicensePhoto;

    private Integer driverAge;

    private Integer driverStarLever;

    private Integer driverIsDiscard;

    private Integer driverIsReady;

    private Integer driverIsDriving;

    private byte[] driverHeadPortrait;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
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

    public String getDriverPassword() {
        return driverPassword;
    }

    public void setDriverPassword(String driverPassword) {
        this.driverPassword = driverPassword == null ? null : driverPassword.trim();
    }

    public String getDriverIdCardNumber() {
        return driverIdCardNumber;
    }

    public void setDriverIdCardNumber(String driverIdCardNumber) {
        this.driverIdCardNumber = driverIdCardNumber == null ? null : driverIdCardNumber.trim();
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber == null ? null : driverLicenseNumber.trim();
    }

    public String getDriverBankAccount() {
        return driverBankAccount;
    }

    public void setDriverBankAccount(String driverBankAccount) {
        this.driverBankAccount = driverBankAccount == null ? null : driverBankAccount.trim();
    }

    public String getDriverLicensePhoto() {
        return driverLicensePhoto;
    }

    public void setDriverLicensePhoto(String driverLicensePhoto) {
        this.driverLicensePhoto = driverLicensePhoto == null ? null : driverLicensePhoto.trim();
    }

    public Integer getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(Integer driverAge) {
        this.driverAge = driverAge;
    }

    public Integer getDriverStarLever() {
        return driverStarLever;
    }

    public void setDriverStarLever(Integer driverStarLever) {
        this.driverStarLever = driverStarLever;
    }

    public Integer getDriverIsDiscard() {
        return driverIsDiscard;
    }

    public void setDriverIsDiscard(Integer driverIsDiscard) {
        this.driverIsDiscard = driverIsDiscard;
    }

    public Integer getDriverIsReady() {
        return driverIsReady;
    }

    public void setDriverIsReady(Integer driverIsReady) {
        this.driverIsReady = driverIsReady;
    }

    public Integer getDriverIsDriving() {
        return driverIsDriving;
    }

    public void setDriverIsDriving(Integer driverIsDriving) {
        this.driverIsDriving = driverIsDriving;
    }

    public byte[] getDriverHeadPortrait() {
        return driverHeadPortrait;
    }

    public void setDriverHeadPortrait(byte[] driverHeadPortrait) {
        this.driverHeadPortrait = driverHeadPortrait;
    }
}