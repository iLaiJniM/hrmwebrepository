package com.lijiamin.dao;

import com.lijiamin.model.Employee;

import java.util.List;

/**
 * Created by 31543 on 2018/10/26.
 */
public interface EmployeeDao {
    Integer insertEmployee(Employee employee);    //��Ա��
    Integer updateEmployee(Employee employee);    //��Ա��
    Employee queryEmployeeByEmployee_id(Integer employee_id);   //����Ա��id��Ա��
}
