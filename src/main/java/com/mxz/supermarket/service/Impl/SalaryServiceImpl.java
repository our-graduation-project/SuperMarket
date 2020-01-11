package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.mapper.SalaryMapper;
import com.mxz.supermarket.model.Salary;
import com.mxz.supermarket.model.SalaryExample;
import com.mxz.supermarket.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper mapper;

    /**
     * 增加工资信息
     * @param salary
     * @return
     */
    @Override
    public int addSalary(Salary salary) {
        return mapper.insert(salary);
    }

    /**
     * 修改工资信息
     * @param salary
     * @return
     */
    @Override
    public boolean updateSalary(Salary salary) {
        int i = mapper.updateByPrimaryKeySelective(salary);
        return i > 0 ? true : false;
    }

    /**
     * 根据ID查询工资信息
     * @param salaryId
     * @return
     */
    @Override
    public Salary searchSalaryBySalaryId(Integer salaryId) {
        Salary salary = mapper.selectByPrimaryKey(salaryId);
        return salary;
    }

    /**
     * 根据用户名查询工资
     * @param page
     * @param limit
     * @param userName
     * @return
     */
    @Override
    public PageInfo<Salary> searchSalaryByUserName(int page, int limit, String userName) {
        SalaryExample example=new SalaryExample();
        example.or().andUserNameEqualTo(userName);
        PageHelper.startPage(page, limit);
        List<Salary> salaries = mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(salaries,3);
        return pageInfo;
    }

    /**
     * 查询所有工资信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Salary> searchSalarys(int page, int limit) {
        SalaryExample example=new SalaryExample();
        example.or();
        PageHelper.startPage(page, limit);
        List<Salary> salaries = mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(salaries,3);
        return pageInfo;
    }

    /**
     * 根据ID删除
     * @param salaryId
     * @return
     */
    @Override
    public boolean deleteSalary(Integer salaryId) {
        int i = mapper.deleteByPrimaryKey(salaryId);
        return i>0?true:false;
    }
}
