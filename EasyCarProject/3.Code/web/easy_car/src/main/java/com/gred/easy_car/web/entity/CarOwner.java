package com.gred.easy_car.web.entity;

public class CarOwner {
    private String userId;

    private String userMobile;

    private String userPwd;

    private String userRegisterTime;

    private String userDrivingPermitPath;

    private byte[] userHeadPortrait;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(String userRegisterTime) {
        this.userRegisterTime = userRegisterTime == null ? null : userRegisterTime.trim();
    }

    public String getUserDrivingPermitPath() {
        return userDrivingPermitPath;
    }

    public void setUserDrivingPermitPath(String userDrivingPermitPath) {
        this.userDrivingPermitPath = userDrivingPermitPath == null ? null : userDrivingPermitPath.trim();
    }

    public byte[] getUserHeadPortrait() {
        return userHeadPortrait;
    }

    public void setUserHeadPortrait(byte[] userHeadPortrait) {
        this.userHeadPortrait = userHeadPortrait;
    }
}