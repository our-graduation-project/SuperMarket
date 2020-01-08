package com.mxz.supermarket.model;

public class Right {

    private Integer rightId;

    private String rightName;

    private Integer isenabled;

    private Integer rightDesc;

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public Integer getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(Integer isenabled) {
        this.isenabled = isenabled;
    }

    public Integer getRightDesc() {
        return rightDesc;
    }

    public void setRightDesc(Integer rightDesc) {
        this.rightDesc = rightDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rightId=").append(rightId);
        sb.append(", rightName=").append(rightName);
        sb.append(", isenabled=").append(isenabled);
        sb.append(", rightDesc=").append(rightDesc);
        sb.append("]");
        return sb.toString();
    }
}