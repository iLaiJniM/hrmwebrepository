package com.lijiamin.service;

import com.lijiamin.model.Department;

import java.util.List;

/**
 * Created by 31543 on 2018/10/22.
 */
public interface DepartmentService {
    Boolean insertDepartment(Department department);    //添部门
    Boolean deleteDepartment(Integer department_id);    //删部门
    Boolean updateDepartment(Department department);    //改部门
    Department queryDepartment(Department department);   //查部门
    List<Department> queryDepartmentAll();  //查所有部门
}
