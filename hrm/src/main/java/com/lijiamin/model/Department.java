package com.lijiamin.model;

import java.io.Serializable;

/**
 * Created by 31543 on 2018/10/22.
 */
public class Department implements Serializable {
    private Integer department_id;
    private String department_name;
    private String department_createtime;

    public Department() {
    }

    public Department(Integer department_id) {
        this.department_id = department_id;
    }

    public Department(String department_name) {
        this.department_name = department_name;
    }

    public Department(String department_name, String department_createtime) {
        this.department_name = department_name;
        this.department_createtime = department_createtime;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_createtime() {
        return department_createtime;
    }

    public void setDepartment_createtime(String department_createtime) {
        this.department_createtime = department_createtime;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", department_createtime='" + department_createtime + '\'' +
                '}';
    }
}
