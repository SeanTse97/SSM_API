package edu.dgut.domain;

public class Mask2 {
    String MaskName;
    long editTime;
    int MaskNo;
    String imageUrl;

    public Mask2() {
    }

    public Mask2(String maskName, long editTime, int maskNo, String imageUrl) {
        MaskName = maskName;
        this.editTime = editTime;
        MaskNo = maskNo;
        this.imageUrl = imageUrl;
    }

    public String getMaskName() {
        return MaskName;
    }

    public void setMaskName(String maskName) {
        MaskName = maskName;
    }

    public long getEditTime() {
        return editTime;
    }

    public void setEditTime(long editTime) {
        this.editTime = editTime;
    }

    public int getMaskNo() {
        return MaskNo;
    }

    public void setMaskNo(int maskNo) {
        MaskNo = maskNo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Mask2{" +
                "MaskName='" + MaskName + '\'' +
                ", editTime=" + editTime +
                ", MaskNo=" + MaskNo +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
