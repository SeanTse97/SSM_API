package edu.dgut.domain;

import java.io.Serializable;

public class Mask implements Serializable {
    private static final long serialVersionUID = -7965084347687561607L;
    String addUser;
    String editUser;
    long addTime;
    long editTime;
    String orderId; //入库id
    String maskName;
    int maskNo;//口罩数量
    String imageUrl;



    public Mask() {
    }

    public Mask(String addUser, String editUser, long addTime, long editTime, String orderId, String maskName, int maskNo, String imageUrl) {
        this.addUser = addUser;
        this.editUser = editUser;
        this.addTime = addTime;
        this.editTime = editTime;
        this.orderId = orderId;
        this.maskName = maskName;
        this.maskNo = maskNo;
        this.imageUrl = imageUrl;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMaskName() {
        return maskName;
    }

    public void setMaskName(String maskName) {
        this.maskName = maskName;
    }

    public int getMaskNo() {
        return maskNo;
    }

    public void setMaskNo(int maskNo) {
        this.maskNo = maskNo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Mask{" +
                "addUser='" + addUser + '\'' +
                ", editUser='" + editUser + '\'' +
                ", addTime=" + addTime +
                ", editTime=" + editTime +
                ", orderId='" + orderId + '\'' +
                ", maskName='" + maskName + '\'' +
                ", maskNo='" + maskNo + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
