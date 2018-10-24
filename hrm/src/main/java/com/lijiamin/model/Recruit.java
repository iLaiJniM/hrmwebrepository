package com.lijiamin.model;

import java.io.Serializable;

/**
 * Created by 31543 on 2018/10/23.
 */
public class Recruit implements Serializable {
    private Integer recruit_id; //��Ƹid
    private Integer recruit_department_id;  //��Ƹ����id
    private String recruit_department_name; //��Ƹ������
    private Integer recruit_position_id;    //��Ƹְλid
    private String recruit_position_name;   //��Ƹְλ��
    private Integer recruit_salary; //��Ƹнˮ
    private String recruit_createtime;  //��Ƹ����ʱ��
    private Integer recruit_state; //��Ƹ����״̬

    public Recruit() {
    }

    public Recruit(Integer recruit_department_id) {
        this.recruit_department_id = recruit_department_id;
    }

    public Recruit(Integer recruit_department_id, String recruit_department_name, Integer recruit_position_id, String recruit_position_name, Integer recruit_salary, String recruit_createtime) {
        this.recruit_department_id = recruit_department_id;
        this.recruit_department_name = recruit_department_name;
        this.recruit_position_id = recruit_position_id;
        this.recruit_position_name = recruit_position_name;
        this.recruit_salary = recruit_salary;
        this.recruit_createtime = recruit_createtime;
    }

    public Integer getRecruit_id() {
        return recruit_id;
    }

    public void setRecruit_id(Integer recruit_id) {
        this.recruit_id = recruit_id;
    }

    public Integer getRecruit_department_id() {
        return recruit_department_id;
    }

    public void setRecruit_department_id(Integer recruit_department_id) {
        this.recruit_department_id = recruit_department_id;
    }

    public String getRecruit_department_name() {
        return recruit_department_name;
    }

    public void setRecruit_department_name(String recruit_department_name) {
        this.recruit_department_name = recruit_department_name;
    }

    public Integer getRecruit_position_id() {
        return recruit_position_id;
    }

    public void setRecruit_position_id(Integer recruit_position_id) {
        this.recruit_position_id = recruit_position_id;
    }

    public String getRecruit_position_name() {
        return recruit_position_name;
    }

    public void setRecruit_position_name(String recruit_position_name) {
        this.recruit_position_name = recruit_position_name;
    }

    public Integer getRecruit_salary() {
        return recruit_salary;
    }

    public void setRecruit_salary(Integer recruit_salary) {
        this.recruit_salary = recruit_salary;
    }

    public String getRecruit_createtime() {
        return recruit_createtime;
    }

    public void setRecruit_createtime(String recruit_createtime) {
        this.recruit_createtime = recruit_createtime;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "recruit_id=" + recruit_id +
                ", recruit_department_id=" + recruit_department_id +
                ", recruit_department_name='" + recruit_department_name + '\'' +
                ", recruit_position_id=" + recruit_position_id +
                ", recruit_position_name='" + recruit_position_name + '\'' +
                ", recruit_salary=" + recruit_salary +
                ", recruit_createtime='" + recruit_createtime + '\'' +
                '}';
    }
}
