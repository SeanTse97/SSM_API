package edu.dgut.domain;

import java.io.Serializable;

public class User2 implements Serializable {
    private static final long serialVersionUID = 9171981711342900383L;
    String addUser;
    String editUser;
    long addTime;
    long editTime;
    String userId;
    String userName;
    String userPassword;
    String userMobile;
    String province;
    String city;
    String area;
    String place;
    String isLock = "N";
    int roleId = 2;

    public User2() {
    }

    public User2(String addUser, String editUser, long addTime, long editTime, String userId, String userName, String userPassword, String userMobile, String province, String city, String area, String place, String isLock, int roleId) {
        this.addUser = addUser;
        this.editUser = editUser;
        this.addTime = addTime;
        this.editTime = editTime;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMobile = userMobile;
        this.province = province;
        this.city = city;
        this.area = area;
        this.place = place;
        this.isLock = isLock;
        this.roleId = roleId;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public long getEditTime() {
        return editTime;
    }

    public void setEditTime(long editTime) {
        this.editTime = editTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User2{" +
                "addUser='" + addUser + '\'' +
                ", editUser='" + editUser + '\'' +
                ", addTime='" + addTime + '\'' +
                ", editTime='" + editTime + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", place='" + place + '\'' +
                ", isLock=" + isLock +
                ", roleId=" + roleId +
                '}';
    }
}
