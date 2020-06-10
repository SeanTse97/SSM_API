package edu.dgut.domain;

public class Record {
    String applyId;
    String userName;
    String userId;
    String maskName;
    String maskNo;
    int count;
    long addTime;
    long editTime;
    String applyStatus; //pass or refuse
    String remark;

    public Record() {
    }

    public Record(String applyId, String userName, String userId, String maskName, String maskNo, int count, long addTime, long editTime, String applyStatus, String remark) {
        this.applyId = applyId;
        this.userName = userName;
        this.userId = userId;
        this.maskName = maskName;
        this.maskNo = maskNo;
        this.count = count;
        this.addTime = addTime;
        this.editTime = editTime;
        this.applyStatus = applyStatus;
        this.remark = remark;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMaskName() {
        return maskName;
    }

    public void setMaskName(String maskName) {
        this.maskName = maskName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMaskNo() {
        return maskNo;
    }

    public void setMaskNo(String maskNo) {
        this.maskNo = maskNo;
    }

    @Override
    public String toString() {
        return "Record{" +
                "applyId='" + applyId + '\'' +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", maskName='" + maskName + '\'' +
                ", maskNo='" + maskNo + '\'' +
                ", count=" + count +
                ", addTime=" + addTime +
                ", editTime=" + editTime +
                ", applyStatus='" + applyStatus + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
