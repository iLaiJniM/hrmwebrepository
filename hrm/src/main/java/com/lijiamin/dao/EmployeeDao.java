package com.lijiamin.dao;

import com.lijiamin.model.Employee;

import java.util.List;

/**
 * Created by 31543 on 2018/10/26.
 */
public interface EmployeeDao {
    Integer insertEmployee(Employee employee);    //添员工
    Integer updateEmployee(Employee employee);    //改员工
    Employee queryEmployeeByEmployee_id(Integer employee_id);   //根据员工id查员工
}
