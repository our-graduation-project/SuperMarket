package com.mxz.supermarket.model;

public class Productshelf {

    private Integer shelfId;

    private String shelfName;

    private String shelfPosition;

    private String productName;

    private Integer shelfCount;

    private Integer salePrice;

    private String remark1;

    private String remark2;

    public Integer getShelfId() {
        return shelfId;
    }

    public void setShelfId(Integer shelfId) {
        this.shelfId = shelfId;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public String getShelfPosition() {
        return shelfPosition;
    }

    public void setShelfPosition(String shelfPosition) {
        this.shelfPosition = shelfPosition;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getShelfCount() {
        return shelfCount;
    }

    public void setShelfCount(Integer shelfCount) {
        this.shelfCount = shelfCount;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
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
        sb.append(", shelfId=").append(shelfId);
        sb.append(", shelfName=").append(shelfName);
        sb.append(", shelfCount=").append(shelfCount);
        sb.append(", shelfPosition=").append(shelfPosition);
        sb.append(", productName=").append(productName);
        sb.append(", salePrice=").append(salePrice);
        sb.append("]");
        return sb.toString();
    }
}