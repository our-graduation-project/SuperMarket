package com.mxz.supermarket.service;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.model.Salary;

public interface SalaryService {
    /**
     * 增加工资信息
     * @param salary
     * @return
     */
    int addSalary(Salary salary);

    /**
     * 修改工资
     * @param salary
     * @return
     */
    boolean updateSalary(Salary salary);


    /**
     * 根据ID查询工资
     * @param salaryId
     * @return
     */
    Salary searchSalaryBySalaryId(Integer salaryId);

    /**
     * 根据用户名字查询工资
     * @param userName
     * @return
     */
    PageInfo<Salary> searchSalaryByUserName(int page, int limit, String userName);

    /**
     * 查询所有工资
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Salary> searchSalarys(int page, int limit);

    /**
     * 根据ID删除工资
     * @param salaryId
     * @return
     */
    boolean deleteSalary(Integer salaryId);
}
