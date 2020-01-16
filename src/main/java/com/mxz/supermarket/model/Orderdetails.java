package com.mxz.supermarket.model;

public class Orderdetails {

    private Integer detailsId;

    private String orderNo;

    private String productName;

    private String typeName;

    private Integer ordersCount;

    private Double sumPrice;

    private Double salePrice;

    private String productCode;

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Integer getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", detailsId=").append(detailsId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", productName=").append(productName);
        sb.append(", productCode=").append(productCode);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", ordersCount=").append(ordersCount);
        sb.append(", sumPrice=").append(sumPrice);
        sb.append(", typeName=").append(typeName);
        sb.append("]");
        return sb.toString();
    }
}