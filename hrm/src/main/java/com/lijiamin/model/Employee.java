package com.lijiamin.model;

import java.io.Serializable;

/**
 * Created by 31543 on 2018/10/26.
 */
public class Employee implements Serializable {
    private Integer employee_id;    //Ա��id
    private String employee_loginname;    //Ա����¼��
    private String employee_pass;    //Ա����½����
    private String employee_name;    //Ա������
    private String employee_phone;    //Ա���绰
    private String employee_sex;    //Ա���Ա�
    private Integer employee_departid;    //Ա������id
    private Integer employee_positionid;    //Ա��ְλid
    private Integer employee_salary;    //Ա��нˮ
    private Integer employee_state;    //Ա���Ƿ���ְ��1��ְ��0��ְ��
    private Integer employee_age;    //Ա������

    public Employee() {
    }

    public Employee(String employee_loginname, String employee_pass, String employee_name, String employee_phone, String employee_sex, Integer employee_departid, Integer employee_positionid, Integer employee_salary, Integer employee_state, Integer employee_age) {
        this.employee_loginname = employee_loginname;
        this.employee_pass = employee_pass;
        this.employee_name = employee_name;
        this.employee_phone = employee_phone;
        this.employee_sex = employee_sex;
        this.employee_departid = employee_departid;
        this.employee_positionid = employee_positionid;
        this.employee_salary = employee_salary;
        this.employee_state = employee_state;
        this.employee_age = employee_age;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_loginname() {
        return employee_loginname;
    }

    public void setEmployee_loginname(String employee_loginname) {
        this.employee_loginname = employee_loginname;
    }

    public String getEmployee_pass() {
        return employee_pass;
    }

    public void setEmployee_pass(String employee_pass) {
        this.employee_pass = employee_pass;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_sex() {
        return employee_sex;
    }

    public void setEmployee_sex(String employee_sex) {
        this.employee_sex = employee_sex;
    }

    public Integer getEmployee_departid() {
        return employee_departid;
    }

    public void setEmployee_departid(Integer employee_departid) {
        this.employee_departid = employee_departid;
    }

    public Integer getEmployee_positionid() {
        return employee_positionid;
    }

    public void setEmployee_positionid(Integer employee_positionid) {
        this.employee_positionid = employee_positionid;
    }

    public Integer getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getEmployee_state() {
        return employee_state;
    }

    public void setEmployee_state(Integer employee_state) {
        this.employee_state = employee_state;
    }

    public Integer getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Integer employee_age) {
        this.employee_age = employee_age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employee_loginname='" + employee_loginname + '\'' +
                ", employee_pass='" + employee_pass + '\'' +
                ", employee_name='" + employee_name + '\'' +
                ", employee_phone=" + employee_phone +
                ", employee_sex='" + employee_sex + '\'' +
                ", employee_departid=" + employee_departid +
                ", employee_positionid=" + employee_positionid +
                ", employee_salary=" + employee_salary +
                ", employee_state=" + employee_state +
                ", employee_age=" + employee_age +
                '}';
    }
}
