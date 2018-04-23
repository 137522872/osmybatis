package com.hzbl360.pojo;

import java.util.Arrays;
import java.util.Date;


/**
 * 用户表
 */
public class SysUser {
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private byte[] headImg;
    private Date createTime;


    public SysUser() {
    }

    public SysUser(Long id, String usernName, String userPassword,
                   String userEmail, String userInfo, byte[] headImg, Date createTime) {
        this.id = id;
        this.userName = usernName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userInfo = userInfo;
        this.headImg = headImg;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsernName() {
        return userName;
    }

    public void setUsernName(String usernName) {
        this.userName = usernName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", usernName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", headImg=" + Arrays.toString(headImg) +
                ", createTime=" + createTime +
                '}';
    }
}
