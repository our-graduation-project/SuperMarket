package com.mxz.supermarket.model;

public class Salary {

    private Integer salaryId;

    private String salaryName;

    private String userName;

    private String email;

    private String role;

    private Integer salaryCount;

    private String remark1;

    private String remark2;

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public String getSalaryName() {
        return salaryName;
    }

    public void setSalaryName(String salaryName) {
        this.salaryName = salaryName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getSalaryCount() {
        return salaryCount;
    }

    public void setSalaryCount(Integer salaryCount) {
        this.salaryCount = salaryCount;
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
        sb.append(", salaryId=").append(salaryId);
        sb.append(", salaryName=").append(salaryName);
        sb.append(", salaryCount=").append(salaryCount);
        sb.append(", userName=").append(userName);
        sb.append(", email=").append(email);
        sb.append(", role=").append(role);
        sb.append("]");
        return sb.toString();
    }
}