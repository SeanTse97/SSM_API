package edu.dgut.domain;

public class Mask {
    String addUser;
    String editUser;
    long addTime;
    long editTime;
    String orderId; //入库id
    String maskName;
    String maskNo;//口罩数量



    public Mask() {
    }

    public Mask(String addUser, String editUser, long addTime, long editTime, String orderId, String maskName, String maskNo) {
        this.addUser = addUser;
        this.editUser = editUser;
        this.addTime = addTime;
        this.editTime = editTime;
        this.orderId = orderId;
        this.maskName = maskName;
        this.maskNo = maskNo;

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

    public String getMaskNo() {
        return maskNo;
    }

    public void setMaskNo(String maskNo) {
        this.maskNo = maskNo;
    }


    @Override
    public String toString() {
        return "Mask{" +
                "addUser='" + addUser + '\'' +
                ", editUser='" + editUser + '\'' +
                ", addTime='" + addTime + '\'' +
                ", editTime='" + editTime + '\'' +
                ", orderId='" + orderId + '\'' +
                ", maskName='" + maskName + '\'' +
                ", maskNo='" + maskNo + '\'' +
                '}';
    }
}
