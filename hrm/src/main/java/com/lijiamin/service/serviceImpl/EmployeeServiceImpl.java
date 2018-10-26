package com.lijiamin.service.serviceImpl;

import com.lijiamin.dao.EmployeeDao;
import com.lijiamin.model.Employee;
import com.lijiamin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 31543 on 2018/10/26.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public boolean insertEmployee(Employee employee) {
        if(null != employee){
            Integer i = employeeDao.insertEmployee(employee);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }
}
