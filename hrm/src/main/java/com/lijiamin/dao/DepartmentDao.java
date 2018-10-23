package com.lijiamin.dao;

import com.lijiamin.model.Department;

import java.util.List;

/**
 * Created by 31543 on 2018/10/22.
 */
public interface DepartmentDao {
    Integer insertDepartment(Department department);    //����
    Integer deleteDepartment(Integer department_id);    //ɾ����
    Integer updateDepartment(Department department);    //�Ĳ���
    Department queryDepartment(Department department);   //�鲿��
    List<Department> queryDepartmentAll();  //�����в���
}
