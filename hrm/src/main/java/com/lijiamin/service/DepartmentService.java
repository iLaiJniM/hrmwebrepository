package com.lijiamin.service;

import com.lijiamin.model.Department;

import java.util.List;

/**
 * Created by 31543 on 2018/10/22.
 */
public interface DepartmentService {
    Boolean insertDepartment(Department department);    //����
    Boolean deleteDepartment(Integer department_id);    //ɾ����
    Boolean updateDepartment(Department department);    //�Ĳ���
    Department queryDepartment(Department department);   //�鲿��
    List<Department> queryDepartmentAll();  //�����в���
}
