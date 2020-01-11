package com.mxz.supermarket.model;

import java.util.Date;

public class Purchase {

    private Integer purchaseId;

    private String purchaseNo;

    private Integer sumPrice;

    private Integer userId;

    private Date purchaseTime;

    private String remark1;

    private String remark2;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public Integer getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Integer sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", purchaseId=").append(purchaseId);
        sb.append(", purchaseNo=").append(purchaseNo);
        sb.append(", purchaseTime=").append(purchaseTime);
        sb.append(", sumPrice=").append(sumPrice);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}