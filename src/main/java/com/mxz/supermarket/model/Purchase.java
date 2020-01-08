package com.mxz.supermarket.model;

import java.math.BigDecimal;
import java.util.Date;

public class Purchase {

    private Integer purchaseId;

    private String purchaseName;

    private String productName;

    private String typeName;

    private BigDecimal purchasePrice;

    private Integer purchaseCount;

    private Date purchaseTime;

    private Integer paymenttype;

    private String remark1;

    private String remark2;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(Integer purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Integer getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(Integer paymenttype) {
        this.paymenttype = paymenttype;
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
        sb.append(", purchaseName=").append(purchaseName);
        sb.append(", purchaseTime=").append(purchaseTime);
        sb.append(", purchasePrice=").append(purchasePrice);
        sb.append(", purchaseCount=").append(purchaseCount);
        sb.append(", productName=").append(productName);
        sb.append(", paymenttype=").append(paymenttype);
        sb.append(", typeName=").append(typeName);
        sb.append("]");
        return sb.toString();
    }
}