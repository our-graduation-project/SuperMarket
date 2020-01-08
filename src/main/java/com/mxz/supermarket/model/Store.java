package com.mxz.supermarket.model;

import java.util.Date;

public class Store {

    private Integer storeId;

    private String productName;

    private String typeName;

    private Integer storeCount;

    private String storeName;

    private Date instoreTime;

    private String remark1;

    private String remark2;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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

    public Integer getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(Integer storeCount) {
        this.storeCount = storeCount;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getInstoreTime() {
        return instoreTime;
    }

    public void setInstoreTime(Date instoreTime) {
        this.instoreTime = instoreTime;
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
        sb.append(", storeId=").append(storeId);
        sb.append(", storeName=").append(storeName);
        sb.append(", storeCount=").append(storeCount);
        sb.append(", productName=").append(productName);
        sb.append(", typeName=").append(typeName);
        sb.append(", instoreTime=").append(instoreTime);
        sb.append("]");
        return sb.toString();
    }
}