package com.lijiamin.service.serviceImpl;

import com.lijiamin.dao.DepartmentDao;
import com.lijiamin.model.Department;
import com.lijiamin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 31543 on 2018/10/23.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public Boolean insertDepartment(Department department) {
        if(null != department){
            Department department1 = new Department();
            department1.setDepartment_name(department.getDepartment_name());
            if(null == departmentDao.queryDepartment(department1)){
                Integer i = departmentDao.insertDepartment(department);
                if(i != null && i > 0 ){
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean deleteDepartment(Integer department_id) {
        if(null != department_id && department_id > 0){
            Integer i = departmentDao.deleteDepartment(department_id);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public Boolean updateDepartment(Department department) {
        if(null != department){
            Integer i = departmentDao.updateDepartment(department);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public Department queryDepartment(Department department) {
        if(null != department){
            return departmentDao.queryDepartment(department);
        }
        return null;
    }

    public List<Department> queryDepartmentAll() {
        List<Department> departmentList = departmentDao.queryDepartmentAll();
        if(departmentList.size() > 0){
            return departmentList;
        }
        return null;
    }
}
